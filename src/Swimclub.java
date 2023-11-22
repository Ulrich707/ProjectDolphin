import java.util.ArrayList;
import java.util.Scanner;

class Swimclub {
    private ArrayList<RegisterCustomer> customersList = new ArrayList<>();

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
            RegisterCustomer newRegisterCustomer = new RegisterCustomer(customerName, age, chosenActivity);
            customersList.add(newRegisterCustomer);
            System.out.println("Customer added successfully!");
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
                System.out.println("Name: " + registerCustomer.getCustomerName() +
                        ", Age: " + registerCustomer.getAge() +
                        ", Activity: " + registerCustomer.getActivity());

            }
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