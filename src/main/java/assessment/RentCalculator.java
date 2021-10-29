package assessment;

import assessment.rental.RentRequest;

@FunctionalInterface
public interface RentCalculator {
    double calcTotalExpense(RentRequest rentRequest);
}
