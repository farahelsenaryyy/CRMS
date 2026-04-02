package CRMS;

public class TestRental {
    public static void main(String[] args) {
        CarRentalImplementer implementer = new CarRentalImplementer();

        // Step 1: Initialize the rental system with ONE client, TWO agents, and ONE car.
        RentalSystem rentalSystem = implementer.InitializeRentalSystem(1, 1, 2);

        Client client = rentalSystem.getClients().get(0);
        Car car = rentalSystem.getCars().get(0);
        Agent agent1 = rentalSystem.getAgents().get(0);
        Agent agent2 = rentalSystem.getAgents().get(1);

        // Step 2: Create TWO booking records for the same client and car with different agents.
        BookingRecord booking1 = implementer.Book(client, car, agent1);
        BookingRecord booking2 = implementer.Book(client, car, agent2);

        System.out.println("Booking Record 1:");
        System.out.println(booking1);
        System.out.println();

        System.out.println("Booking Record 2:");
        System.out.println(booking2);
        System.out.println();

        // Step 3: Process the two booking records with different terms.
        ProcessedRecord processed1 = implementer.Process(booking1);
        ProcessedRecord processed2 = implementer.Process(booking2);

        System.out.println("Processed Record 1:");
        System.out.println(processed1);
        System.out.println();

        System.out.println("Processed Record 2:");
        System.out.println(processed2);
        System.out.println();

        // Step 4: Compare the total costs.
        ProcessedRecord betterDeal;
        if (processed1.getTotalCost() <= processed2.getTotalCost()) {
            betterDeal = processed1;
        } else {
            betterDeal = processed2;
        }

        System.out.println("Better deal selected:");
        System.out.println(betterDeal);
        System.out.println();

        // Step 5: Finalize the booking with the better deal.
        FinalizedRecord finalizedRecord = implementer.Finalize(betterDeal);

        System.out.println("Finalized Record:");
        System.out.println(finalizedRecord);
    }
}
