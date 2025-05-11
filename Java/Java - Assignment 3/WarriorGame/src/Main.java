//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import service.BattleField;
import entities.Knight;
import entities.Archer;
import entities.Mage;

public class Main {
    public static void main(String[] args) {
        BattleField battleField = new BattleField();

        battleField.addFighter(new Knight("Arthur"));
        battleField.addFighter(new Archer("Robin"));
        battleField.addFighter(new Mage("Merlin"));

        battleField.startBattle(5);
    }
}