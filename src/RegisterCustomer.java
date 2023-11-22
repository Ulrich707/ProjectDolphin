class RegisterCustomer {
    private String customerName;
    private String age;
    private String activity;

    public RegisterCustomer(String customerName, String age, String activity) {
        this.customerName = customerName;
        this.age = age;
        this.activity = activity;
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
}
