package shape.domain;

public class ShapeFactory {
    public static Shape getShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("square".equalsIgnoreCase(type)) {
            return new Square();
        }
        throw new IllegalArgumentException("Unknown shape type: " + type);
    }
}
