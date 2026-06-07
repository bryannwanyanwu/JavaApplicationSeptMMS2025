public class CompoundInterest {
    public static void main(String[] args) {
        double principal = 1000.00;
        int years = 10;

        for (int rate = 5; rate <= 10; rate++) {
            System.out.printf("%nInterest Rate: %d%%%n", rate);
            System.out.printf("%-6s %10s%n", "Year", "Amount");
            for (int year = 1; year <= years; year++) {
                double amount = principal * Math.pow(1 + rate / 100.0, year);
                System.out.printf("%-6d %10.2f%n", year, amount);
            }
        }
    }
}