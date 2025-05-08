package model;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Tweet!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " flies in the sky.");
    }
}
