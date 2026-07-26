public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;
    
    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }
    
    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }
    
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
    
    public double getSavingsBalance() {
        return savingsBalance;
    }
}

// Test program
public class SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        
        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Interest Rate: 4%");
        System.out.println("Month\tSaver1\t\tSaver2");
        System.out.println("-----|-----------|-----------");
        
        for (int month = 1; month <= 12; month++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("%2d    $%,8.2f    $%,8.2f%n", 
                month, saver1.getSavingsBalance(), saver2.getSavingsBalance());
        }
        
        SavingsAccount.modifyInterestRate(0.05);
        System.out.printf("%nInterest Rate: 5%%%n");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Next month: $%,8.2f    $%,8.2f%n", 
            saver1.getSavingsBalance(), saver2.getSavingsBalance());
    }
}