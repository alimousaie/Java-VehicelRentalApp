package assessment.data;

public class ChargesOfRate {

    double standardRate;
    double useAcRate;
    double dieselRate;
    double extraPassengerRate;
    double busDiscount;

    public ChargesOfRate(double standardRate, double useAcRate, double dieselRate, double extraPassengerRate, double busDiscount) {
        this.standardRate = standardRate;
        this.useAcRate = useAcRate;
        this.dieselRate = dieselRate;
        this.extraPassengerRate = extraPassengerRate;
        this.busDiscount = busDiscount;
    }

    public double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(double standardRate) {
        this.standardRate = standardRate;
    }

    public double getUseAcRate() {
        return useAcRate;
    }

    public void setUseAcRate(double useAcRate) {
        this.useAcRate = useAcRate;
    }

    public double getDieselRate() {
        return dieselRate;
    }

    public void setDieselRate(double dieselRate) {
        this.dieselRate = dieselRate;
    }

    public double getExtraPassengerRate() {
        return extraPassengerRate;
    }

    public void setExtraPassengerRate(float extraPassengerRate) {
        this.extraPassengerRate = extraPassengerRate;
    }

    public double getBusDiscount() {
        return busDiscount;
    }

    public void setBusDiscount(double busDiscount) {
        this.busDiscount = busDiscount;
    }
}
