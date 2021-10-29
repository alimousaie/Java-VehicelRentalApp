package assessment.rental;

import assessment.data.DataPreparation;
import assessment.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * extract data from any rent trip and return an object of RentRequest
 * for example: a rent trip is "VW Golf, Diesel, NON AC, Prague-Brno-Budapest-Prague, 3 Passengers"
 */
public class InputParser {

    public static RentRequest parse(String rentTrip) {

        if (Objects.isNull(rentTrip) || rentTrip.isBlank()) {
            throw new IllegalArgumentException("trip is invalid");
        }

        String[] elements = rentTrip.trim().split("\\s*,\\s*");

        if (elements.length != 5) {
            throw new IllegalArgumentException("trip is invalid");
        }

        Vehicle vehicle = extractVehicle(elements[0], elements[1]);
        boolean isUsedAC = !elements[2].trim().equalsIgnoreCase("NON AC");
        List<Path> paths = extractPaths(elements[3]);
        int numberOfPassengers = extractNumberOfPassengers(elements[4]);

        RentRequest rentRequest = new CarRentRequest(vehicle, paths, isUsedAC, numberOfPassengers);

        return rentRequest;
    }

    /**
     * @param brand brand or model name
     * @param fuel  the fuel type that vehicle used
     * @return
     */
    private static Vehicle extractVehicle(String brand, String fuel) {
        if (!DataPreparation.getVehicles().containsKey(brand + "-" + fuel)) {
            throw new IllegalArgumentException("trip is invalid");
        } else {
            return DataPreparation.getVehicles().get(brand + "-" + fuel);
        }
    }

    /**
     * extract visited cities and check them with provided data for cities distance
     *
     * @param tripPath
     * @return list of cities distances
     */
    private static List<Path> extractPaths(String tripPath) {
        List<Path> paths = new ArrayList<>();
        String source = "";

        for (String city : tripPath.split("-")) {

            if (!source.isBlank()) {
                if (!DataPreparation.getPaths().containsKey(source + "-" + city.trim()) &&
                        !DataPreparation.getPaths().containsKey(city.trim() + "-" + source)) {
                    paths.clear();
                    throw new IllegalArgumentException(String.format("common.Path is invalid. %s-%s", source, city.trim()));
                } else {
                    Path path = (DataPreparation.getPaths().containsKey(source + "-" + city.trim()))
                            ? DataPreparation.getPaths().get(source + "-" + city.trim()) :
                            DataPreparation.getPaths().get(city.trim() + "-" + source);
                    paths.add(path);
                }
            }
            source = city.trim();
        }

        return paths;
    }

    /**
     * extract and parse number of passengers in a rent trip     *
     *
     * @param text input sample: 3 Passengers
     * @return Number of passengers
     */
    private static int extractNumberOfPassengers(String text) {
        Pattern passengersPattern = Pattern.compile("([\\d]+)([^\\d]*)");
        Matcher m = passengersPattern.matcher(text);

        if (!m.find()) {
            throw new IllegalArgumentException(String.format("number of passenger is invalid. %s-%s", text));
        }
        return Integer.parseInt(m.group(1));
    }
}
