package FlightManagement.Enums;

public enum City {
    HANOI("Hanoi"),
    HO_CHI_MINH_CITY("Ho Chi Minh City");

    private final String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
