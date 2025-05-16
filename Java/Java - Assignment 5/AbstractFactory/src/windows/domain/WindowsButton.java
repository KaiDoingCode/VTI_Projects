package windows.domain;

import gui.domain.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows Button");
    }
}
