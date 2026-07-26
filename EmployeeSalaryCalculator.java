import java.util.Scanner;

public class EmployeeSalaryCalculator {
    
    // Constants for salary calculation
    private static final double HOURLY_RATE = 25.0;  // $25 per hour
    private static final double OVERTIME_RATE = 1.5;  // 1.5x for overtime
    private static final double REGULAR_HOURS = 40.0;  // Regular work hours per week
    private static final double TAX_RATE = 0.20;  // 20% tax rate
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== EMPLOYEE SALARY CALCULATOR ===");
        System.out.print("Enter number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        // Arrays to store employee data
        String[] names = new String[numEmployees];
        double[] hoursWorked = new double[numEmployees];
        double[] grossSalaries = new double[numEmployees];
        double[] taxes = new double[numEmployees];
        double[] netSalaries = new double[numEmployees];
        
        // Input employee data
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");
            System.out.print("Enter employee name: ");
            names[i] = scanner.nextLine();
            
            System.out.print("Enter hours worked: ");
            hoursWorked[i] = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
        }
        
        // Calculate salaries
        for (int i = 0; i < numEmployees; i++) {
            grossSalaries[i] = calculateGrossSalary(hoursWorked[i]);
            taxes[i] = calculateTax(grossSalaries[i]);
            netSalaries[i] = calculateNetSalary(grossSalaries[i], taxes[i]);
        }
        
        // Display results
        displayResults(names, hoursWorked, grossSalaries, taxes, netSalaries);
        
        scanner.close();
    }
    
    /**
     * Calculate gross salary based on hours worked
     * Overtime is paid at 1.5x rate for hours beyond 40
     */
    public static double calculateGrossSalary(double hoursWorked) {
        double grossSalary;
        
        if (hoursWorked <= REGULAR_HOURS) {
            grossSalary = hoursWorked * HOURLY_RATE;
        } else {
            double regularPay = REGULAR_HOURS * HOURLY_RATE;
            double overtimeHours = hoursWorked - REGULAR_HOURS;
            double overtimePay = overtimeHours * HOURLY_RATE * OVERTIME_RATE;
            grossSalary = regularPay + overtimePay;
        }
        
        return grossSalary;
    }
    
    /**
     * Calculate tax based on gross salary
     */
    public static double calculateTax(double grossSalary) {
        return grossSalary * TAX_RATE;
    }
    
    /**
     * Calculate net salary (gross salary - tax)
     */
    public static double calculateNetSalary(double grossSalary, double tax) {
        return grossSalary - tax;
    }
    
    /**
     * Display all employee information in a formatted table
     */
    public static void displayResults(String[] names, double[] hoursWorked, 
                                     double[] grossSalaries, double[] taxes, 
                                     double[] netSalaries) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                     EMPLOYEE SALARY REPORT");
        System.out.println("=".repeat(80));
        System.out.printf("%-20s %-15s %-15s %-15s %-15s%n", 
                         "Employee Name", "Hours Worked", "Gross Salary", "Tax (20%)", "Net Salary");
        System.out.println("-".repeat(80));
        
        double totalGross = 0;
        double totalTax = 0;
        double totalNet = 0;
        
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-20s %-15.2f $%-14.2f $%-14.2f $%-14.2f%n", 
                             names[i], hoursWorked[i], grossSalaries[i], 
                             taxes[i], netSalaries[i]);
            
            totalGross += grossSalaries[i];
            totalTax += taxes[i];
            totalNet += netSalaries[i];
        }
        
        System.out.println("-".repeat(80));
        System.out.printf("%-20s %-15s $%-14.2f $%-14.2f $%-14.2f%n", 
                         "TOTAL", "", totalGross, totalTax, totalNet);
        System.out.println("=".repeat(80));
        
        // Display average
        double averageSalary = totalNet / names.length;
        System.out.printf("Average Net Salary: $%.2f%n", averageSalary);
        System.out.println("=".repeat(80));
    }
}