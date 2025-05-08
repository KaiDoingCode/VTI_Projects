package model;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void login();

    public abstract void logout();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
