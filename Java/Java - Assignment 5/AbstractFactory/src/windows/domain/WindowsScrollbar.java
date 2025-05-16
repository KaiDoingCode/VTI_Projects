package windows.domain;

import gui.domain.Scrollbar;

public class WindowsScrollbar implements Scrollbar {
    @Override
    public void scroll() {
        System.out.println("Scrolling with Windows Scrollbar");
    }
}
