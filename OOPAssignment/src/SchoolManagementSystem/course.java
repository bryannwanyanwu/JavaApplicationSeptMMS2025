
package SchoolManagementSystem;


public class course {
    

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private String code;
    private Teacher teacher;
    private ArrayList<Student> students;
    private int maxCapacity;
    
    public Course(String courseId, String courseName, String code, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.code = code;
        this.maxCapacity = maxCapacity;
        this.students = new ArrayList<>();
    }
    
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCode() { return code; }
    public Teacher getTeacher() { return teacher; }
    public ArrayList<Student> getStudents() { return students; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getEnrollmentCount() { return students.size(); }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public void addStudent(Student student) {
        if (students.size() < maxCapacity && !students.contains(student)) {
            students.add(student);
        }
    }
    
    public void displayInfo() {
        System.out.println("\n=== Course Information ===");
        System.out.println("ID: " + courseId);
        System.out.println("Name: " + courseName);
        System.out.println("Code: " + code);
        System.out.println("Teacher: " + (teacher != null ? teacher.getName() : "Not assigned"));
        System.out.println("Students: " + students.size() + "/" + maxCapacity);
        System.out.println("============================");
    }
    
    public void displayStudents() {
        System.out.println("\n=== Students Enrolled in " + courseName + " ===");
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                System.out.println("  - " + student.getName() + " (ID: " + student.getStudentId() + ")");
            }
        }
        System.out.println("============================================");
    }
}
    
}
