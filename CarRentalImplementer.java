package CRMS;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalImplementer implements CRMS {

    private Scanner sc = new Scanner(System.in);

    @Override
    public RentalSystem InitializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents) {

        List<Client> clients = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<Agent> agents = new ArrayList<>();

        for (int i = 1; i <= numOfClients; i++) {

            String name;
            while (true) {
                System.out.println("Enter Client Name:");
                name = sc.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid name! Client name cannot be empty.");
                }
            }

            String phone;
            while (true) {
                System.out.println("Enter Phone Number (must be 11 digits):");
                phone = sc.nextLine().trim();

                if (phone.length() == 11 && phone.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Invalid phone number! It must contain exactly 11 digits.");
                }
            }

            System.out.println("Enter License Number:");
            String licenseNum = sc.nextLine().trim();

            String licenseExpiryDate;
            while (true) {
                System.out.println("Enter License Expiry Date (format: yyyy-MM-dd):");
                licenseExpiryDate = sc.nextLine().trim();

                LicenseDetails temp = new LicenseDetails(licenseNum, licenseExpiryDate, "None");

                if (temp.isValid()) {
                    break;
                } else {
                    System.out.println("Invalid or expired license date! Please enter a valid future date.");
                }
            }

            ContactDetails contact = new ContactDetails(
                    "Client Address",
                    phone,
                    name.replaceAll("\\s+", "").toLowerCase() + "@gmail.com"
            );

            LicenseDetails license = new LicenseDetails(
                    licenseNum,
                    licenseExpiryDate,
                    "None"
            );

            clients.add(new Client(i, name, license, contact));
        }

        for (int i = 1; i <= numOfCars; i++) {
            Features features = new Features("Petrol", "Automatic", 5, "Economy");
            InsuranceDetails insuranceDetails = new InsuranceDetails("SafeCover", "Standard/Premium", "GPS");

            cars.add(new Car(i, "Toyota " + i, 50.0, true, features, insuranceDetails));
        }

        for (int i = 1; i <= numOfAgents; i++) {
            Branch branch = new Branch("Branch " + i, "London");
            Schedule schedule = new Schedule("9AM-5PM", true);

            agents.add(new Agent(i, "Agent " + i, branch, schedule));
        }

        return new RentalSystem(clients, cars, agents);
    }

    @Override
    public BookingRecord Book(Client c, Car car, Agent a) {

        int rentalDays;
        while (true) {
            System.out.println("Enter Rental Duration in Days:");
            String input = sc.nextLine().trim();

            try {
                rentalDays = Integer.parseInt(input);

                if (rentalDays > 0) {
                    break;
                } else {
                    System.out.println("Invalid duration! Number of days must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = startDate.plusDays(rentalDays);

        while (true) {
            try {
                LocalDate expiryDate = c.getLicenseDetails().getValidUntilAsDate();

                if (!expiryDate.isBefore(endDate)) {
                    break;
                } else {
                    System.out.println("License expiry date is before the rental end date.");
                    System.out.println("Rental ends on: " + endDate);
                    System.out.println("Please re-enter a license expiry date that covers the full rental period.");

                    String newExpiryDate = sc.nextLine().trim();
                    c.getLicenseDetails().setValidUntil(newExpiryDate);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please enter the date as yyyy-MM-dd.");
                String newExpiryDate = sc.nextLine().trim();
                c.getLicenseDetails().setValidUntil(newExpiryDate);
            }
        }

        double baseCost = rentalDays * car.getDailyRate();

        return new BookingRecord(c, car, a, startDate, endDate, baseCost);
    }

    @Override
    public ProcessedRecord Process(BookingRecord br) {

        InsuranceOption insuranceOption;
        Discount discount;

        int insuranceChoice;
        while (true) {
            System.out.println("Choose Insurance Type:");
            System.out.println("1. Standard");
            System.out.println("2. Premium");

            String input = sc.nextLine().trim();

            try {
                insuranceChoice = Integer.parseInt(input);

                if (insuranceChoice == 1 || insuranceChoice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter 1 or 2.");
            }
        }

        if (insuranceChoice == 2) {
            insuranceOption = new InsuranceOption(true, 40.0);
            discount = new Discount("Promo", 30.0);
        } else {
            insuranceOption = new InsuranceOption(false, 20.0);
            discount = new Discount("Loyalty", 10.0);
        }

        double totalCost = br.getBaseCost()
                + insuranceOption.getExtraCost()
                - discount.getDiscountAmount();

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

        double deposit = pr.getTotalCost() * 0.30;
        double remaining = pr.getTotalCost() - deposit;

        PaymentDetails payment = new PaymentDetails(deposit, pr.getTotalCost(), remaining);

        PickupDetails pickup = new PickupDetails(
                pr.getAgent().getBranch(),
                pr.getRentalStartDate(),
                "Bring your driving license and booking confirmation."
        );

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
                payment,
                pickup
        );
    }
}
