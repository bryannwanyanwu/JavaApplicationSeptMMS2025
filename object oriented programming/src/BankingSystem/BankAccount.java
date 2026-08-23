
package BankingSystem;

    abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Concrete method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Concrete method
    public void displayBalance() {
        System.out.println(accountHolder + "'s Balance: " + balance);
    }

    // Abstract methods
    public abstract void withdraw(double amount);

    public abstract void calculateInterest();
}
}
