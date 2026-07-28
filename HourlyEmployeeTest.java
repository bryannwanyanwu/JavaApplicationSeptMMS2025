// HourlyEmployeeTest.java
// Testing class HourlyEmployee -- Exercise 9.15
public class HourlyEmployeeTest {
   public static void main(String[] args) {
      // test a normal work week (no overtime)
      HourlyEmployee employee1 = new HourlyEmployee(
         "Karen", "Price", "222-22-9999", 16.75, 40);

      // test a week with overtime hours (> 40)
      HourlyEmployee employee2 = new HourlyEmployee(
         "Dan", "Coker", "444-44-1111", 20.00, 45);

      System.out.println("Employee 1 information obtained by get methods:");
      System.out.printf("%n%s %s%n", "First name is", employee1.getFirstName());
      System.out.printf("%s %s%n", "Last name is", employee1.getLastName());
      System.out.printf("%s %s%n", "Social security number is",
         employee1.getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Hourly wage is", employee1.getWage());
      System.out.printf("%s %.2f%n", "Hours worked is", employee1.getHours());

      System.out.printf("%n%s:%n%n%s%n", "Employee 1 information (toString)",
         employee1);
      System.out.printf("earnings: $%,.2f%n%n", employee1.earnings());

      System.out.printf("%s:%n%n%s%n", "Employee 2 information (toString)",
         employee2);
      System.out.printf("earnings (with overtime): $%,.2f%n", employee2.earnings());

      // demonstrate validation
      try {
         employee1.setHours(200); // invalid: > 168
      }
      catch (IllegalArgumentException e) {
         System.out.printf("%nException caught: %s%n", e.getMessage());
      }

      try {
         employee1.setWage(-5.0); // invalid: negative
      }
      catch (IllegalArgumentException e) {
         System.out.printf("Exception caught: %s%n", e.getMessage());
      }
   }
}
