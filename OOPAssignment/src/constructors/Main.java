
package constructors;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 6: Constructors Test ===\n");
        
        // Create book using default constructor
        System.out.println("Creating book with default constructor:");
        Book book1 = new Book();
        book1.displayDetails();
        
        // Create book using parameterized constructor
        System.out.println("\nCreating book with parameterized constructor:");
        Book book2 = new Book("Java Programming", "John Doe", 59.99);
        book2.displayDetails();
        
        // Create another book with parameterized constructor
        System.out.println("\nCreating another book:");
        Book book3 = new Book("Machine Learning", "Dr. Johnson", 79.99);
        book3.displayDetails();
    }
}
}
