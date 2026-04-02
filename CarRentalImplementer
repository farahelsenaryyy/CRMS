package CRMS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRentalImplementer implements CRMS {

    @Override
    public RentalSystem InitializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents) {
        List<Client> clients = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<Agent> agents = new ArrayList<>();

        for (int i = 1; i <= numOfClients; i++) {
            LicenseDetails license = new LicenseDetails(
                    "LIC-" + i,
                    LocalDate.now().plusYears(2),
                    "None"
            );

            ContactDetails contact = new ContactDetails(
                    "Address " + i,
                    "070000000" + i,
                    "client" + i + "@gmail.com"
            );

            clients.add(new Client(i, "Client " + i, license, contact));
        }

        for (int i = 1; i <= numOfCars; i++) {
            Features features = new Features("Petrol", "Automatic", 5, "Economy");
            InsuranceDetails insuranceDetails = new InsuranceDetails(
                    "SafeCover",
                    "Basic + Standard",
                    "GPS, Child Seat"
            );

            cars.add(new Car(i, "Toyota Yaris " + i, 50.0 * i, true, features, insuranceDetails));
        }

        for (int i = 1; i <= numOfAgents; i++) {
            Branch branch = new Branch("Branch " + i, "Location " + i);
            Schedule schedule = new Schedule("9AM - 5PM", true);

            agents.add(new Agent(i, "Agent " + i, branch, schedule));
        }

        return new RentalSystem(clients, cars, agents);
    }

    @Override
    public BookingRecord Book(Client c, Car car, Agent a) {
        if (c == null || car == null || a == null) {
            throw new IllegalArgumentException("Client, car, and agent must not be null.");
        }

        if (!c.getLicenseDetails().isValid()) {
            throw new IllegalArgumentException("Client driving license is not valid.");
        }

        if (!car.isAvailable()) {
            throw new IllegalArgumentException("Selected car is not available.");
        }

        if (!a.getSchedule().isAvailable()) {
            throw new IllegalArgumentException("Assigned agent is not available.");
        }

        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = startDate.plusDays(3);
        long rentalDays = endDate.toEpochDay() - startDate.toEpochDay();
        double baseCost = rentalDays * car.getDailyRate();

        return new BookingRecord(c, car, a, startDate, endDate, baseCost);
    }

    @Override
    public ProcessedRecord Process(BookingRecord br) {
        if (br == null) {
            throw new IllegalArgumentException("BookingRecord must not be null.");
        }

        InsuranceOption insuranceOption;
        Discount discount;

        if (br.getAgent().getAgentId() % 2 == 0) {
            insuranceOption = new InsuranceOption(true, 40.0);
            discount = new Discount("Promotional", 30.0);
        } else {
            insuranceOption = new InsuranceOption(false, 20.0);
            discount = new Discount("Loyalty", 10.0);
        }

        double totalCost = br.getBaseCost() + insuranceOption.getExtraCost() - discount.getDiscountAmount();

        return new ProcessedRecord(
                br.getClient(),
                br.getCar(),
                br.getAgent(),
                br.getRentalStartDate(),
                br.getRentalEndDate(),
                br.getBaseCost(),
                insuranceOption,
                discount,
                totalCost
        );
    }

    @Override
    public FinalizedRecord Finalize(ProcessedRecord pr) {
        if (pr == null) {
            throw new IllegalArgumentException("ProcessedRecord must not be null.");
        }

        double deposit = pr.getTotalCost() * 0.30;
        double outstandingBalance = pr.getTotalCost() - deposit;

        PaymentDetails paymentDetails = new PaymentDetails(
                deposit,
                pr.getTotalCost(),
                outstandingBalance
        );

        PickupDetails pickupDetails = new PickupDetails(
                pr.getAgent().getBranch(),
                pr.getRentalStartDate(),
                "Please bring your driving license and booking confirmation."
        );

        pr.getCar().setAvailable(false);

        return new FinalizedRecord(
                pr.getClient(),
                pr.getCar(),
                pr.getAgent(),
                pr.getRentalStartDate(),
                pr.getRentalEndDate(),
                pr.getBaseCost(),
                pr.getInsuranceOption(),
                pr.getDiscount(),
                pr.getTotalCost(),
                paymentDetails,
                pickupDetails
        );
    }
}
