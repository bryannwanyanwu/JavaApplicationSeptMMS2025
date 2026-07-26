public class Rectangle {
    private double length;
    private double width;
    
    // No-argument constructor
    public Rectangle() {
        this(1.0, 1.0);
    }
    
    // Constructor with parameters
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }
    
    // Set methods with validation
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be > 0.0 and < 20.0");
        }
    }
    
    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be > 0.0 and < 20.0");
        }
    }
    
    // Get methods
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    // Calculate perimeter and area
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    public double calculateArea() {
        return length * width;
    }
}

// Test program
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        
        System.out.println("Rectangle 1:");
        System.out.printf("Length: %.2f, Width: %.2f%n", 
            rect1.getLength(), rect1.getWidth());
        System.out.printf("Perimeter: %.2f, Area: %.2f%n%n", 
            rect1.calculatePerimeter(), rect1.calculateArea());
            
        System.out.println("Rectangle 2:");
        System.out.printf("Length: %.2f, Width: %.2f%n", 
            rect2.getLength(), rect2.getWidth());
        System.out.printf("Perimeter: %.2f, Area: %.2f%n", 
            rect2.calculatePerimeter(), rect2.calculateArea());
    }
}