public class RegisterCustomer {
    private static int lastTicketNumber = 0; // Static variable to track the last assigned ticket number

    private int ticketNumber;
    private String customerName;
    private String age;
    private String activity;
    private int membershipFee;
    private double contestTime;
    private boolean isPaid;
    private boolean isPassive;

    public RegisterCustomer(int i, String customerName, String age, String activity, int membershipFee, boolean isPassive, boolean b) {
        this.ticketNumber = ++lastTicketNumber; // Increment and assign a unique ticket number
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
        this.membershipFee = membershipFee;
        this.isPaid = false;
        this.isPassive = isPassive;
        this.contestTime = 0;

    }


    // Getter for lastTicketNumber
    public static int getLastTicketNumber() {
        return lastTicketNumber;
    }

    // Getter and setter for isPassive
    public boolean isPassive() {
        return isPassive;
    }

    public void setPassive(boolean passive) {
        isPassive = passive;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAge() {
        return age;
    }

    public String getActivity() {
        return activity;
    }

    public int getMembershipFee() {
        return membershipFee;
    }

    public double getContestTime() {
        return contestTime;
    }

    public void setContestTime(double contestTime) {
        this.contestTime = contestTime;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }
}
