class RegisterCustomer {
    private int orderNumber;
    private String customerName;
    private String age;
    private String activity;
    private int membershipFee;
    private boolean isPaid;

    public RegisterCustomer(int orderNumber, String customerName, String age, String activity, int membershipFee, boolean isPaid) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
        this.membershipFee = membershipFee;
        this.isPaid = isPaid;
    }

    public int getOrderNumber() {
        return orderNumber;
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

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }
}