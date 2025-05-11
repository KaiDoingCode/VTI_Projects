package entities;

import interfaces.Fighter;

public class Mage implements Fighter {
    private String name;
    private int energy;

    public Mage(String name) {
        this.name = name;
        this.energy = 60;
    }

    @Override
    public void attack() {
        if (energy >= 15) {
            System.out.println(name + " casts a fireball! (-15 energy)");
            energy -= 15;
        } else {
            System.out.println(name + " is too tired to cast a spell.");
        }
    }

    @Override
    public boolean isExhausted() {
        return energy < 15;
    }

    @Override
    public String getName() {
        return name;
    }
}
