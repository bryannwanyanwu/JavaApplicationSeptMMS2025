import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] unique = new int[5];
        int count = 0;
        
        System.out.println("Enter five numbers between 10 and 100:");
        
        for (int i = 0; i < 5; i++) {
            int num = input.nextInt();
            
            // Validate input
            while (num < 10 || num > 100) {
                System.out.print("Number must be between 10 and 100. Enter again: ");
                num = input.nextInt();
            }
            
            // Check for duplicates
            boolean duplicate = false;
            for (int j = 0; j < count; j++) {
                if (unique[j] == num) {
                    duplicate = true;
                    break;
                }
            }
            
            if (!duplicate) {
                unique[count] = num;
                count++;
            }
            
            // Display unique values
            System.out.print("Unique values: ");
            for (int j = 0; j < count; j++) {
                System.out.print(unique[j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}