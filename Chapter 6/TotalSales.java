import java.util.Scanner;

public class TotalSales {
    public static void main(String[] args) {
        double[][] sales = new double[5][4]; // 5 products, 4 salespeople
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter sales data (salesperson number, product number, amount)");
        System.out.println("Enter -1 to stop:");
        
        while (true) {
            System.out.print("Salesperson number (1-4): ");
            int person = input.nextInt();
            if (person == -1) break;
            
            System.out.print("Product number (1-5): ");
            int product = input.nextInt();
            
            System.out.print("Amount: ");
            double amount = input.nextDouble();
            
            // Store in array (adjust indices to 0-based)
            sales[product-1][person-1] += amount;
        }
        
        input.close();
        
        // Display results
        System.out.println("\nSales Summary by Product and Salesperson");
        System.out.println("\t\tSalesperson");
        System.out.print("Product\t");
        for (int i = 0; i < 4; i++) {
            System.out.printf("Sp%d\t", i+1);
        }
        System.out.println("Total");
        
        double[] productTotals = new double[5];
        double[] personTotals = new double[4];
        
        for (int product = 0; product < 5; product++) {
            System.out.printf("%d\t", product+1);
            for (int person = 0; person < 4; person++) {
                System.out.printf("%.2f\t", sales[product][person]);
                productTotals[product] += sales[product][person];
                personTotals[person] += sales[product][person];
            }
            System.out.printf("%.2f%n", productTotals[product]);
        }
        
        // Display column totals
        System.out.print("Total\t");
        for (int person = 0; person < 4; person++) {
            System.out.printf("%.2f\t", personTotals[person]);
        }
        System.out.println();
    }
}