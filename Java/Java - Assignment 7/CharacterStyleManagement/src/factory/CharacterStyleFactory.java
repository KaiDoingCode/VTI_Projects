package factory;

import application.CharacterStyle;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private static final Map<String, CharacterStyle> styleMap = new HashMap<>();

    public static CharacterStyle getStyle(String font, int size, String color) {
        String key = font + "-" + size + "-" + color;
        if (!styleMap.containsKey(key)) {
            System.out.println("Creating new CharacterStyle: " + key);
            styleMap.put(key, new CharacterStyle(font, size, color));
        }
        return styleMap.get(key);
    }
}
