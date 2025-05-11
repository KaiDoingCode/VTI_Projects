package entities;

public class Instructor extends Person {

    public Instructor(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor: " + name + ", ID: " + id);
    }
}
