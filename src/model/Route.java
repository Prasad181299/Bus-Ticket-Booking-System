package model;

public class Route {
    private int routeId;
    private String startingPoint;
    private String destination;
    private double fare;

    public Route(int routeId, String startingPoint, String destination, double fare) {
        this.routeId = routeId;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.fare = fare;
    }

    // Getters and Setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Route [routeId=" + routeId + ", startingPoint=" + startingPoint + ", destination=" + destination + 
               ", fare=" + fare + "]";
    }
}
