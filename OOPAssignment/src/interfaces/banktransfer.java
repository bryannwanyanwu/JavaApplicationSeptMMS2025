
package interfaces;


public class banktransfer {
public class BankTransfer implements Payment {
    private String accountNumber;
    private String bankName;
    
    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer of $" + amount);
        System.out.println("  - Account: ****" + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("  - Bank: " + bankName);
        System.out.println("  - Transfer initiated");
        System.out.println("  - Payment successful!");
    }
    
    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}
    
}
