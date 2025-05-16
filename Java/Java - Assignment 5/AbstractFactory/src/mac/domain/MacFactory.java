package mac.domain;

import gui.domain.*;

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    public Menu createMenu() {
        return new MacMenu();
    }

    public Scrollbar createScrollbar() {
        return new MacScrollbar();
    }
}
