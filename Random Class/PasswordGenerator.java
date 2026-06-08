import java.security.SecureRandom;

public class PasswordGenerator {

    public static String generate() {

        // Step 1: Prepare your character bags
        String lower   = "abcdefghijklmnopqrstuvwxyz";
        String upper   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits  = "0123456789";
        String special = "!@#$%^&*()_+-=[]{}|;:,.?";
        String allChars = lower + upper + digits + special;

        SecureRandom rand = new SecureRandom();
        StringBuilder pw  = new StringBuilder();

        // Step 2: Pick at least one from each bag
        pw.append(lower.charAt(rand.nextInt(lower.length())));
        pw.append(upper.charAt(rand.nextInt(upper.length())));
        pw.append(digits.charAt(rand.nextInt(digits.length())));
        pw.append(special.charAt(rand.nextInt(special.length())));

        // Step 3: Fill the remaining 11 characters randomly
        for (int i = 4; i < 15; i++) {
            pw.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        // Step 4: Shuffle everything (like shuffling a deck of cards)
        char[] chars = pw.toString().toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j    = rand.nextInt(i + 1);
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("=== Random Password Generator ===");
        System.out.println();
        System.out.println("Your 15-character password:");
        System.out.println();
        System.out.println("  " + generate());
        System.out.println();
        System.out.println("Password contains: uppercase, lowercase, numbers & special characters.");
    }
}