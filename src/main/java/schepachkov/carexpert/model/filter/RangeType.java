package schepachkov.carexpert.model.filter;

import schepachkov.carexpert.constant.Const;

public class RangeType {

    private Integer min;
    private Integer max;

    private RangeType(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public static RangeType create(String range, String separator) {
        if (isValid(range, separator)) {
            String[] values = range.split(separator);
            if (values.length > 1) {
                return new RangeType(Integer.valueOf(values[0].replace("_", "")), Integer.valueOf(values[values.length-1].replace("_", "")));
            }
        }
        return null;
    }

    private static boolean isValid(String range, String separator) {
        return range != null
                && !range.isEmpty()
                && Const.RANGE_SEPARATOR.equals(separator);
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
