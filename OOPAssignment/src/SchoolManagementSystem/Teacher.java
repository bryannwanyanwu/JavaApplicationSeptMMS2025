
package SchoolManagementSystem;


 
public class Teacher {
    

import java.util.ArrayList;

public class Teacher {
    private String teacherId;
    private String name;
    private String department;
    private ArrayList<Course> taughtCourses;
    
    public Teacher(String teacherId, String name, String department) {
        this.teacherId = teacherId;
        this.name = name;
        this.department = department;
        this.taughtCourses = new ArrayList<>();
    }
    
    public String getTeacherId() { return teacherId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public ArrayList<Course> getTaughtCourses() { return taughtCourses; }
    
    public void assignCourse(Course course) {
        if (!taughtCourses.contains(course)) {
            taughtCourses.add(course);
            course.setTeacher(this);
            System.out.println(name + " assigned to teach " + course.getCourseName());
        }
    }
    
    public void displayInfo() {
        System.out.println("\n=== Teacher Information ===");
        System.out.println("ID: " + teacherId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Taught Courses: " + taughtCourses.size());
        if (!taughtCourses.isEmpty()) {
            for (Course course : taughtCourses) {
                System.out.println("  - " + course.getCourseName());
            }
        }
        System.out.println("============================");
    }
}
    
}
