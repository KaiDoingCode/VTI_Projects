package application;

public class Soldier {
    private int x;
    private int y;
    private SoldierType type;

    public Soldier(int x, int y, SoldierType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
