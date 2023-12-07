import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Swimclub swimclub = new Swimclub();
        SwimContest swimContest = new SwimContest(swimclub);
        swimclub.loadAppointmentsFromFile("CustomerList.txt");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to the Swimclub App!");
            System.out.println("---------------------------------");
            System.out.println("1. Add Customer           ");
            System.out.println("2. View list of customers ");
            System.out.println("3. Display contest results");
            System.out.println("4. Enter contest results  ");
            System.out.println("5. Check Membership Fee   ");
            System.out.println("6. Mark Entry as Paid     ");
            System.out.println("7. Toggle Passive Status  ");
            System.out.println("8. Change Coach");
            System.out.println("9. Exit                   ");
            System.out.println("---------------------------------");
            System.out.println("Please, enter your choice:");

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
                    swimContest.displayTop5Results(scanner);
                    break;
                case 4:
                    swimContest.enterSwimResults(scanner);
                    break;
                case 5:
                    swimclub.checkMembershipFee(scanner);
                    break;
                case 6:
                    swimclub.markEntryAsPaid(scanner);
                    break;
                case 7:
                    togglePassiveStatus(swimclub, scanner);
                    break;
                case 8:
                    changeCoach(swimclub, scanner);
                    break;
                case 9:
                    isRunning = false;
                    System.out.println("Exiting the program! " + "Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void changeCoach(Swimclub swimclub, Scanner scanner) {
        System.out.println("Enter your ticket number:");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine();

        // Display coach options
        System.out.println("Choose a new coach:");
        System.out.println("1. Henning");
        System.out.println("2. Morten");
        System.out.println("3. Søren");

        int coachChoice = scanner.nextInt();
        scanner.nextLine();

        String newCoach;
        switch (coachChoice) {
            case 1:
                newCoach = "Henning";
                break;
            case 2:
                newCoach = "Morten";
                break;
            case 3:
                newCoach = "Søren";
                break;
            default:
                System.out.println("Invalid coach choice.");
                return;
        }

        swimclub.changeCoach(ticketNumber, newCoach);
        System.out.println("Coach has been changed.");
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