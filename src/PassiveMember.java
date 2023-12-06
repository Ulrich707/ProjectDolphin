public class PassiveMember {
    private RegisterCustomer member;

    public PassiveMember(RegisterCustomer member) {
        this.member = member;
    }

    public void togglePassiveStatus() {
        member.setPassive(!member.isPassive());
    }
}