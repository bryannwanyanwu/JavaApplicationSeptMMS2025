import java.util.Scanner;

public class Multiples {
    public static boolean isMultiple(int num1, int num2) {
        return num2 % num1 == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of pairs to test: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter first integer: ");
            int a = input.nextInt();
            System.out.print("Enter second integer: ");
            int b = input.nextInt();

            if (isMultiple(a, b)) {
                System.out.println(b + " is a multiple of " + a);
            } else {
                System.out.println(b + " is NOT a multiple of " + a);
            }
        }
        input.close();
    }
}
