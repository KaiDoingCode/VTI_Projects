package application;

public class Character {
    private char value;
    private int x;
    private int y;
    private CharacterStyle style;

    public Character(char value, int x, int y, CharacterStyle style) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public void render() {
        style.apply(value, x, y);
    }
}
