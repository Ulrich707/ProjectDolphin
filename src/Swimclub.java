import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Swimclub {
    private ArrayList<RegisterCustomer> customersList = new ArrayList<>();
    private int orderCounter = 1;

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
        int activityChoice = scanner.nextInt();
        scanner.nextLine();
        if (activityChoice >= 1 && activityChoice <= availableActivities.size()) {
            String chosenActivity = availableActivities.get(activityChoice - 1);
            int membershipFee = calculateMembershipFee(age);
            RegisterCustomer newRegisterCustomer = new RegisterCustomer(orderCounter, customerName, age, chosenActivity, membershipFee, false);
            customersList.add(newRegisterCustomer);
            System.out.println("Customer added successfully! Order Number: " + orderCounter);
            orderCounter++;
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
                System.out.println("Order Number: " + registerCustomer.getOrderNumber() +
                        ", Name: " + registerCustomer.getCustomerName() +
                        ", Age: " + registerCustomer.getAge() +
                        ", Activity: " + registerCustomer.getActivity() +
                        ", Membership Fee: " + registerCustomer.getMembershipFee() +
                        ", Paid: " + (registerCustomer.isPaid() ? "Yes" : "No"));
            }
        }
    }

    public void checkMembershipFee(Scanner scanner) {
        System.out.print("Enter customer's age: ");
        String age = scanner.nextLine();
        int membershipFee = calculateMembershipFee(age);
        System.out.println("Membership Fee for age " + age + ": " + membershipFee);
    }

    public void markEntryAsPaid(Scanner scanner) {
        System.out.print("Enter the order number of the entry to mark as paid: ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (RegisterCustomer customer : customersList) {
            if (customer.getOrderNumber() == orderNumber) {
                customer.markAsPaid();
                System.out.println("Entry marked as paid for customer: " + customer.getCustomerName());
                return;
            }
        }

        System.out.println("Invalid order number. Please try again.");
    }

    private int calculateMembershipFee(String age) {
        int ageValue = Integer.parseInt(age);
        if (ageValue < 18) {
            return 1000;
        } else if (ageValue >= 18 && ageValue <= 59) {
            return 1600;
        } else {
            return 1200;
        }
    }

    private ArrayList<String> getAvailableActivity() {
        ArrayList<String> availableActivity = new ArrayList<>();
        availableActivity.add("Swimming");
        availableActivity.add("Diving");
        availableActivity.add("Running");
        return availableActivity;
    }
}