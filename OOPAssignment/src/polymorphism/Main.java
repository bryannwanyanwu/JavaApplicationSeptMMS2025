
package polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 8: Polymorphism Test ===\n");
        
        // Create employee objects
        FullTimeEmployee fullTime = new FullTimeEmployee("John Smith", 1001, 5000.00, 1000.00);
        PartTimeEmployee partTime = new PartTimeEmployee("Jane Doe", 1002, 25.50, 80);
        ContractEmployee contract = new ContractEmployee("Bob Johnson", 1003, 24000.00, 6);
        
        // Demonstrate polymorphism using Employee reference
        Employee[] employees = {fullTime, partTime, contract};
        
        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println();
        }
        
        // Show different salary calculations
        System.out.println("\n=== Salary Calculations ===");
        System.out.println("Full-time: $" + fullTime.calculateSalary());
        System.out.println("Part-time: $" + partTime.calculateSalary());
        System.out.println("Contract: $" + contract.calculateSalary());
    }
}