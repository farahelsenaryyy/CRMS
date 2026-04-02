package CRMS;
import java.time.LocalDate;

public class ProcessedRecord extends BookingRecord {
    private InsuranceOption insuranceOption;
    private Discount discount;
    private double totalCost;

    public ProcessedRecord(Client client, Car car, Agent agent,
                           LocalDate rentalStartDate, LocalDate rentalEndDate, double baseCost,
                           InsuranceOption insuranceOption, Discount discount, double totalCost) {
        super(client, car, agent, rentalStartDate, rentalEndDate, baseCost);
        this.insuranceOption = insuranceOption;
        this.discount = discount;
        this.totalCost = totalCost;
    }

    public InsuranceOption getInsuranceOption() {
        return insuranceOption;
    }

    public void setInsuranceOption(InsuranceOption insuranceOption) {
        this.insuranceOption = insuranceOption;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "ProcessedRecord{" +
                "client=" + getClient().getName() +
                ", car=" + getCar().getModel() +
                ", agent=" + getAgent().getName() +
                ", baseCost=" + getBaseCost() +
                ", insuranceOption=" + insuranceOption +
                ", discount=" + discount +
                ", totalCost=" + totalCost +
                '}';
    }

}
