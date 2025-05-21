package shape;
import java.lang.Cloneable;

public abstract class Shape implements Cloneable {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract void draw();

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported");
        }
    }
}
