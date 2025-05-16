package mac.domain;

import gui.domain.Menu;

public class MacMenu implements Menu {
    @Override
    public void open() {
        System.out.println("Opening Mac Menu");
    }
}
