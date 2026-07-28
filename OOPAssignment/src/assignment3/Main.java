
package assignment3;


public class Main {
    package assignment3;

/**
 * Test program for Method Overloading
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 3: Method Overloading Test ===\n");
        
        Calculator calc = new Calculator();
        
        // Test all overloaded methods
        System.out.println("1. Add two integers (5 + 3): " + calc.calculate(5, 3));
        
        System.out.println("2. Add three integers (5 + 3 + 2): " + calc.calculate(5, 3, 2));
        
        System.out.println("3. Add two doubles (5.5 + 3.2): " + calc.calculate(5.5, 3.2));
        
        System.out.println("4. Multiply two integers (5 * 3): " + calc.calculate(5, 3, "multiply"));
        
        System.out.println("5. Add double and int (5.5 + 3): " + calc.calculate(5.5, 3));
        
        System.out.println("6. Multiply with operation string: " + calc.calculate("multiply", 5, 3));
        
        System.out.println("\n=== All Overloaded Methods Tested Successfully ===");
    }
}
    
}
