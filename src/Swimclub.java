import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Swimclub {
    private ArrayList<RegisterCustomer> customersList = new ArrayList<>();
    private static int orderCounter = 1;

    public ArrayList<RegisterCustomer> getCustomersList() {
        return customersList;
    }

    public void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer's age: ");
        String age = scanner.nextLine();
        System.out.println("Choose an activity:");

        ArrayList<String> availableActivities = getAvailableActivity();
        for (int i = 0; i < availableActivities.size(); i++) {
            System.out.println((i + 1) + ". " + availableActivities.get(i));
        }

        int activityChoice;
        try {
            activityChoice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input for activity choice. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return;
        }
        scanner.nextLine(); // Consume the newline character

        if (activityChoice >= 1 && activityChoice <= availableActivities.size()) {
            String chosenActivity = availableActivities.get(activityChoice - 1);
            int membershipFee = calculateMembershipFee(age, false);  // Assuming initially not passive

            if (orderCounter <= 0) {
                System.out.println("Invalid ticket number. Please try again.");
                return;
            }

            RegisterCustomer newRegisterCustomer = new RegisterCustomer(orderCounter++, customerName, age, chosenActivity, membershipFee, false, false);
            customersList.add(newRegisterCustomer);
            System.out.println("Customer added successfully! Ticket Number: " + (orderCounter - 1));
        } else {
            System.out.println("Invalid activity choice.");
        }
    }

    public void viewListOfCustomers() {
        if (customersList.isEmpty()) {
            System.out.println("No customers added yet.");
        } else {
            System.out.println("List of Customers:");
            for (RegisterCustomer registerCustomer : customersList) {
                System.out.println("Ticket Number: " + registerCustomer.getTicketNumber() +
                        ", Name: " + registerCustomer.getCustomerName() +
                        ", Age: " + registerCustomer.getAge() +
                        ", Activity: " + registerCustomer.getActivity() +
                        ", Membership Fee: " + registerCustomer.getMembershipFee() +
                        ", Paid: " + (registerCustomer.isPaid() ? "Yes" : "No") +
                        ", Passive: " + (registerCustomer.isPassive() ? "Yes" : "No"));
            }
        }
    }

    public void checkMembershipFee(Scanner scanner) {
        System.out.print("Enter customer's age: ");
        String age = scanner.nextLine();
        int membershipFee = calculateMembershipFee(age, false);
        System.out.println("Membership Fee for age " + age + ": " + membershipFee);
    }

    public void markEntryAsPaid(Scanner scanner) {
        System.out.print("Enter the ticket number of the entry to mark as paid: ");
        int orderNumber;
        try {
            orderNumber = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input for ticket number. Please enter a number.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();
        for (RegisterCustomer customer : customersList) {
            if (customer.getTicketNumber() == orderNumber) {
                customer.markAsPaid();
                System.out.println("Entry marked as paid for customer: " + customer.getCustomerName());
                return;
            }
        }

        System.out.println("Invalid ticket number. Please try again.");
    }

    private int calculateMembershipFee(String age, boolean isPassive) {
        int ageValue = Integer.parseInt(age);
        if (isPassive) {
            return 500;  // Passive fee
        } else if (ageValue < 18) {
            return 1000;
        } else if (ageValue >= 18 && ageValue <= 59) {
            return 1600;
        } else {
            return 1200;
        }
    }

    public ArrayList<String> getAvailableActivity() {
        ArrayList<String> availableActivity = new ArrayList<>();
        availableActivity.add("Swimming");
        availableActivity.add("Diving");
        availableActivity.add("Running");
        return availableActivity;
    }

    public void saveAppointmentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (RegisterCustomer registerCustomer : customersList) {
                String line = registerCustomer.getAge() + " - " + registerCustomer.getActivity() + " - " + registerCustomer.getCustomerName();
                writer.println(line);
            }
            System.out.println("Customer list saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAppointmentsFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" - ");
                if (parts.length == 3) {
                    String age = parts[0];
                    String activity = parts[1];
                    String customerName = parts[2];
                    int membershipFee = calculateMembershipFee(age, false);
                    RegisterCustomer customer = new RegisterCustomer(orderCounter++, customerName, age, activity, membershipFee, false, false);
                    customersList.add(customer);
                }
            }
            System.out.println("Customer list loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public ArrayList<RegisterCustomer> getCustomersByActivity(String activity) {
        ArrayList<RegisterCustomer> customersByActivity = new ArrayList<>();
        for (RegisterCustomer customer : customersList) {
            if (customer.getActivity().equalsIgnoreCase(activity)) {
                customersByActivity.add(customer);
            }
        }
        return customersByActivity;
    }

    public void changeCoach(int ticketNumber, String newCoach) {
    }
}
