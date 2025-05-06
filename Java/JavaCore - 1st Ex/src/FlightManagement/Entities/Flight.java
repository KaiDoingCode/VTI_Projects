package FlightManagement.Entities;

import FlightManagement.Enums.City;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    public String flightId;
    public City origin;
    public City destination;
    public LocalDateTime departureTime;
    public int capacity;
    public List<Booking> bookings = new ArrayList<>();

    public Flight(String flightId, City origin, City destination, LocalDateTime departureTime, int capacity) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
    }
}
