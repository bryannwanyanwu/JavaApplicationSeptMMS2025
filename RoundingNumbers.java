import java.util.Scanner;

public class RoundingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of values: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a double value: ");
            double x = input.nextDouble();
            double y = Math.floor(x + 0.5);
            System.out.println("Original: " + x + "  Rounded: " + y);
        }
        input.close();
    }
}
