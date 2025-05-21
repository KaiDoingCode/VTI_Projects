import java.util.ArrayList;
import java.util.List;

public class UIBuilder {
    private final List<String> components = new ArrayList<>();

    public static UIBuilder create() {
        return new UIBuilder();
    }

    public UIBuilder addButton(String label) {
        components.add("Button: " + label);
        return this;
    }

    public UIBuilder addTextField(String placeholder) {
        components.add("TextField: " + placeholder);
        return this;
    }

    public UIBuilder addLabel(String text) {
        components.add("Label: " + text);
        return this;
    }

    public UI build() {
        return new UI(components);
    }
}

class UI {
    private final List<String> elements;

    public UI(List<String> elements) {
        this.elements = elements;
    }

    public void render() {
        System.out.println("Rendering UI:");
        for (String element : elements) {
            System.out.println(" - " + element);
        }
    }
}
