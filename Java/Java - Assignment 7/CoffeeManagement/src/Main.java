import application.*;
import domain.Coffee;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new SugarDecorator(coffee);
        coffee = new MilkDecorator(coffee);
        coffee = new CreamDecorator(coffee);

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());
    }
}
