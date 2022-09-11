package schepachkov.carexpert.model.filter;

public class ExpertFilter {

    private RangeType costRange;
    private RangeType hpRange;
    private ListType producerList;
    private ListType typeList;

    public RangeType getCostRange() {
        return costRange;
    }

    public void setCostRange(RangeType costRange) {
        this.costRange = costRange;
    }

    public RangeType getHpRange() {
        return hpRange;
    }

    public void setHpRange(RangeType hpRange) {
        this.hpRange = hpRange;
    }

    public ListType getProducerList() {
        return producerList;
    }

    public void setProducerList(ListType producerList) {
        this.producerList = producerList;
    }

    public ListType getTypeList() {
        return typeList;
    }

    public void setTypeList(ListType typeList) {
        this.typeList = typeList;
    }
}
