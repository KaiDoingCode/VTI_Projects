package FlightManagement.Entities;

import java.time.LocalDateTime;

public class Booking {
    public Passenger passenger;
    Flight flight;
    LocalDateTime bookingTime;

    public Booking(Passenger passenger, Flight flight, LocalDateTime bookingTime) {
        this.passenger = passenger;
        this.flight = flight;
        this.bookingTime = bookingTime;
    }
}
