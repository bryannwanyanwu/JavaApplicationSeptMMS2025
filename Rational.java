public class Rational {
    private int numerator;
    private int denominator;
    
    // No-argument constructor
    public Rational() {
        this(0, 1);
    }
    
    // Constructor
    public Rational(int num, int den) {
        if (den == 0)
            throw new IllegalArgumentException("Denominator cannot be zero");
        
        // Normalize sign
        if (den < 0) {
            num = -num;
            den = -den;
        }
        
        // Reduce fraction
        int gcd = gcd(Math.abs(num), Math.abs(den));
        this.numerator = num / gcd;
        this.denominator = den / gcd;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Add two rational numbers
    public static Rational add(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }
    
    // Subtract two rational numbers
    public static Rational subtract(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }
    
    // Multiply two rational numbers
    public static Rational multiply(Rational r1, Rational r2) {
        int num = r1.numerator * r2.numerator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }
    
    // Divide two rational numbers
    public static Rational divide(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator;
        int den = r1.denominator * r2.numerator;
        return new Rational(num, den);
    }
    
    // Format as fraction
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }
    
    // Format as floating-point
    public String toFloatingString() {
        return String.format("%.6f", (double) numerator / denominator);
    }
    
    public String toFloatingString(int precision) {
        return String.format("%." + precision + "f", (double) numerator / denominator);
    }
}

// Test program
public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(2, 4);  // 1/2
        Rational r2 = new Rational(3, 6);  // 1/2
        Rational r3 = new Rational(1, 3);  // 1/3
        
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        
        System.out.println("\nAdd: " + Rational.add(r1, r3));
        System.out.println("Subtract: " + Rational.subtract(r1, r3));
        System.out.println("Multiply: " + Rational.multiply(r1, r3));
        System.out.println("Divide: " + Rational.divide(r1, r3));
        
        System.out.println("\nFloating point (default): " + r1.toFloatingString());
        System.out.println("Floating point (3 decimals): " + r1.toFloatingString(3));
        System.out.println("Floating point (1 decimal): " + r1.toFloatingString(1));
    }
}