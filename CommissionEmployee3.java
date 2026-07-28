// CommissionEmployee.java
// CommissionEmployee class extends Employee -- Exercise 9.14
public class CommissionEmployee extends Employee {
   private double grossSales;      // gross weekly sales
   private double commissionRate;  // commission percentage

   // five-argument constructor
   public CommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, double grossSales, double commissionRate) {

      // pass firstName, lastName and SSN to Employee constructor
      super(firstName, lastName, socialSecurityNumber);
      setGrossSales(grossSales);
      setCommissionRate(commissionRate);
   }

   // set commission rate
   public void setCommissionRate(double commissionRate) {
      if (commissionRate <= 0.0 || commissionRate >= 1.0)
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");

      this.commissionRate = commissionRate;
   }

   // return commission rate
   public double getCommissionRate() {
      return commissionRate;
   }

   // set gross sales amount
   public void setGrossSales(double grossSales) {
      if (grossSales < 0.0)
         throw new IllegalArgumentException("Gross sales must be >= 0.0");

      this.grossSales = grossSales;
   }

   // return gross sales amount
   public double getGrossSales() {
      return grossSales;
   }

   // calculate earnings
   public double earnings() {
      return getCommissionRate() * getGrossSales();
   }

   // return String representation of CommissionEmployee object
   @Override
   public String toString() {
      return String.format("%s: %s%n%s: $%,.2f%n%s: %.2f",
         "commission employee", super.toString(),
         "gross sales", getGrossSales(),
         "commission rate", getCommissionRate());
   }
}
