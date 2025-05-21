package zombie;

public class FastZombie extends Zombie {
    public FastZombie() {
        this.name = "Fast Zombie";
        this.health = 70;
        this.speed = 3;
        this.damage = 8;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks swiftly!");
    }
}
