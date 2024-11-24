package Exercise3;

public class TestAccounts {
    public static void main(String[] args) {
        Account account = new Account(1001, 500.0, 1.5, "2024-11-06");
        SavingsAccount savingsAccount = new SavingsAccount(1002, 1000.0, 1.5, "2024-11-06");
        CheckingAccount checkingAccount = new CheckingAccount(1003, 300.0, 1.5, "2024-11-06", 200.0);

        System.out.println(account);
        account.deposit(200);
        account.withdraw(100);
        System.out.println(account);

        System.out.println("\n" + savingsAccount);
        savingsAccount.deposit(150);
        savingsAccount.withdraw(1300);
        System.out.println(savingsAccount);

        System.out.println("\n" + checkingAccount);
        checkingAccount.deposit(100);
        checkingAccount.withdraw(450); 
        checkingAccount.withdraw(200); 
        System.out.println(checkingAccount);
    }
}

