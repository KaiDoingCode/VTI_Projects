//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import application.*;
import factory.SoldierTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();

        SoldierType riflemanType = SoldierTypeFactory.getSoldierType("Rifle", "Green Uniform");

        soldiers.add(new Soldier(10, 20, riflemanType));
        soldiers.add(new Soldier(15, 25, riflemanType));
        soldiers.add(new Soldier(30, 35, riflemanType));

        SoldierType sniperType = SoldierTypeFactory.getSoldierType("Sniper", "Camouflage");

        soldiers.add(new Soldier(50, 60, sniperType));
        soldiers.add(new Soldier(55, 65, sniperType));

        for (Soldier s : soldiers) {
            s.draw();
        }
    }
}
