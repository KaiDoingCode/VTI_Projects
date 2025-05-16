package registryfactory;

import registryfactory.domain.*;

public class RegistryDemo {
    public static void run() {
        ProductFactory.register("a", ProductA::new);
        ProductFactory.register("b", ProductB::new);

        Product p1 = ProductFactory.create("a");
        p1.produce();

        Product p2 = ProductFactory.create("b");
        p2.produce();
    }
}
