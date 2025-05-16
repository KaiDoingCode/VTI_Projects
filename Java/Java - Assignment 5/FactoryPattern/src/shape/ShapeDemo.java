package shape;

import shape.domain.Shape;
import shape.domain.ShapeFactory;

public class ShapeDemo {
    public static void run() {
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("square");
        s2.draw();
    }
}
