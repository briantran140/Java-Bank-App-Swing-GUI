import java.util.Random;

public class SavingsAccount {

    private String accountNumber;
    private double balance;
    private double interestRate;

    public SavingsAccount() {
        this.setRandomAccountNumber();
    }

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String setRandomAccountNumber() {
        Random random = new Random();
        int n = 100000 + random.nextInt(900000);
        String accountNumber = n + "";
        setAccountNumber(accountNumber);
        return accountNumber;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            return false;
        }
        balance -= withdrawAmount;
        return true;
    }

    public boolean deposit(double depositAmount) {
        balance += depositAmount;
        return true;
    }
}
