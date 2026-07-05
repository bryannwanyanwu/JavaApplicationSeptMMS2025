import java.security.SecureRandom;

public class DiceRolling {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] sums = new int[13]; // indices 2-12 will be used
        
        // Roll dice 36,000,000 times
        for (int i = 0; i < 36_000_000; i++) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            sums[sum]++;
        }
        
        // Display results
        System.out.println("Sum\tFrequency");
        for (int i = 2; i <= 12; i++) {
            System.out.printf("%d\t%d%n", i, sums[i]);
        }
        
        // Display percentage
        System.out.println("\nSum\tPercentage");
        for (int i = 2; i <= 12; i++) {
            double percentage = (double) sums[i] / 36_000_000 * 100;
            System.out.printf("%d\t%.2f%%%n", i, percentage);
        }
    }
}