package schepachkov.carexpert.storage;

import schepachkov.carexpert.model.Car;
import schepachkov.carexpert.model.Producer;
import schepachkov.carexpert.model.ProducerCountry;
import schepachkov.carexpert.model.Type;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {

    private static final List<Car> CARS = new ArrayList<>();

    static {
        CARS.add(new Car("BMW 320i", 1_000, 156, Producer.BMW, ProducerCountry.GERMANY, Type.SEDAN));
        CARS.add(new Car("Mercedes E400", 3_000, 340, Producer.MERCEDES, ProducerCountry.GERMANY, Type.SEDAN));
        CARS.add(new Car("Audi A5", 2_000, 190, Producer.AUDI, ProducerCountry.GERMANY, Type.COUPE));
        CARS.add(new Car("Toyota Prado", 4_000, 230, Producer.TOYOTA, ProducerCountry.JAPAN, Type.CUV));
        CARS.add(new Car("Toyota RAV4", 3_000, 200, Producer.TOYOTA, ProducerCountry.JAPAN, Type.SUV));
        CARS.add(new Car("Kia optima", 1_400, 180, Producer.KIA, ProducerCountry.KOREA, Type.SEDAN));
        CARS.add(new Car("Toyota camry", 2_500, 249, Producer.TOYOTA, ProducerCountry.JAPAN, Type.SEDAN));
        CARS.add(new Car("Mercedes V-class", 4_500, 170, Producer.MERCEDES, ProducerCountry.GERMANY, Type.MINIVAN));
        CARS.add(new Car("BMW M2", 4_500, 410, Producer.BMW, ProducerCountry.GERMANY, Type.COUPE));
        CARS.add(new Car("Lada priora", 600, 98, Producer.LADA, ProducerCountry.RUSSIA, Type.HATCHBACK));
        CARS.add(new Car("Lada priora", 600, 98, Producer.LADA, ProducerCountry.RUSSIA, Type.SEDAN));
        CARS.add(new Car("Lada granta", 700, 106, Producer.LADA, ProducerCountry.RUSSIA, Type.SEDAN));
    }

    public static List<Car> getCARS() {
        return CARS;
    }
}
