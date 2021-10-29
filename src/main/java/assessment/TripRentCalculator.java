package assessment;

import assessment.rental.Trip;

@FunctionalInterface
public interface RentCalculator {
    double calcTotalExpense(Trip rentRequest);
}
