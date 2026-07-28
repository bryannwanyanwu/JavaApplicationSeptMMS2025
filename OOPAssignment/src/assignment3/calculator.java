
package assignment3;


public class calculator {

/**
 * Assignment 3: Method Overloading
 */
public class Calculator {
    
    // Add two integers
    public int calculate(int a, int b) {
        return a + b;
    }
    
    // Add three integers
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
    
    // Add two doubles
    public double calculate(double a, double b) {
        return a + b;
    }
    
    // Multiply two integers
    public int calculate(int a, int b, String operation) {
        if (operation.equals("multiply")) {
            return a * b;
        }
        return 0;
    }
    
    // Overloaded method with different order
    public double calculate(double a, int b) {
        return a + b;
    }
    
    public int calculate(String operation, int a, int b) {
        if (operation.equals("multiply")) {
            return a * b;
        }
        return 0;
    }
}
    
}
