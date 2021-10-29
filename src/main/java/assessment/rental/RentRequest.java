package assessment.rental;

import assessment.vehicles.Vehicle;

import java.util.List;

/**
 * When any vehicle is rented, at the end of the trip a request is generated
 * to calculate the rate of rent and all parameters are packed in this interface and
 * are sent to VehicleRentCalculation class
 */
public interface RentRequest {
    /**
     * information about vehicle
     * @return
     */
    Vehicle getVehicle();

    /**
     * trip path
     * example: Prague-Brno-Budapest-Prague
     * @return
     */
    List<Path> getTrip();

    /***
     * indicates that whether AC is Used in the trip or not
     * @return AC usage condition
     */
    boolean isUsedAc();

    /**
     * number of passengers in the vehicle
     * @return
     */
    int getNumberOfPassenger();
}
