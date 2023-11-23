class RegisterCustomer {
    private String customerName;
    private String age;
    private String activity;
    private int membershipFee;

    public RegisterCustomer(String customerName, String age, String activity, int membershipFee) {
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
        this.membershipFee = membershipFee;
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
}
