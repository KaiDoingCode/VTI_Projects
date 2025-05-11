package entities;

import interfaces.Fighter;

public class Archer implements Fighter {
    private String name;
    private int energy;

    public Archer(String name) {
        this.name = name;
        this.energy = 80;
    }

    @Override
    public void attack() {
        if (energy >= 8) {
            System.out.println(name + " shoots an arrow! (-8 energy)");
            energy -= 8;
        } else {
            System.out.println(name + " is too tired to attack.");
        }
    }

    @Override
    public boolean isExhausted() {
        return energy < 8;
    }

    @Override
    public String getName() {
        return name;
    }
}
