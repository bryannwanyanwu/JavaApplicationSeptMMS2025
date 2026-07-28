
package assignment2;


public class Teacher {
public class Teacher extends Person {
    private String department;
    private double salary;
    
    public Teacher(String name, int age, String department, double salary) {
        super(name, age);
        this.department = department;
        this.salary = salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n=== Teacher Information ===");
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.printf("Salary: $%.2f%n", salary);
        System.out.println("============================");
    }
}
    
}
