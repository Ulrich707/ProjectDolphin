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
        ArrayList<String> availableActivities = swimclub.getAvailableActivity();
        System.out.println("Choose an activity for the contest:");
        for (int i = 0; i < availableActivities.size(); i++) {
            System.out.println((i + 1) + ". " + availableActivities.get(i));
        }

        int activityChoice = scanner.nextInt();
        scanner.nextLine();

        if (activityChoice < 1 || activityChoice > availableActivities.size()) {
            System.out.println("Invalid activity choice.");
            return;
        }

        String chosenActivity = availableActivities.get(activityChoice - 1);

        // Get participants excluding passive members
        ArrayList<RegisterCustomer> participants = getActiveParticipants(chosenActivity);

        if (participants.isEmpty()) {
            System.out.println("No active participants found for " + chosenActivity);
            return;
        }

        System.out.print("Enter the name for this contest: ");
        String contestName = scanner.nextLine();

        if (contests.containsKey(contestName)) {
            System.out.println("Contest name already exists. Please use a different name.");
            return;
        }

        System.out.println("Select up to 5 participants for " + chosenActivity + " to enter swim results:");

        ArrayList<RegisterCustomer> contestParticipants = new ArrayList<>();
        int spotsFilled = 0;

        while (spotsFilled < 5) {
            System.out.println("Available spots left: " + (5 - spotsFilled));
            for (int i = 0; i < participants.size(); i++) {
                RegisterCustomer participant = participants.get(i);
                System.out.println((i + 1) + ". " + participant.getCustomerName());
            }

            System.out.println("Enter participant number to set swim time (time in seconds):");
            int participantChoice = scanner.nextInt();
            scanner.nextLine();

            if (participantChoice < 1 || participantChoice > participants.size()) {
                System.out.println("Invalid participant choice.");
                continue;
            }

            RegisterCustomer participant = participants.get(participantChoice - 1);
            if (contestParticipants.contains(participant)) {
                System.out.println("Participant already selected.");
                continue;
            }

            System.out.print("Enter swim time for " + participant.getCustomerName() + ": ");
            double time = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            participant.setContestTime(time);
            contestParticipants.add(participant);
            spotsFilled++;
            System.out.println("Swim time for " + participant.getCustomerName() + " entered successfully!");

            if (spotsFilled == 5) {
                contests.put(contestName, contestParticipants);
                System.out.println("Contest '" + contestName + "' with " + chosenActivity + " participants created.");
                break;
            }
        }
    }

    // Helper method to get active participants for a specific activity
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