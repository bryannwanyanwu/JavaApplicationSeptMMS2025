// BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee -- Exercise 9.14
public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, double grossSales, double commissionRate,
      double baseSalary) {

      // pass firstName, lastName, SSN, grossSales and
      // commissionRate to CommissionEmployee constructor
      super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
      setBaseSalary(baseSalary); // validate and store base salary
   }

   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0)
         throw new IllegalArgumentException("Base salary must be >= 0.0");

      this.baseSalary = baseSalary;
   }

   // return base salary
   public double getBaseSalary() {
      return baseSalary;
   }

   // calculate earnings
   @Override
   public double earnings() {
      return getBaseSalary() + super.earnings();
   }

   // return String representation of BasePlusCommissionEmployee object
   @Override
   public String toString() {
      return String.format("base-salaried %s; %s: $%,.2f",
         super.toString(), "base salary", getBaseSalary());
   }
}
