import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SwimContest {
    private Swimclub swimclub;
    private Map<String, ArrayList<RegisterCustomer>> contests;

    public SwimContest(Swimclub swimclub) {
        this.swimclub = swimclub;
        contests = new HashMap<>();
    }

    public void enterSwimResults(Scanner scanner) {
        System.out.println("Choose a swimming activity for the contest:");
        System.out.println("1. 100m");
        System.out.println("2. Crawl");
        System.out.println("3. Butterfly");

        int activityChoice = scanner.nextInt();
        scanner.nextLine();

        String chosenActivity;

        if (activityChoice == 1) {
            chosenActivity = "100m";
        } else if (activityChoice == 2) {
            chosenActivity = "crawl";
        } else if (activityChoice == 3) {
            chosenActivity = "butterfly";
        } else {
            System.out.println("Invalid activity choice.");
            return;
        }


        ArrayList<RegisterCustomer> participants = getActiveParticipants(chosenActivity);

        if (participants.isEmpty()) {
            System.out.println("No active participants found for " + chosenActivity);
            return;
        }

        // Determine the coach based on the chosen activity
        String coach;
        if (chosenActivity.equals("100m")) {
            coach = "Henning";
        } else if (chosenActivity.equals("crawl")) {
            coach = "Morten";
        } else { // Assuming the only option left is "butterfly"
            coach = "Søren";
        }

        System.out.println("Coach for " + chosenActivity + ": " + coach);
    }

    private ArrayList<RegisterCustomer> getActiveParticipants(String activity) {
        ArrayList<RegisterCustomer> activeParticipants = new ArrayList<>();
        for (RegisterCustomer customer : swimclub.getCustomersByActivity(activity)) {
            if (!customer.isPassive()) {
                activeParticipants.add(customer);
            }
        }
        return activeParticipants;
    }


    public void displayTop5Results(Scanner scanner) {
        System.out.println("Available contests:");
        for (String contestName : contests.keySet()) {
            System.out.println("- " + contestName);
        }

        System.out.print("Enter the name of the contest to display top 5 results: ");
        String contestToDisplay = scanner.nextLine();

        if (!contests.containsKey(contestToDisplay)) {
            System.out.println("Contest not found.");
            return;
        }

        ArrayList<RegisterCustomer> contestParticipants = contests.get(contestToDisplay);

        if (contestParticipants.isEmpty()) {
            System.out.println("No participants found for this contest.");
            return;
        }

        Collections.sort(contestParticipants, Comparator.comparingDouble(RegisterCustomer::getContestTime));

        int displayCount = Math.min(5, contestParticipants.size());
        System.out.println("Top 5 results for '" + contestToDisplay + "':");
        for (int i = 0; i < displayCount; i++) {
            RegisterCustomer member = contestParticipants.get(i);
            System.out.println((i + 1) + ". Name: " + member.getCustomerName() +
                    ", Activity: " + member.getActivity() +
                    ", Time: " + member.getContestTime() + " seconds");
        }
    }
}