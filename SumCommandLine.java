public class SumCommandLine {
    public static void main(String[] args) {
        double sum = 0.0;
        
        for (String arg : args) {
            try {
                sum += Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + arg);
            }
        }
        
        System.out.printf("Sum of numbers: %.2f%n", sum);
    }
}