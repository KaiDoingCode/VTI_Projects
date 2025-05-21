//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import document.*;
import shape.*;
import zombie.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("== Shape Cloning ==");
        Shape circle = new Circle("Red", 10);
        Shape rect = new Rectangle("Blue", 20, 30);
        Shape clonedCircle = circle.clone();
        Shape clonedRect = rect.clone();
        clonedCircle.draw();
        clonedRect.draw();

        System.out.println("\n== Document Cloning ==");
        Image img1 = new Image("img1.png");
        Image img2 = new Image("img2.png");
        Section sec1 = new Section("Intro", "Welcome!", Arrays.asList(img1));
        Section sec2 = new Section("Body", "Details...", Arrays.asList(img2));
        Document doc1 = new Document("My Doc", "Content here", Arrays.asList(sec1, sec2));
        Document doc2 = doc1.clone();
        doc2.print();

        System.out.println("\n== Zombie Cloning ==");
        ZombieRegistry registry = new ZombieRegistry();
        registry.registerZombie("normal", new NormalZombie());
        registry.registerZombie("fast", new FastZombie());
        registry.registerZombie("tank", new TankZombie());

        Zombie z1 = registry.getClone("normal");
        Zombie z2 = registry.getClone("fast");
        Zombie z3 = registry.getClone("tank");

        System.out.println(z1);
        z1.attack();
        System.out.println(z2);
        z2.attack();
        System.out.println(z3);
        z3.attack();
    }
}
