import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Swimclub swimclub = new Swimclub();
        swimclub.loadAppointmentsFromFile("CustomerList.txt");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to our swim club!");
            System.out.println("---------------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. View list of customers");
            System.out.println("3. Check Membership Fee");
            System.out.println("4. Exit");
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
                    isRunning = false;
                    System.out.println("Exiting the program. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}