package schepachkov.carexpert.model;

import schepachkov.carexpert.model.filter.ExpertFilter;

public class Car {

    private String name;
    private int cost;
    private int hp;
    private Producer producer;
    private ProducerCountry producerCountry;
    private Type type;

    public Car(String name, int cost, int hp, Producer producer, ProducerCountry producerCountry, Type type) {
        this.name = name;
        this.cost = cost;
        this.hp = hp;
        this.producer = producer;
        this.producerCountry = producerCountry;
        this.type = type;
    }

    public boolean isSatisfyExpertFilter(ExpertFilter filter) {
        if (cost >= filter.getCostRange().getMin() && cost <= filter.getCostRange().getMax()) {
            if (hp >= filter.getHpRange().getMin() && hp <= filter.getHpRange().getMax()) {
                if (filter.getProducerList().getList().isEmpty() || filter.getProducerList().getList().contains(producer.ordinal())) {
                    if (filter.getTypeList().getList().isEmpty() || filter.getTypeList().getList().contains(type.ordinal())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ProducerCountry getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(ProducerCountry producerCountry) {
        this.producerCountry = producerCountry;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Автомобиль %s, стоимостью %s рублей, мощностью %s л/с, страна производитель %s, бренд %s, тип %s.", name, cost, hp, producerCountry, producer, type.getName());
    }
}
