package CRMS;
import java.time.LocalDate;
public class FinalizedRecord  extends ProcessedRecord {
    private PaymentDetails paymentDetails;
    private PickupDetails pickupDetails;

    public FinalizedRecord(Client client, Car car, Agent agent,
                           LocalDate rentalStartDate, LocalDate rentalEndDate, double baseCost,
                           InsuranceOption insuranceOption, Discount discount, double totalCost,
                           PaymentDetails paymentDetails, PickupDetails pickupDetails) {
        super(client, car, agent, rentalStartDate, rentalEndDate, baseCost,
                insuranceOption, discount, totalCost);
        this.paymentDetails = paymentDetails;
        this.pickupDetails = pickupDetails;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public PickupDetails getPickupDetails() {
        return pickupDetails;
    }

    public void setPickupDetails(PickupDetails pickupDetails) {
        this.pickupDetails = pickupDetails;
    }

    @Override
    public String toString() {
        return "FinalizedRecord" +
                " Client: " + getClient().getName() +
                ", Car: " + getCar().getModel() +
                ", Agent: " + getAgent().getName() +
                ", TotalCost: " + getTotalCost() +
                ", Deposit amount: " + paymentDetails.getDepositAmount() +
                ", Remaining payment: "+paymentDetails.getOutstandingBalance()+
                ", Branch: " + pickupDetails.getPickupBranch()
                ;
    }
}
