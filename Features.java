package CRMS;

public class Features {
    private String fuelType;
    private String transmission;
    private int seatingCapacity;
    private String category;


    public Features(String fuelType, String transmission, int seatingCapacity, String category) {
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.seatingCapacity = seatingCapacity;
        this.category = category;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Features{" +
                "fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", category='" + category + '\'' +
                '}';
    }
}
