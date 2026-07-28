
package polymorphism;

public class Employee {
    protected String name;
    protected int employeeId;
    
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    
    public double calculateSalary() {
        return 0.0; // Base implementation
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: $" + calculateSalary());
    }
}
    
}
