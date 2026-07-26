import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private double hoursWorked;
    private double hourlyRate;
    private double grossSalary;
    private double tax;
    private double netSalary;
    
    // Constructor
    public Employee(String name, double hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public double getHoursWorked() { return hoursWorked; }
    public double getHourlyRate() { return hourlyRate; }
    public double getGrossSalary() { return grossSalary; }
    public double getTax() { return tax; }
    public double getNetSalary() { return netSalary; }
    
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }
    public void setTax(double tax) { this.tax = tax; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}

public class EnhancedEmployeeSalaryCalculator {
    
    private static final double OVERTIME_RATE = 1.5;
    private static final double REGULAR_HOURS = 40.0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        
        System.out.println("=== EMPLOYEE SALARY CALCULATOR SYSTEM ===");
        
        // Get tax rate from user
        System.out.print("Enter tax rate (as decimal, e.g., 0.20 for 20%): ");
        double taxRate = scanner.nextDouble();
        scanner.nextLine();
        
        // Get number of employees
        System.out.print("Enter number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();
        
        // Input employee data
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter hourly rate: $");
            double hourlyRate = scanner.nextDouble();
            
            System.out.print("Enter hours worked: ");
            double hoursWorked = scanner.nextDouble();
            scanner.nextLine();
            
            Employee emp = new Employee(name, hoursWorked, hourlyRate);
            employees.add(emp);
        }
        
        // Calculate salaries for all employees
        calculateSalaries(employees, taxRate);
        
        // Display results
        displayResults(employees);
        
        scanner.close();
    }
    
    public static void calculateSalaries(List<Employee> employees, double taxRate) {
        for (Employee emp : employees) {
            double grossSalary = calculateGrossSalary(emp.getHoursWorked(), emp.getHourlyRate());
            double tax = grossSalary * taxRate;
            double netSalary = grossSalary - tax;
            
            emp.setGrossSalary(grossSalary);
            emp.setTax(tax);
            emp.setNetSalary(netSalary);
        }
    }
    
    public static double calculateGrossSalary(double hoursWorked, double hourlyRate) {
        if (hoursWorked <= REGULAR_HOURS) {
            return hoursWorked * hourlyRate;
        } else {
            double regularPay = REGULAR_HOURS * hourlyRate;
            double overtimeHours = hoursWorked - REGULAR_HOURS;
            double overtimePay = overtimeHours * hourlyRate * OVERTIME_RATE;
            return regularPay + overtimePay;
        }
    }
    
    public static void displayResults(List<Employee> employees) {
        System.out.println("\n" + "=".repeat(95));
        System.out.println("                     EMPLOYEE SALARY REPORT");
        System.out.println("=".repeat(95));
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s%n", 
                         "Employee Name", "Hours Worked", "Hourly Rate", 
                         "Gross Salary", "Tax", "Net Salary");
        System.out.println("-".repeat(95));
        
        double totalGross = 0;
        double totalTax = 0;
        double totalNet = 0;
        
        for (Employee emp : employees) {
            System.out.printf("%-20s %-15.2f $%-14.2f $%-14.2f $%-14.2f $%-14.2f%n", 
                             emp.getName(), emp.getHoursWorked(), emp.getHourlyRate(),
                             emp.getGrossSalary(), emp.getTax(), emp.getNetSalary());
            
            totalGross += emp.getGrossSalary();
            totalTax += emp.getTax();
            totalNet += emp.getNetSalary();
        }
        
        System.out.println("-".repeat(95));
        System.out.printf("%-20s %-15s %-15s $%-14.2f $%-14.2f $%-14.2f%n", 
                         "TOTAL", "", "", totalGross, totalTax, totalNet);
        System.out.println("=".repeat(95));
        
        // Additional statistics
        System.out.printf("Total Employees: %d%n", employees.size());
        System.out.printf("Average Gross Salary: $%.2f%n", totalGross / employees.size());
        System.out.printf("Average Net Salary: $%.2f%n", totalNet / employees.size());
        System.out.printf("Total Tax Collected: $%.2f%n", totalTax);
        System.out.println("=".repeat(95));
    }
}