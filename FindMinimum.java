import java.util.Scanner;

public class FindMinimum {
    public static double minimum3(double x, double y, double z) {
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three values: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        System.out.println("Minimum: " + minimum3(a, b, c));
        input.close();
    }
}
