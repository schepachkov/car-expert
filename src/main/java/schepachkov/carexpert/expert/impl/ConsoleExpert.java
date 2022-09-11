package schepachkov.carexpert.expert.impl;

import schepachkov.carexpert.constant.Const;
import schepachkov.carexpert.constant.PhraseConst;
import schepachkov.carexpert.expert.CarExpert;
import schepachkov.carexpert.model.Car;
import schepachkov.carexpert.model.Producer;
import schepachkov.carexpert.model.Type;
import schepachkov.carexpert.model.filter.BinaryType;
import schepachkov.carexpert.model.filter.ExpertFilter;
import schepachkov.carexpert.model.filter.ListType;
import schepachkov.carexpert.model.filter.RangeType;
import schepachkov.carexpert.storage.CarStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleExpert implements CarExpert {

    private final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public void askExpert() {
        try {
            System.out.println(PhraseConst.INTRO_STATEMENT);
            BinaryType introAnswer = askQuestion(PhraseConst.INTRO_QUESTION, BinaryType.class);
            if (introAnswer.isAgree()) {
                ExpertFilter filter = createFilter();
                List<Car> result = applyFilter(filter);
                if (result.isEmpty()) {
                    System.out.println(PhraseConst.RESULT_STATEMENT_NEGATIVE);
                } else {
                    System.out.println(PhraseConst.RESULT_STATEMENT_POSITIVE);
                    beautyPrintResult(result);
                }
            }
            System.out.println(PhraseConst.END_STATEMENT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CONSOLE_READER.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Car> applyFilter(ExpertFilter filter) {
        return CarStorage.getCARS()
                .stream()
                .filter(car -> car.isSatisfyExpertFilter(filter))
                .sorted(Comparator.comparingInt(Car::getCost))
                .collect(Collectors.toList());
    }

    private ExpertFilter createFilter() throws IOException {
        ExpertFilter filter = new ExpertFilter();
        filter.setCostRange(askQuestion(PhraseConst.COST_QUESTION, RangeType.class));
        filter.setHpRange(askQuestion(PhraseConst.HP_QUESTION, RangeType.class));
        filter.setProducerList(askQuestion(PhraseConst.PRODUCER_QUESTION, ListType.class));
        filter.setTypeList(askQuestion(PhraseConst.TYPE_QUESTION, ListType.class));
        return filter;
    }

    private String readLine() throws IOException {
        return CONSOLE_READER.readLine();
    }

    private <T> T askQuestion(String question, Class<T> filterType) throws IOException {
        System.out.println(question);
        printAdditionalHint(question);
        String userString = readLine();
        if (BinaryType.class == filterType) {
            return (T) BinaryType.create(userString);
        } else if (RangeType.class == filterType) {
            return (T) RangeType.create(userString, Const.RANGE_SEPARATOR);
        } else if (ListType.class == filterType) {
            return (T) ListType.create(userString, Const.LIST_SEPARATOR);
        }
        return null;
    }

    private void printAdditionalHint(String question) {
        if (question.equals(PhraseConst.PRODUCER_QUESTION)) {
            beautyPrintProducer();
        } else if (question.equals(PhraseConst.TYPE_QUESTION)) {
            beautyPrintType();
        }
    }

    private void beautyPrintResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(String.format("%s) %s", i + 1, cars.get(i)));
        }
    }

    private void beautyPrintProducer() {
        for (Producer value : Producer.values()) {
            System.out.println(String.format("%s) %s", value.ordinal() + 1, value.name()));
        }
    }

    private void beautyPrintType() {
        for (Type value : Type.values()) {
            System.out.println(String.format("%s) %s", value.ordinal() + 1, value.getName()));
        }
    }

}
