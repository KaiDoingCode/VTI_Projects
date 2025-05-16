package mac.domain;

import gui.domain.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Mac Button");
    }
}
