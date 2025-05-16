package gui.domain;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
    Menu createMenu();
    Scrollbar createScrollbar();
}
