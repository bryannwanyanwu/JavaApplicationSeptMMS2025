import java.util.Scanner;

public class ParkingCharges {
    public static double calculateCharges(double hours) {
        double charge = 2.00;
        if (hours > 3.0) {
            charge += Math.ceil(hours - 3.0) * 0.50;
        }
        if (charge > 10.00) {
            charge = 10.00;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter number of customers: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter hours parked for customer " + i + ": ");
            double hours = input.nextDouble();
            double charge = calculateCharges(hours);
            total += charge;
            System.out.printf("Charge: $%.2f  Running total: $%.2f%n", charge, total);
        }
        input.close();
    }
}
