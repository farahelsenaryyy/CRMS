package CRMS;

public class InsuranceOption {
    private boolean isPremium;   // true = Premium, false = Standard
    private double extraCost;

    public InsuranceOption(boolean isPremium, double extraCost) {
        this.isPremium = isPremium;
        this.extraCost = extraCost;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    @Override
    public String toString() {
        String type = isPremium ? "Premium" : "Standard";
        return "InsuranceOption{" +
                "type='" + type + '\'' +
                ", extraCost=" + extraCost +
                '}';
    }
}
