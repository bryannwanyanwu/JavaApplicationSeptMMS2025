import java.util.Scanner;

public class SeparatingDigits {
    public static int quotient(int a, int b) {
        return a / b;
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static void displayDigits(int number) {
        // Extract digits using quotient/remainder, then print in order.
        int[] digits = new int[5];
        int count = 0;
        int n = number;

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n > 0) {
            digits[count] = remainder(n, 10);
            n = quotient(n, 10);
            count++;
        }

        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
            if (i > 0) {
                System.out.print("  ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 99999: ");
        int number = input.nextInt();
        displayDigits(number);
        input.close();
    }
}
