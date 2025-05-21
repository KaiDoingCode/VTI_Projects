package zombie;
import java.lang.Cloneable;

public abstract class Zombie implements Cloneable {
    protected String name;
    protected int health;
    protected int speed;
    protected int damage;

    public abstract void attack();

    @Override
    public Zombie clone() {
        try {
            return (Zombie) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return name + " [Health=" + health + ", Speed=" + speed + ", Damage=" + damage + "]";
    }
}

