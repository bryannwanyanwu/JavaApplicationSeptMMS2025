import java.util.Scanner;

public class FairTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] categories = {"Housing", "Food", "Clothing", "Transportation", "Education", "Health Care", "Vacations"};
        double total = 0;

        for (String cat : categories) {
            System.out.print("Enter annual spending on " + cat + ": $");
            total += sc.nextDouble();
        }

        // FairTax: 23% inclusive (equivalent to ~29.87% on top of pre-tax price)
        double inclusiveTax  = total * 0.23;
        double exclusiveTax  = total * (0.23 / 0.77); // ≈30% exclusive rate

        System.out.printf("%nTotal Spending: $%.2f%n", total);
        System.out.printf("FairTax (23%% inclusive): $%.2f%n", inclusiveTax);
        System.out.printf("FairTax (~30%% exclusive): $%.2f%n", exclusiveTax);
    }
}