package CRMS;

public class TestRental {
    public static void main(String[] args) {

        CarRentalImplementer implementer = new CarRentalImplementer();

        RentalSystem rentalSystem = implementer.InitializeRentalSystem(1, 1, 2);

        Client client = rentalSystem.getClients().get(0);
        Car car = rentalSystem.getCars().get(0);
        Agent agent1 = rentalSystem.getAgents().get(0);
        Agent agent2 = rentalSystem.getAgents().get(1);

        BookingRecord booking1 = implementer.Book(client, car, agent1);
        BookingRecord booking2 = implementer.Book(client, car, agent2);

        System.out.println("\n=== Booking Record 1 ===");
        System.out.println(booking1);

        System.out.println("\n=== Booking Record 2 ===");
        System.out.println(booking2);

        System.out.println("\nNow process Booking Record 1");
        ProcessedRecord processed1 = implementer.Process(booking1);

        System.out.println("\nNow process Booking Record 2");
        ProcessedRecord processed2 = implementer.Process(booking2);

        System.out.println("\n=== Processed Record 1 ===");
        System.out.println(processed1);

        System.out.println("\n=== Processed Record 2 ===");
        System.out.println(processed2);

        ProcessedRecord betterDeal;

        if (processed1.getTotalCost() <= processed2.getTotalCost()) {
            betterDeal = processed1;
        } else {
            betterDeal = processed2;
        }

        System.out.println("\n=== Better Deal Selected ===");
        System.out.println(betterDeal);

        FinalizedRecord finalizedRecord = implementer.Finalize(betterDeal);

        System.out.println("\n=== Finalized Record ===");
        System.out.println(finalizedRecord);
    }
}
