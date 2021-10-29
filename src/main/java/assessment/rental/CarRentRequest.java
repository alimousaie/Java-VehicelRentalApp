package assessment.rental;

import assessment.rental.Path;
import assessment.rental.RentRequest;
import assessment.vehicles.Vehicle;

import java.util.List;

public class CarRentRequest implements RentRequest {
    private Vehicle vehicle;
    private List<Path> trip;
    private boolean usedAc;
    private int numberOfPassenger;

    public CarRentRequest(Vehicle vehicle, List<Path> trip, boolean usedAc, int numberOfPassenger) {
        this.vehicle = vehicle;
        this.trip = trip;
        this.usedAc = usedAc;
        this.numberOfPassenger = numberOfPassenger;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public List<Path> getTrip() {
        return trip;
    }

    @Override
    public boolean isUsedAc() {
        return usedAc;
    }

    @Override
    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }
}
