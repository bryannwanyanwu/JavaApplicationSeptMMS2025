
package interfaces;


public class MobileWallet implements Payment {
    private String walletId;
    private String phoneNumber;
    
    public MobileWallet(String walletId, String phoneNumber) {
        this.walletId = walletId;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing mobile wallet payment of $" + amount);
        System.out.println("  - Wallet ID: " + walletId);
        System.out.println("  - Phone: " + phoneNumber);
        System.out.println("  - QR code scanned");
        System.out.println("  - Payment successful!");
    }
    
    @Override
    public String getPaymentMethod() {
        return "Mobile Wallet";
    }
}

