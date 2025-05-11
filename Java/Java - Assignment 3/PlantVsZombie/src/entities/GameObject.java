package entities;

public abstract class GameObject {
    protected int health;
    protected int x;
    protected int y;

    public GameObject(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public abstract void update();
}
