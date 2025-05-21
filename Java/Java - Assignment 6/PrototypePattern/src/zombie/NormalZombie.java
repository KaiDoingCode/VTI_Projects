package zombie;

public class NormalZombie extends Zombie {
    public NormalZombie() {
        this.name = "Normal Zombie";
        this.health = 100;
        this.speed = 1;
        this.damage = 10;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks slowly!");
    }
}
