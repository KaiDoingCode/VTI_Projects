package FlightManagement;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import FlightManagement.Entities.Booking;
import FlightManagement.Entities.Flight;
import FlightManagement.Entities.Passenger;
import FlightManagement.Enums.City;

public class AirlineSystem {
    List<Flight> flights = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void bookFlight(String passengerId, String flightId) {
        Passenger passenger = passengers.stream().filter(p -> p.id.equals(passengerId)).findFirst().orElse(null);
        Flight flight = flights.stream().filter(f -> f.flightId.equals(flightId)).findFirst().orElse(null);
        if (passenger != null && flight != null && flight.bookings.size() < flight.capacity) {
            boolean alreadyBooked = flight.bookings.stream().anyMatch(b -> b.passenger.id.equals(passengerId));
            if (!alreadyBooked) {
                Booking booking = new Booking(passenger, flight, LocalDateTime.now());
                flight.bookings.add(booking);
                System.out.println(passenger.name + " booked flight " + flight.flightId);
            }
        }
    }

    public void printFlightsForPassenger(String passengerId) {
        flights.stream()
                .filter(f -> f.bookings.stream().anyMatch(b -> b.passenger.id.equals(passengerId)))
                .forEach(f -> System.out.println(f.flightId + " from " + f.origin + " to " + f.destination));
    }

    public void printPassengersOnFlight(String flightId) {
        flights.stream().filter(f -> f.flightId.equals(flightId)).findFirst().ifPresent(f ->
                f.bookings.forEach(b -> System.out.println(b.passenger.name))
        );
    }

    public void flightWithMostBookings() {
        flights.stream().max(Comparator.comparingInt(f -> f.bookings.size())).ifPresent(f ->
                System.out.println("Flight with most bookings: " + f.flightId + " (" + f.bookings.size() + ")")
        );
    }

    public void passengerWithMostFlights() {
        Map<String, Long> countMap = flights.stream()
                .flatMap(f -> f.bookings.stream())
                .collect(Collectors.groupingBy(b -> b.passenger.id, Collectors.counting()));

        countMap.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e -> {
            Passenger p = passengers.stream().filter(pas -> pas.id.equals(e.getKey())).findFirst().orElse(null);
            if (p != null) {
                System.out.println("Passenger with most flights: " + p.name + " (" + e.getValue() + ")");
            }
        });
    }

    public void listFlightsHanoiToHCMNext3Days() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeDaysLater = now.plusDays(3);
        flights.stream()
                .filter(f -> f.origin == City.HANOI && f.destination == City.HO_CHI_MINH_CITY)
                .filter(f -> f.departureTime.isAfter(now) && f.departureTime.isBefore(threeDaysLater))
                .sorted(Comparator.comparing(f -> f.departureTime))
                .forEach(f -> System.out.println(f.flightId + " departs at " + f.departureTime));
    }
}

