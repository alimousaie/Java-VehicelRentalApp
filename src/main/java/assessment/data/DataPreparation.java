package assessment.data;

import assessment.vehicles.Bus;
import assessment.vehicles.Car;
import assessment.rental.Path;
import assessment.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class DataPreparation {

    private static final Map<String, Vehicle> vehicleCache = new HashMap<>();

    static {
        vehicleCache.put("VW Golf-Diesel", new Car("VW Golf", true, 4));
        vehicleCache.put("VW Golf-NON Diesel", new Car("VW Golf", false, 4));
        vehicleCache.put("Scania-Diesel", new Bus("Scania", true, 10));
    }

    /**
     * list of vehicles in the project
     * provide by other services or read from database
     * and we use Injection annotation for this
     * key: vehicle brand - fuel type , example: VW Golf-Diesel
     * value: vehicle object
     */
    public static Map<String, Vehicle> getVehicles(){
        return vehicleCache;
    }

    private static final ChargesOfRate chargeRates;

    static {
        chargeRates = new ChargesOfRate(1.5 , 0.2, 0.1,0.1, 2);
    }

    /**
     * provide by other services or read from database
     * and we use Injection annotation for this
     */
    public static ChargesOfRate getChargesOfRate(){
        return  chargeRates;
    }


    private static final Map<String, Path> pathCache = new HashMap<>();

    static {
        pathCache.put("Prague-Brno", new Path("Prague", "Brno", 200));
        pathCache.put("Prague-Budapest", new Path("Prague", "Budapest", 550));
        pathCache.put("Brno-Viena", new Path("Brno", "Viena", 150));
        pathCache.put("Brno-Budapest", new Path("Brno", "Prague", 350));
    }

    /**
     * a map of 2 cities and their distance
     * provide by other services or read from database
     * and we use Injection annotation for this
     * key: City Pair - example: Prague - Brno
     * value: distance - example: 200 KM
     */
    public static Map<String, Path> getPaths(){
        return pathCache;
    }
}
