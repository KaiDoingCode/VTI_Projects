import FlightManagement.AirlineSystem;
import FlightManagement.Entities.Flight;
import FlightManagement.Entities.Passenger;
import FlightManagement.Enums.City;
import Library.Entities.Book;
import Library.Entities.User;
import Library.LibrarySystem;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Library System Demo ---");
        LibrarySystem library = new LibrarySystem();
        User user1 = new User("u1", "Alice");
        Book book1 = new Book("b1", "Java Basics", "John Doe");
        library.addUser(user1);
        library.addBook(book1);
        library.borrowBook("u1", "b1");
        library.showCurrentlyBorrowed();
        library.returnBook("b1");
        library.showReturnedBooks();
        library.findUserBorrowHistory("u1");

        System.out.println("\n--- Airline System Demo ---");
        AirlineSystem airline = new AirlineSystem();
        Passenger passenger1 = new Passenger("p1", "Bob");
        Flight flight1 = new Flight("f1", City.HANOI, City.HO_CHI_MINH_CITY, LocalDateTime.now().plusDays(1), 2);

        airline.addPassenger(passenger1);
        airline.addFlight(flight1);
        airline.bookFlight("p1", "f1");
        airline.printFlightsForPassenger("p1");
        airline.printPassengersOnFlight("f1");
        airline.flightWithMostBookings();
        airline.passengerWithMostFlights();
        airline.listFlightsHanoiToHCMNext3Days();
    }
}