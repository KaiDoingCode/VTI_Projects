package application;

import domain.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }
}
