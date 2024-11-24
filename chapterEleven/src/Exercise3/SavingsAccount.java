package Exercise3;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance, double annualInterestRate, String dateCreated) {
        super(accountNumber, balance, annualInterestRate, dateCreated);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Cannot overdraw a savings account.");
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount, " + super.toString();
    }
}
