package BankingSystem;
public class Main {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount("S001", "John", 1000);
        CurrentAccount current = new CurrentAccount("C001", "Mary", 2000);

        // Savings Account
        savings.deposit(500);
        savings.withdraw(300);
        savings.displayBalance();
        savings.calculateInterest();

        System.out.println();

        // Current Account
        current.deposit(1000);
        current.withdraw(700);
        current.displayBalance();
        current.calculateInterest();
    }
}