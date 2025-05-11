package entities;

import interfaces.Fighter;

public class Knight implements Fighter {
    private String name;
    private int energy;

    public Knight(String name) {
        this.name = name;
        this.energy = 100;
    }

    @Override
    public void attack() {
        if (energy >= 10) {
            System.out.println(name + " swings a sword! (-10 energy)");
            energy -= 10;
        } else {
            System.out.println(name + " is too tired to attack.");
        }
    }

    @Override
    public boolean isExhausted() {
        return energy < 10;
    }

    @Override
    public String getName() {
        return name;
    }
}
