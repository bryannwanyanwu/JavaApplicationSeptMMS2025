
package SchoolManagementSystem;

public class classroom {
import java.util.ArrayList;

public class Classroom {
    private String roomNumber;
    private String building;
    private int capacity;
    private ArrayList<Course> scheduledCourses;
    
    public Classroom(String roomNumber, String building, int capacity) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.capacity = capacity;
        this.scheduledCourses = new ArrayList<>();
    }
    
    public String getRoomNumber() { return roomNumber; }
    public String getBuilding() { return building; }
    public int getCapacity() { return capacity; }
    public ArrayList<Course> getScheduledCourses() { return scheduledCourses; }
    
    public void scheduleCourse(Course course) {
        if (!scheduledCourses.contains(course)) {
            scheduledCourses.add(course);
            System.out.println(course.getCourseName() + " scheduled in room " + roomNumber);
        }
    }
    
    public void displayInfo() {
        System.out.println("\n=== Classroom Information ===");
        System.out.println("Room: " + roomNumber);
        System.out.println("Building: " + building);
        System.out.println("Capacity: " + capacity);
        System.out.println("Scheduled Courses: " + scheduledCourses.size());
        if (!scheduledCourses.isEmpty()) {
            for (Course course : scheduledCourses) {
                System.out.println("  - " + course.getCourseName());
            }
        }
        System.out.println("==============================");
    }
}
    
}
