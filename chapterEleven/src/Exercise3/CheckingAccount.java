package Exercise3;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double balance, double annualInterestRate, String dateCreated, double overdraftLimit) {
        super(accountNumber, balance, annualInterestRate, dateCreated);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount, Overdraft Limit: " + overdraftLimit + ", " + super.toString();
    }
}
