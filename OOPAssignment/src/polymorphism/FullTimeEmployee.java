package FullTimeEmployee;

public abstract class Employee {
    private String name;
    private int employeeId;
    
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    
    public abstract double calculateSalary(); // Must be implemented by subclasses
    
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
    }
    
    // Getters
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
}