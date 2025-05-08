package model;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " walks silently and gracefully.");
    }
}
