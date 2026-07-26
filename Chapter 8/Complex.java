public class Complex {
    private double realPart;
    private double imaginaryPart;
    
    // No-argument constructor
    public Complex() {
        this(0.0, 0.0);
    }
    
    // Constructor with parameters
    public Complex(double real, double imaginary) {
        realPart = real;
        imaginaryPart = imaginary;
    }
    
    // Add two complex numbers
    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.realPart + c2.realPart,
            c1.imaginaryPart + c2.imaginaryPart);
    }
    
    // Subtract two complex numbers
    public static Complex subtract(Complex c1, Complex c2) {
        return new Complex(c1.realPart - c2.realPart,
            c1.imaginaryPart - c2.imaginaryPart);
    }
    
    // Print complex number
    public String toString() {
        return String.format("(%.2f, %.2f)", realPart, imaginaryPart);
    }
}

// Test program
public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.5, 2.0);
        Complex c2 = new Complex(1.5, 1.0);
        
        System.out.println("Complex Number 1: " + c1);
        System.out.println("Complex Number 2: " + c2);
        System.out.println("Sum: " + Complex.add(c1, c2));
        System.out.println("Difference: " + Complex.subtract(c1, c2));
    }
}