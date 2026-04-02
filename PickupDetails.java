package CRMS;
import java.time.LocalDate;

public class PickupDetails {
    private Branch pickupBranch;
    private LocalDate pickupDate;
    private String specialInstructions;

    public PickupDetails(Branch pickupBranch, LocalDate pickupDate, String specialInstructions) {
        this.pickupBranch = pickupBranch;
        this.pickupDate = pickupDate;
        this.specialInstructions = specialInstructions;
    }

    public Branch getPickupBranch() {
        return pickupBranch;
    }

    public void setPickupBranch(Branch pickupBranch) {
        this.pickupBranch = pickupBranch;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Override
    public String toString() {
        return "PickupDetails{" +
                "pickupBranch=" + pickupBranch +
                ", pickupDate=" + pickupDate +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }
}
