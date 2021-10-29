import assessment.VehicleRentCalculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleRentalTest {

    /**
     * your test case
     * "VW Golf, Diesel, NON AC, Prague-Brno-Budapest-Prague, 3 Passengers"
     */
    @Test
    void dieselCarWithoutAnyExtraRate() {
        VehicleRentCalculation vehicleRent = new VehicleRentCalculation();
        double expense = vehicleRent.calcTotalExpense("VW Golf, Diesel, NON AC, Prague-Brno-Budapest-Prague, 3 Passengers");
        Assertions.assertEquals(1540, expense);
    }

    /**
     * a fuel of car is not diesel and use AC
     * "VW Golf, NON Diesel, AC, Prague-Brno-Budapest-Prague, 4 Passengers"
     */
    @Test
    void ordinaryCarWithAC() {
        VehicleRentCalculation vehicleRent = new VehicleRentCalculation();
        double expense = vehicleRent.calcTotalExpense("VW Golf, NON Diesel, AC, Prague-Brno-Budapest-Prague, 4 Passengers");
        Assertions.assertEquals(1870, expense);
    }

    /**
     * a bus with diesel fuel and ac and extra 5 passengers
     * "Scania, Diesel, AC, Prague-Brno-Budapest-Prague, 15 Passengers"
     */
    @Test
    void dieselBusWithAcAndExtraPassenger() {
        VehicleRentCalculation vehicleRent = new VehicleRentCalculation();
        double expense = vehicleRent.calcTotalExpense("Scania, Diesel, AC, Prague-Brno-Budapest-Prague, 15 Passengers");
        Assertions.assertEquals(2279.2, expense);
    }
}