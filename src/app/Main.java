package app;

import java.util.Scanner;
import model.Bus;
import model.Passenger;
import model.Route;
import service.BookingSystem;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Route");
            System.out.println("2. Add Bus");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Routes");
            System.out.println("5. View Buses");
            System.out.println("6. View Passengers");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter route ID: ");
                    int routeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter starting point: ");
                    String startingPoint = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter fare: ");
                    double fare = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Route route = new Route(routeId, startingPoint, destination, fare);
                    system.addRoute(route);
                    System.out.println("Route added successfully.");
                    break;
                case 2:
                    System.out.print("Enter bus number: ");
                    int busNumber = scanner.nextInt();
                    System.out.print("Enter capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter route ID: ");
                    routeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Route selectedRoute = system.getRoutes().stream()
                                  .filter(r -> r.getRouteId() == routeId)
                                  .findFirst()
                                  .orElse(null);
                    if (selectedRoute != null) {
                        Bus bus = new Bus(busNumber, capacity, selectedRoute);
                        system.addBus(bus);
                        System.out.println("Bus added successfully.");
                    } else {
                        System.out.println("Route not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter bus number: ");
                    int busNum = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Bus bus = system.getBuses().stream()
                                    .filter(b -> b.getBusNumber() == busNum)
                                    .findFirst()
                                    .orElse(null);
                    if (bus != null) {
                        Passenger passenger = new Passenger(name, age, busNum);
                        system.addPassenger(passenger);
                        double ticketFare = bus.getRoute().getFare();
                        System.out.println("Ticket booked successfully. Fare: " + ticketFare);
                    } else {
                        System.out.println("Bus not found!");
                    }
                    break;
                case 4:
                    system.viewRoutes();
                    break;
                case 5:
                    system.viewBuses();
                    break;
                case 6:
                    system.viewPassengers();
                    break;
                case 7:
                    System.out.print("Enter passenger name to cancel booking: ");
                    String passengerName = scanner.nextLine();
                    system.cancelBooking(passengerName);
                    break;
                case 8:
                    System.out.println("Exited Successfully");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
