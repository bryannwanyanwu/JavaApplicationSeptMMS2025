import java.util.Scanner;

public class Polling {
    public static void main(String[] args) {
        String[] topics = {
            "Climate Change",
            "Healthcare",
            "Education",
            "Economic Inequality",
            "Criminal Justice Reform"
        };
        
        int[][] responses = new int[5][10]; // 5 topics, ratings 1-10
        Scanner input = new Scanner(System.in);
        
        // Get responses from users
        System.out.println("Rate each issue from 1 (least important) to 10 (most important):");
        
        String continuePolling = "yes";
        while (continuePolling.equalsIgnoreCase("yes")) {
            for (int i = 0; i < topics.length; i++) {
                System.out.printf("Rate '%s': ", topics[i]);
                int rating = input.nextInt();
                
                // Validate rating
                while (rating < 1 || rating > 10) {
                    System.out.print("Rating must be 1-10. Enter again: ");
                    rating = input.nextInt();
                }
                
                responses[i][rating - 1]++;
            }
            
            System.out.print("Continue polling? (yes/no): ");
            continuePolling = input.next();
        }
        input.close();
        
        // Display results
        System.out.println("\n=== SURVEY RESULTS ===");
        System.out.println("Topic\t\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAverage");
        
        int[] totals = new int[5];
        int highestTotal = -1;
        int highestIndex = 0;
        int lowestTotal = Integer.MAX_VALUE;
        int lowestIndex = 0;
        
        for (int i = 0; i < topics.length; i++) {
            System.out.printf("%-20s", topics[i]);
            int sum = 0;
            int count = 0;
            
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d\t", responses[i][j]);
                sum += responses[i][j] * (j + 1);
                count += responses[i][j];
            }
            
            double average = count > 0 ? (double) sum / count : 0;
            System.out.printf("%.2f%n", average);
            
            totals[i] = sum;
            if (totals[i] > highestTotal) {
                highestTotal = totals[i];
                highestIndex = i;
            }
            if (totals[i] < lowestTotal) {
                lowestTotal = totals[i];
                lowestIndex = i;
            }
        }
        
        System.out.printf("%nHighest point total: %s with %d points%n", 
                         topics[highestIndex], highestTotal);
        System.out.printf("Lowest point total: %s with %d points%n", 
                         topics[lowestIndex], lowestTotal);
    }
}