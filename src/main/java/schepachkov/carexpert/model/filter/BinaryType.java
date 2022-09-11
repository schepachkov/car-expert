package schepachkov.carexpert.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BinaryType {

    private static final List<String> PERMITTED_ANSWERS = new ArrayList<>();
    private boolean isAgree;

    static {
        PERMITTED_ANSWERS.add("y");
        PERMITTED_ANSWERS.add("yes");
        PERMITTED_ANSWERS.add("д");
        PERMITTED_ANSWERS.add("да");
        PERMITTED_ANSWERS.add("ок");
        PERMITTED_ANSWERS.add("ok");
        PERMITTED_ANSWERS.add("1");
    }

    public static BinaryType create(String input) {
        BinaryType result = new BinaryType();
        result.isAgree = input != null && PERMITTED_ANSWERS.contains(input.toLowerCase());
        return result;
    }

    public boolean isAgree() {
        return isAgree;
    }

}
