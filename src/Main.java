import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Swimclub swimclub = new Swimclub();
        SwimContest swimContest = new SwimContest(swimclub);
        swimclub.loadAppointmentsFromFile("CustomerList.txt");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to our swim club!");
            System.out.println("---------------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. View list of customers");
            System.out.println("3. Check Membership Fee");
            System.out.println("4. Enter contest results");
            System.out.println("5. Display contest results");
            System.out.println("6. Mark Entry as Paid");
            System.out.println("7. Toggle Passive Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            System.out.println("Please, enter your choice.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    swimclub.addCustomer(scanner);
                    swimclub.saveAppointmentsToFile("CustomerList.txt");
                    break;
                case 2:
                    swimclub.viewListOfCustomers();
                    break;
                case 3:
                    swimclub.checkMembershipFee(scanner);
                    break;
                case 4:
                    swimContest.enterSwimResults(scanner);
                    break;
                case 5:
                    swimContest.displayTop5Results(scanner);
                    break;
                case 6:
                    swimclub.markEntryAsPaid(scanner);
                    break;
                case 7:
                    togglePassiveStatus(swimclub, scanner);
                    break;
                case 8:
                    isRunning = false;
                    System.out.println("Exiting the program. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void togglePassiveStatus(Swimclub swimclub, Scanner scanner) {
        System.out.print("Enter the order number of the member to toggle passive status: ");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine();

        for (RegisterCustomer customer : swimclub.getCustomersList()) {
            if (customer.getTicketNumber() == ticketNumber) {
                PassiveMember passiveMember = new PassiveMember(customer);
                passiveMember.togglePassiveStatus();
                System.out.println("Passive status toggled for member: " + customer.getCustomerName());
                return;
            }
        }

        System.out.println("Member not found. Please try again.");
    }
}
