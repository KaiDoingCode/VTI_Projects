package service;

import interfaces.Fighter;
import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<Fighter> fighters = new ArrayList<>();

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void startBattle(int rounds) {
        System.out.println("🏹 Battle Begins!");
        for (int r = 1; r <= rounds; r++) {
            System.out.println("\n--- Round " + r + " ---");
            for (Fighter fighter : fighters) {
                if (!fighter.isExhausted()) {
                    fighter.attack();
                } else {
                    System.out.println(fighter.getName() + " skips turn (no energy).");
                }
            }
        }
        System.out.println("\n⚔️ Battle Over!");
    }
}
