
package polymorphism;

public class ContractEmployee extends Employee {
    private double contractAmount;
    private int contractDuration;
    
    public ContractEmployee(String name, int employeeId, double contractAmount, int contractDuration) {
        super(name, employeeId);
        this.contractAmount = contractAmount;
        this.contractDuration = contractDuration;
    }
    
    @Override
    public double calculateSalary() {
        return contractAmount / contractDuration;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n=== Contract Employee ===");
        super.displayInfo();
        System.out.println("Contract Amount: $" + contractAmount);
        System.out.println("Contract Duration: " + contractDuration + " months");
        System.out.println("==========================");
    }
}
