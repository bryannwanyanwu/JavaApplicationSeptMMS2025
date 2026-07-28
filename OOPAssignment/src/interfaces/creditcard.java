
package interfaces;


public class creditcard {
    

public class CreditCard implements Payment {
    private String cardNumber;
    private String cardHolder;
    
    public CreditCard(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("  - Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("  - Card Holder: " + cardHolder);
        System.out.println("  - Authorization approved");
        System.out.println("  - Payment successful!");
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}
    
}
