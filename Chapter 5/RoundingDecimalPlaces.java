import java.util.Scanner;

public class RoundingDecimalPlaces {
    public static double roundToInteger(double number) {
        return Math.floor(number + 0.5);
    }

    public static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }

    public static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }

    public static double roundToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of values: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a double value: ");
            double x = input.nextDouble();
            System.out.println("Original: " + x);
            System.out.println("Rounded to integer: " + roundToInteger(x));
            System.out.println("Rounded to tenths: " + roundToTenths(x));
            System.out.println("Rounded to hundredths: " + roundToHundredths(x));
            System.out.println("Rounded to thousandths: " + roundToThousandths(x));
        }
        input.close();
    }
}
