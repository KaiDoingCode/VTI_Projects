package application;

public class Inventory {
    public boolean checkStock(String itemId) {
        System.out.println("Checking stock for item: " + itemId);
        return true;
    }

    public void reserve(String itemId) {
        System.out.println("Reserving item: " + itemId);
    }
}

