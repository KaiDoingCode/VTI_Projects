package gui;

import gui.domain.*;

public class Application {
    private final Button button;
    private final Checkbox checkbox;
    private final Menu menu;
    private final Scrollbar scrollbar;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
        this.menu = factory.createMenu();
        this.scrollbar = factory.createScrollbar();
    }

    public void run() {
        button.paint();
        checkbox.render();
        menu.open();
        scrollbar.scroll();
    }
}
