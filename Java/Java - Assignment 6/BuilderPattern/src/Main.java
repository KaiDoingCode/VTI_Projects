//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: User Builder ===");
        runUserBuilderExample();

        System.out.println("\n=== Exercise 2: Computer Builder ===");
        runComputerBuilderExample();

        System.out.println("\n=== Exercise 3: UI Builder ===");
        runUIBuilderExample();
    }

    private static void runUserBuilderExample() {
        User user = User.builder()
                .username("john_doe")
                .email("john@example.com")
                .age(30)
                .phone("123-456-7890")
                .build();

        System.out.println(user);
    }

    private static void runComputerBuilderExample() {
        Computer computer = Computer.builder("AMD Ryzen 7", 16, 512)
                .graphicCard("NVIDIA GTX 1660")
                .bluetoothEnabled(true)
                .wifiEnabled(true)
                .build();

        System.out.println(computer);
    }

    private static void runUIBuilderExample() {
        UI ui = UIBuilder.create()
                .addLabel("Welcome")
                .addTextField("Username")
                .addTextField("Password")
                .addButton("Login")
                .build();

        ui.render();
    }
}
