public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private SavingsAccount savingsAccount;

    public Customer(String id, String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public String getAccountNumber() {
        return savingsAccount.getAccountNumber();
    }

    public double getBalance() {
        return savingsAccount.getBalance();
    }

    public double getInterestRate() {
        return savingsAccount.getInterestRate();
    }
}
