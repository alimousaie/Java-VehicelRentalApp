package assessment.vehicles;

public class Bus implements Vehicle {
    private  String model;
    private VehicleType vehicleType;
    private boolean diesel;
    private int passengerLimit;

    public Bus(String model, boolean diesel, int passengerLimit) {
        this.model = model;
        this.vehicleType = VehicleType.BUS;
        this.diesel = diesel;
        this.passengerLimit = passengerLimit;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean isDiesel() {
        return diesel;
    }

    @Override
    public int getPassengerLimit() {
        return passengerLimit;
    }
}
