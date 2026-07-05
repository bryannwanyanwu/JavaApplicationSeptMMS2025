import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter n to calculate Fibonacci(n): ");
        int n = input.nextInt();
        
        System.out.printf("Fibonacci(%d) = %d%n", n, fibonacci(n));
        
        // Find largest Fibonacci number using int
        System.out.println("Largest Fibonacci number using int:");
        findLargestFibonacciInt();
        
        // Find largest Fibonacci number using double
        System.out.println("\nLargest Fibonacci number using double:");
        findLargestFibonacciDouble();
        
        input.close();
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    private static void findLargestFibonacciInt() {
        int a = 0, b = 1;
        int n = 1;
        
        System.out.println("n=0: 0");
        System.out.println("n=1: 1");
        
        while (true) {
            try {
                int next = Math.addExact(a, b);
                a = b;
                b = next;
                n++;
                System.out.printf("n=%d: %d%n", n, b);
            } catch (ArithmeticException e) {
                System.out.printf("Largest n: %d, value exceeds int max%n", n);
                break;
            }
        }
    }
    
    private static void findLargestFibonacciDouble() {
        double a = 0, b = 1;
        int n = 1;
        
        System.out.println("n=0: 0.0");
        System.out.println("n=1: 1.0");
        
        while (n < 1000) {
            double next = a + b;
            if (Double.isInfinite(next)) {
                System.out.printf("Largest n: %d, value exceeds double max%n", n);
                break;
            }
            a = b;
            b = next;
            n++;
            if (n % 10 == 0) {
                System.out.printf("n=%d: %.0f%n", n, b);
            }
        }
    }
}