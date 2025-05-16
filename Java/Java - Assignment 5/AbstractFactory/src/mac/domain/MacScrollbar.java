package mac.domain;

import gui.domain.Scrollbar;

public class MacScrollbar implements Scrollbar {
    @Override
    public void scroll() {
        System.out.println("Scrolling with Mac Scrollbar");
    }
}
