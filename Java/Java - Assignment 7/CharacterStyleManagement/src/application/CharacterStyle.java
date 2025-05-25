package application;

public class CharacterStyle {
    private String font;
    private int size;
    private String color;

    public CharacterStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void apply(char character, int x, int y) {
        System.out.println("Draw '" + character + "' at (" + x + "," + y + ") using font=" + font + ", size=" + size + ", color=" + color);
    }
}

