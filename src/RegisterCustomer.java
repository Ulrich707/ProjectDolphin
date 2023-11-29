class RegisterCustomer {
    private int ticketNumber;
    private String customerName;
    private String age;
    private String activity;
    private int membershipFee;
    private double contestTime;
    private boolean isPaid;
    private boolean isPassive;

    // Constructor without isPassive parameter
    public RegisterCustomer(int orderCounter, String customerName, String age, String activity, int membershipFee, boolean b) {
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
        this.membershipFee = membershipFee;
        this.contestTime = 0;
        this.isPaid = false;
        this.isPassive = false; // Set default to active
    }

    // Constructor with isPassive parameter
    public RegisterCustomer(int orderNumber, String customerName, String age, String activity, int membershipFee, boolean isPaid, boolean isPassive) {
        this.ticketNumber = orderNumber;
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
        this.membershipFee = membershipFee;
        this.isPaid = isPaid;
        this.isPassive = isPassive;
        this.contestTime = 0;
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
