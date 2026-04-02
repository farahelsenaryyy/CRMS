package CRMS;

public class Car {
    private int carId;
    private String model;
    private double dailyRate;
    private boolean available;
    private Features features;
    private InsuranceDetails insuranceDetails;

    public Car(int carId, String model, double dailyRate, boolean available,
               Features features, InsuranceDetails insuranceDetails) {
        this.carId = carId;
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = available;
        this.features = features;
        this.insuranceDetails = insuranceDetails;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public InsuranceDetails getInsuranceDetails() {
        return insuranceDetails;
    }

    public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", dailyRate=" + dailyRate +
                ", available=" + available +
                ", features=" + features +
                ", insuranceDetails=" + insuranceDetails +
                '}';
    }
}
