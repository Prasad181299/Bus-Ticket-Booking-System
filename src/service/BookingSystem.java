package service;

import java.util.ArrayList;
import java.util.List;
import model.Bus;
import model.Passenger;
import model.Route;

public class BookingSystem {
    private List<Bus> buses = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();

    // Method to add, view, and manage routes, buses, and passengers

    public void addRoute(Route route) {
        routes.add(route);
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        for (Bus bus : buses) {
            if (bus.getBusNumber() == passenger.getBusNumber()) {
                bus.bookSeat();
            }
        }
    }

    public void viewRoutes() {
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    public void viewBuses() {
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }

    public void viewPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    public void cancelBooking(String passengerName) {
        Passenger foundPassenger = null;
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(passengerName)) {
                foundPassenger = passenger;
                break;
            }
        }
        if (foundPassenger != null) {
            passengers.remove(foundPassenger);
            for (Bus bus : buses) {
                if (bus.getBusNumber() == foundPassenger.getBusNumber()) {
                    bus.cancelSeat();
                }
            }
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Passenger not found!");
        }
    }
}
