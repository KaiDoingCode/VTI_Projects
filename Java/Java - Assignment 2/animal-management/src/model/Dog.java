package model;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " runs on four legs.");
    }
}
