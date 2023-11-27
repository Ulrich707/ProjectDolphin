import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Swimclub swimclub = new Swimclub();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to our swim club!");
            System.out.println("---------------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. View list of customers");
            System.out.println("3. Check Membership Fee");
            System.out.println("4. Mark Entry as Paid");
            System.out.println("5. Exit");
            System.out.println("---------------------------------");
            System.out.println("Please, enter your choice.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    swimclub.addCustomer(scanner);
                    break;
                case 2:
                    swimclub.viewListOfCustomers();
                    break;
                case 3:
                    swimclub.checkMembershipFee(scanner);
                    break;
                case 4:
                    swimclub.markEntryAsPaid(scanner);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting the program. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
