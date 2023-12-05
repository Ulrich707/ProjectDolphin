import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Swimclub swimclub = new Swimclub();
        SwimContest swimContest = new SwimContest(swimclub);
        swimclub.loadAppointmentsFromFile("CustomerList.txt");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println(ConsoleColors.BLUE_UNDERLINED + "Welcome to the Swimclub App!" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK_BOLD + "---------------------------------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + "1. Add Customer           " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + "2. View list of customers " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + "3. Display contest results" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + "4. Enter contest results  " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "5. Check Membership Fee   " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "6. Mark Entry as Paid     " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "7. Toggle Passive Status  " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + "8. Exit                   " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK_BOLD + "---------------------------------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK_UNDERLINED + "Please, enter your choice:" + ConsoleColors.RESET);

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
                    isRunning = false;
                    System.out.println(ConsoleColors.RED_BOLD + "Exiting the program, " + ConsoleColors.GREEN_BOLD + "Have a great day!" + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Invalid choice. Please try again." + ConsoleColors.RESET);
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

        System.out.println(ConsoleColors.RED_UNDERLINED + "Member not found. Please try again." + ConsoleColors.RESET);
    }
}
