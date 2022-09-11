package schepachkov.carexpert.model;

public enum Type {

    SEDAN("седан"),
    CUV("джип"),
    SUV("кроссовер"),
    HATCHBACK("хечбек"),
    PICKUP("пикап"),
    COUPE("купе"),
    MINIVAN("минивен"),
    CABRIOLET("кабриолет");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
