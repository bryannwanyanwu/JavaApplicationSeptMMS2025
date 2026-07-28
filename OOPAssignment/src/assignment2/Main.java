
package assignment2;
 
/**
 * Test program for Inheritance
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Inheritance Test ===\n");
        
        // Create a Student object
        Student student = new Student("Alice Johnson", 20, "Computer Science", 3);
        student.displayInfo();
        
        // Create a Teacher object
        Teacher teacher = new Teacher 
        ("Dr. Robert Smith", 45, "Mathematics", 75000.00);
        teacher.displayInfo();
        
        // Demonstrate polymorphism
        System.out.println("\n=== Polymorphism Demonstration ===");
        Person p1 = new Student("Bob Wilson", 22, "Engineering", 4);
        Person p2 = new Teacher("Prof. Jane Doe", 50, "Physics", 82000.00);
        
        p1.displayInfo();
        p2.displayInfo();
    }
}
    
}
