import java.security.SecureRandom;
public class AccountNumberGenerator{
	public static void main(String[] args){
		
		String prefix ="30";
		SecureRandom rand = new SecureRandom();
		StringBuilder digits = new StringBuilder();
		
		for (int i = 0; i < 8; i++){
			digits.append(rand.nextInt(10));
			String accountNumber = prefix + digits.toString();
			
		}
		System.out.println("Account number: " + accountNumber);
	}
}