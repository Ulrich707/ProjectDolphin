import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Swimclub {
    private ArrayList<Appointment> customersList = new ArrayList<>();

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
            Appointment newAppointment = new Appointment(customerName, age, chosenActivity);
            customersList.add(newAppointment);
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
            for (Appointment appointment : customersList) {
                System.out.println("Name: " + appointment.getCustomerName() +
                        ", Age: " + appointment.getAge() +
                        ", Activity: " + appointment.getActivity());

            }
        }
    }

    private ArrayList<String> getAvailableActivity() {
        ArrayList<String> availableActivity = new ArrayList<>();
        availableActivity.add("Swimming");
        availableActivity.add("Biking");
        availableActivity.add("Running");
        return availableActivity;
    }

    public void saveAppointmentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Appointment appointment : appointments) {
                String line = appointment.getActivity() + " - " +
                        appointment.getAge() + " - " +
                        appointment.getCustomerName();
                writer.println(line);
            }
            System.out.println("Appointments saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
