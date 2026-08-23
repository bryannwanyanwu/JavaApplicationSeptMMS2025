
package BankingSystem;

    class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Current Withdrawal: " + amount);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.02; // 2%
        System.out.println("Current Interest: " + interest);
    }
}

