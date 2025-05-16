package windows.domain;

import gui.domain.*;

public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    public Menu createMenu() {
        return new WindowsMenu();
    }

    public Scrollbar createScrollbar() {
        return new WindowsScrollbar();
    }
}
