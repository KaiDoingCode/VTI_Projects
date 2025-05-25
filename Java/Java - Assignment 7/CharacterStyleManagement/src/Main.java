//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import application.*;
import application.Character;
import factory.CharacterStyleFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> text = new ArrayList<>();

        // Shared style
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", 12, "Black");
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Courier", 14, "Blue");

        // Create characters with different positions
        text.add(new Character('H', 0, 0, style1));
        text.add(new Character('e', 1, 0, style1));
        text.add(new Character('l', 2, 0, style1));
        text.add(new Character('l', 3, 0, style1));
        text.add(new Character('o', 4, 0, style1));

        text.add(new Character('!', 5, 0, style2));

        // Render all characters
        for (Character c : text) {
            c.render();
        }
    }
}
