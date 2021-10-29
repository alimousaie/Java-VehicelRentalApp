package assessment.vehicles;

/**
 * Base interface for any type of vehicles
 */
public interface Vehicle {
    /**
     * Vehicle Brand or Model
     * @return Brand name
     */
    String getModel();

    /**
     * Type of vehicle
     * @return
     */
    VehicleType getVehicleType();

    /**
     * indicate it is Diesel or not
     * @return
     */
    boolean isDiesel();

    /**
     * number of passengers can sit in a vehicle
     * @return
     */
    int getPassengerLimit();
}
