package schepachkov.carexpert.model.filter;

import schepachkov.carexpert.constant.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListType {

    private List<Integer> ordinals = new ArrayList<>();

    public static ListType create(String input, String separator) {
        ListType result = new ListType();
        if (isValid(input, separator)) {
            result.ordinals.addAll(
                    Arrays.stream(input.split(separator))
                            .map(Integer::valueOf)
                            .map(ordinal -> ordinal - 1)
                            .collect(Collectors.toList())
            );
        }
        return result;
    }

    private static boolean isValid(String input, String separator) {
        return input != null
                && !input.isEmpty()
                && Const.LIST_SEPARATOR.equals(separator);
    }

    public List<Integer> getList() {
        return ordinals;
    }
}
