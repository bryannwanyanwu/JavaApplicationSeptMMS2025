import java.util.Scanner;

public class Exponentiation {
    public static long integerPower(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = input.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = input.nextInt();

        System.out.println(base + "^" + exponent + " = " + integerPower(base, exponent));
        input.close();
    }
}
