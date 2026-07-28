// HourlyEmployee.java
// HourlyEmployee class extends Employee -- Exercise 9.15
public class HourlyEmployee extends Employee {
   private double wage;   // wage per hour
   private double hours;  // hours worked for the week

   // five-argument constructor
   public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber, double wage, double hours) {

      super(firstName, lastName, socialSecurityNumber);
      setWage(wage);
      setHours(hours);
   }

   // set wage; ensure wage is nonnegative
   public void setWage(double wage) {
      if (wage < 0.0)
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");

      this.wage = wage;
   }

   // return wage
   public double getWage() {
      return wage;
   }

   // set hours worked; ensure hours worked is between 0 and 168
   public void setHours(double hours) {
      if (hours < 0.0 || hours > 168.0)
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");

      this.hours = hours;
   }

   // return hours worked
   public double getHours() {
      return hours;
   }

   // calculate earnings; time-and-a-half for hours worked over 40
   public double earnings() {
      if (getHours() <= 40) // no overtime
         return getWage() * getHours();
      else
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
   }

   // return String representation of HourlyEmployee object
   @Override
   public String toString() {
      return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
         "hourly employee", super.toString(),
         "hourly wage", getWage(), "hours worked", getHours());
   }
}
