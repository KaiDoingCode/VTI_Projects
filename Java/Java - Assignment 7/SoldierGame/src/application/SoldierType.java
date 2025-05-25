package application;

public class SoldierType {
    private String weapon;
    private String uniform;

    public SoldierType(String weapon, String uniform) {
        this.weapon = weapon;
        this.uniform = uniform;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing soldier at (" + x + "," + y + ") with weapon: " + weapon + " and uniform: " + uniform);
    }
}

