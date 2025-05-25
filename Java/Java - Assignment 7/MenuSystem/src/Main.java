import application.*;
import domain.MenuComponent;


public class Main {
    public static void main(String[] args) {
        // Create menu items
        MenuComponent home = new MenuItem("Home");
        MenuComponent profile = new MenuItem("Profile");
        MenuComponent settings = new MenuItem("Settings");
        MenuComponent logout = new MenuItem("Logout");

        // Create submenus
        SubMenu accountMenu = new SubMenu("Account");
        accountMenu.add(profile);
        accountMenu.add(settings);

        SubMenu mainMenu = new SubMenu("Main Menu");
        mainMenu.add(home);
        mainMenu.add(accountMenu);
        mainMenu.add(logout);

        // Display the full menu
        System.out.println("Application Menu:");
        mainMenu.display("");
    }
}
