package model;

public class Bus {
    private int busNumber;
    private int capacity;
    private int bookedSeats;
    private Route route;

    public Bus(int busNumber, int capacity, Route route) {
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.bookedSeats = 0;
        this.route = route;
    }

    
    public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}


	public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
        } else {
            System.out.println("No seats available");
        }
    }

    public void cancelSeat() {
        if (bookedSeats > 0) {
            bookedSeats--;
        } else {
            System.out.println("No bookings to cancel");
        }
    }

    @Override
    public String toString() {
        return "Bus [busNumber=" + busNumber + ", capacity=" + capacity + ", bookedSeats=" + bookedSeats + 
               ", route=" + route + "]";
}
}