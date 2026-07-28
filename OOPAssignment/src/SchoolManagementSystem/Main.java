
package SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 10: School Management System ===\n");
        
        // Create teachers
        System.out.println("--- Creating Teachers ---");
        Teacher teacher1 = new Teacher("TCH-001", "Dr. Smith", "Computer Science");
        Teacher teacher2 = new Teacher("TCH-002", "Prof. Johnson", "Mathematics");
        Teacher teacher3 = new Teacher("TCH-003", "Dr. Williams", "Physics");
        
        // Create courses
        System.out.println("\n--- Creating Courses ---");
        Course course1 = new Course("CS-101", "Introduction to Programming", "CS101", 30);
        Course course2 = new Course("CS-102", "Data Structures", "CS102", 25);
        Course course3 = new Course("MATH-101", "Calculus I", "MATH101", 35);
        Course course4 = new Course("PHY-101", "Physics I", "PHY101", 30);
        Course course5 = new Course("CS-201", "Database Systems", "CS201", 25);
        
        // Assign teachers to courses
        System.out.println("\n--- Assigning Teachers to Courses ---");
        teacher1.assignCourse(course1);
        teacher1.assignCourse(course2);
        teacher1.assignCourse(course5);
        teacher2.assignCourse(course3);
        teacher3.assignCourse(course4);
        
        // Create students
        System.out.println("\n--- Creating Students ---");
        Student student1 = new Student("STU-001", "Alice Johnson", 19, "Freshman");
        Student student2 = new Student("STU-002", "Bob Williams", 20, "Sophomore");
        Student student3 = new Student("STU-003", "Charlie Davis", 18, "Freshman");
        Student student4 = new Student("STU-004", "Diana Miller", 21, "Junior");
        Student student5 = new Student("STU-005", "Edward Brown", 20, "Sophomore");
        
        // Enroll students in courses
        System.out.println("\n--- Enrolling Students ---");
        student1.enrollCourse(course1);
        student1.enrollCourse(course3);
        student1.enrollCourse(course4);
        
        student2.enrollCourse(course1);
        student2.enrollCourse(course2);
        student2.enrollCourse(course5);
        
        student3.enrollCourse(course1);
        student3.enrollCourse(course3);
        
        student4.enrollCourse(course2);
        student4.enrollCourse(course5);
        
        student5.enrollCourse(course1);
        student5.enrollCourse(course2);
        student5.enrollCourse(course3);
        student5.enrollCourse(course4);
        
        // Create classrooms and schedule courses
        System.out.println("\n--- Creating Classrooms ---");
        Classroom classroom1 = new Classroom("101", "Science Building", 30);
        Classroom classroom2 = new Classroom("203", "Engineering Building", 25);
        Classroom classroom3 = new Classroom("305", "Main Building", 35);
        
        System.out.println("\n--- Scheduling Courses ---");
        classroom1.scheduleCourse(course1);
        classroom1.scheduleCourse(course3);
        classroom2.scheduleCourse(course2);
        classroom2.scheduleCourse(course5);
        classroom3.scheduleCourse(course4);
        
        // Display all information
        System.out.println("\n=== Displaying All Information ===");
        
        // Display teacher information
        System.out.println("\n--- Teacher Information ---");
        teacher1.displayInfo();
        teacher2.displayInfo();
        teacher3.displayInfo();
        
        // Display student information
        System.out.println("\n--- Student Information ---");
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        student4.displayInfo();
        student5.displayInfo();
        
        // Display course information
        System.out.println("\n--- Course Information ---");
        course1.displayInfo();
        course1.displayStudents();
        course2.displayInfo();
        course2.displayStudents();
        course3.displayInfo();
        course3.displayStudents();
        course4.displayInfo();
        course4.displayStudents();
        course5.displayInfo();
        course5.displayStudents();
        
        // Display classroom information
        System.out.println("\n--- Classroom Information ---");
        classroom1.displayInfo();
        classroom2.displayInfo();
        classroom3.displayInfo();
        
        System.out.println("\n=== School Management System Test Complete ===");
    }
}
    

