package entities;

import behaviors.*;

public class PeaShooter extends GameObject implements Shooter {

    public PeaShooter(int x, int y) {
        super(100, x, y); // PeaShooter has 100 health
    }

    @Override
    public void shoot(Zombie target) {
        if (target.isAlive()) {
            System.out.println("PeaShooter shoots Zombie!");
            target.takeDamage(20);
        }
    }

    @Override
    public void update() {
        System.out.println("PeaShooter at (" + x + ", " + y + "), Health: " + health);
    }
}

