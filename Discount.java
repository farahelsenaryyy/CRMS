package CRMS;

public class Discount {
    private String discountType;
    private double discountAmount;

    public Discount(String discountType, double discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountType='" + discountType + '\'' +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
