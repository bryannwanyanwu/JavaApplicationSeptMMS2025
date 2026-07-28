// BasePlusCommissionEmployee.java
// Rewritten to use COMPOSITION ("has-a") instead of inheritance ("is-a").
// Exercise 9.3
public class BasePlusCommissionEmployee {
   // instead of extending CommissionEmployee, this class HAS a
   // CommissionEmployee object and delegates to it as needed
   private final CommissionEmployee commissionEmployee;
   private double baseSalary;

   public BasePlusCommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, double grossSales, double commissionRate,
      double baseSalary) {

      commissionEmployee = new CommissionEmployee(
         firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
      setBaseSalary(baseSalary);
   }

   // delegate to the composed CommissionEmployee object
   public String getFirstName() {
      return commissionEmployee.getFirstName();
   }

   public String getLastName() {
      return commissionEmployee.getLastName();
   }

   public String getSocialSecurityNumber() {
      return commissionEmployee.getSocialSecurityNumber();
   }

   public void setGrossSales(double grossSales) {
      commissionEmployee.setGrossSales(grossSales);
   }

   public double getGrossSales() {
      return commissionEmployee.getGrossSales();
   }

   public void setCommissionRate(double commissionRate) {
      commissionEmployee.setCommissionRate(commissionRate);
   }

   public double getCommissionRate() {
      return commissionEmployee.getCommissionRate();
   }

   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0)
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      this.baseSalary = baseSalary;
   }

   public double getBaseSalary() {
      return baseSalary;
   }

   // earnings = base salary + composed CommissionEmployee's earnings
   public double earnings() {
      return getBaseSalary() + commissionEmployee.earnings();
   }

   @Override
   public String toString() {
      return String.format("base-salaried %s%n%s: $%,.2f",
         commissionEmployee, "base salary", getBaseSalary());
   }
}

