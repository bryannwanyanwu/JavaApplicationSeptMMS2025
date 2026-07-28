
package interfaces;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Interfaces Test ===\n");
        
        // Create payment objects
        CreditCard creditCard = new CreditCard("1234567890123456", "John Doe");
        BankTransfer bankTransfer = new BankTransfer("9876543210", "Chase Bank");
        MobileWallet mobileWallet = new MobileWallet("MW-001", "+1-555-0123");
        
        // Demonstrate polymorphism with interface
        Payment[] payments = {creditCard, bankTransfer, mobileWallet};
        
        double amount = 150.00;
        System.out.println("--- Processing Payments of $" + amount + " ---\n");
        
        for (Payment payment : payments) {
            System.out.println("Payment Method: " + payment.getPaymentMethod());
            payment.pay(amount);
            System.out.println();
        }
    }
}
    
}
