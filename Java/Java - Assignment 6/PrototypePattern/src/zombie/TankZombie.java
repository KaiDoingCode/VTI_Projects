package zombie;

public class TankZombie extends Zombie {
    public TankZombie() {
        this.name = "Tank Zombie";
        this.health = 200;
        this.speed = 0;
        this.damage = 20;
    }

    @Override
    public void attack() {
        System.out.println(name + " smashes heavily!");
    }
}
