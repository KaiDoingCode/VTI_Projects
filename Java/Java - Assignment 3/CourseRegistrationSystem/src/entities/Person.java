package entities;

public abstract class Person {
    protected String name;
    protected int id;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }

    public int getId() { return id; }

    public abstract void displayInfo();
}
