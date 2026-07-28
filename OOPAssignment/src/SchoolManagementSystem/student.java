
package SchoolManagementSystem;

public class student {
import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String grade;
    private ArrayList<Course> enrolledCourses;
    
    public Student(String studentId, String name, int age, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
    public ArrayList<Course> getEnrolledCourses() { return enrolledCourses; }
    
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getCourseName());
        } else {
            System.out.println(name + " is already enrolled in " + course.getCourseName());
        }
    }
    
    public void displayInfo() {
        System.out.println("\n=== Student Information ===");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        if (!enrolledCourses.isEmpty()) {
            for (Course course : enrolledCourses) {
                System.out.println("  - " + course.getCourseName());
            }
        }
        System.out.println("============================");
    }
}
}
