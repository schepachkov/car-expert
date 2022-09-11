package schepachkov.carexpert;

import schepachkov.carexpert.expert.CarExpert;
import schepachkov.carexpert.expert.impl.ConsoleExpert;

public class Main {

    public static void main(String[] args) {
        CarExpert carExpert = new ConsoleExpert();
        carExpert.askExpert();
    }
}
