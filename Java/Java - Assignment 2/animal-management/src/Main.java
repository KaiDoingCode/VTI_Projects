//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.*;
import service.Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        zoo.addAnimal(new Dog("Buddy"));
        zoo.addAnimal(new Cat("Whiskers"));
        zoo.addAnimal(new Bird("Tweety"));
        zoo.addAnimal(new Dog("Max"));

        zoo.showAllAnimalActions();
        zoo.showAnimalCountByType();
    }
}