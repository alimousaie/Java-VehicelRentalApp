package assessment;

import assessment.rental.Path;
import assessment.rental.InputParser;
import assessment.data.DataPreparation;
import assessment.vehicles.VehicleType;
import assessment.rental.RentRequest;
import assessment.vehicles.Vehicle;

import java.util.List;

/**
 * this class is used for calculating the total expense for a given trip based on these roles:
 * 1. A vehicle can be rented for a trip. Vehicle can be a SUV, a car, a van, a bus, etc.
 * 2. The standard rate for a petrol for a standard trip is 1.5 EUR/Km.
 * 3. Additional 0.2 EUR/Km charge is applicable for vehicles with AC.
 * 4. Diesel vehicles rate is  0.1 EUR less than standard rate.
 * 5. 2% discount is applicable for bus on standard rate.
 * 6. Additional charges of 0.1 EUR/Km/Person are charged if number of passengers exceeds certain limit for a vehicle.
 */
public class VehicleRentCalculation implements RentCalculator {

    /**
     * Calculate total expenses of a rent trip
     *
     * @param carRentTrip Rent trip string which is some information about Vehicle, Trip, Passengers, AC usage
     * @return
     */
    public double calcTotalExpense(String carRentTrip) {
        return calcTotalExpense(InputParser.parse(carRentTrip));
    }

    /**
     * Calculate total expenses of a rent trip
     *
     * @param rentRequest the Interface includes some information about Vehicle, Trip, Passengers, AC usage
     * @return total expense
     */
    public double calcTotalExpense(RentRequest rentRequest) {
        double totalExpense = 0;

        double distance = calcTripDistances(rentRequest.getTrip());
        double baseRate = calcStandardRate(rentRequest.getVehicle());
        double acRate = calcAcRate(rentRequest.isUsedAc());
        double extraPassengerRate = calcExtraPassengerRate(rentRequest.getVehicle(), rentRequest.getNumberOfPassenger());

        double totalRate = baseRate + acRate + extraPassengerRate;

        totalExpense = totalRate * distance;
        return Math.round(totalExpense * 1000) / 1000D;
    }

    /**
     * Add up all the distances traveled
     *
     * @param paths traveled cities
     * @return total distance
     */
    private double calcTripDistances(List<Path> paths) {
        double totalDistance = 0;

        for (Path path : paths) {
            totalDistance += path.getLength();
        }

        return totalDistance;
    }

    /**
     * this method implement rules 2,4,5
     *
     * @param vehicle the vehicle is rented
     * @return base rate
     */
    private double calcStandardRate(Vehicle vehicle) {
        double rate = DataPreparation.getChargesOfRate().getStandardRate();

        if (vehicle.isDiesel()) {
            rate -= DataPreparation.getChargesOfRate().getDieselRate();
        }

        if (vehicle.getVehicleType().equals(VehicleType.BUS)) {
            rate *= (1 - (DataPreparation.getChargesOfRate().getBusDiscount() / 100.0)); // discount
        }

        return Math.round(rate * 1000) / 1000D;
    }

    /**
     * this method implement rule 3
     *
     * @param acUsed in the trip AC was used or not
     * @return AC rate
     */
    private double calcAcRate(boolean acUsed) {
        if (acUsed)
            return DataPreparation.getChargesOfRate().getUseAcRate();

        return 0;
    }

    /**
     * this method implement rules 6
     *
     * @param vehicle         the vehicle is rented
     * @param passengersCount number of passengers in the vehicle
     * @return extra passengers rate
     */
    private double calcExtraPassengerRate(Vehicle vehicle, int passengersCount) {
        int extraPassengers = passengersCount - vehicle.getPassengerLimit();
        double rate = 0;

        if (extraPassengers > 0) {
            rate = DataPreparation.getChargesOfRate().getExtraPassengerRate() * extraPassengers;
        }
        return rate;
    }
}
