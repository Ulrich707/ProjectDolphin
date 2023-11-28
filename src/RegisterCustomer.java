
    class RegisterCustomer {
        private int orderNumber;
        private String customerName;
        private String age;
        private String activity;
        private int membershipFee;
        private double contestTime;
        private boolean isPaid;

        // Constructor without orderNumber and contestTime
        public RegisterCustomer(String customerName, String age, String activity, int membershipFee) {
            this.customerName = customerName;
            this.age = age;
            this.activity = activity;
            this.membershipFee = membershipFee;
            this.contestTime = 0;
            this.isPaid = false;
        }

        // Constructor with all fields
        public RegisterCustomer(int orderNumber, String customerName, String age, String activity, int membershipFee, boolean isPaid) {
            this.orderNumber = orderNumber;
            this.customerName = customerName;
            this.age = age;
            this.activity = activity;
            this.membershipFee = membershipFee;
            this.isPaid = isPaid;
            this.contestTime = 0;
        }

        // Getters and setters for all fields

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