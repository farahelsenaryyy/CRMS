package CRMS;
import java.time.LocalDate;

public class BookingRecord {
    private Client client;
    private Car car;
    private Agent agent;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double baseCost;

    public BookingRecord(Client client, Car car, Agent agent,
                         LocalDate rentalStartDate, LocalDate rentalEndDate, double baseCost) {
        this.client = client;
        this.car = car;
        this.agent = agent;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.baseCost = baseCost;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public Agent getAgent() {
        return agent;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return "BookingRecord{" +
                "client=" + client +
                ", car=" + car +
                ", agent=" + agent +
                ", rentalStartDate=" + rentalStartDate +
                ", rentalEndDate=" + rentalEndDate +
                ", baseCost=" + baseCost +
                '}';
    }

}
