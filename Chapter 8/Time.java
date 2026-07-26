public class Time2 {
    private int hour;   // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    
    // Existing constructors and methods (as shown in Fig. 8.5)
    // ... (all previous Time2 code goes here)
    
    // New methods
    public void tick() {
        second++;
        if (second >= 60) {
            second = 0;
            incrementMinute();
        }
    }
    
    public void incrementMinute() {
        minute++;
        if (minute >= 60) {
            minute = 0;
            incrementHour();
        }
    }
    
    public void incrementHour() {
        hour++;
        if (hour >= 24) {
            hour = 0;
        }
    }
}

// Test program
public class Time2Test {
    public static void main(String[] args) {
        Time2 time = new Time2(23, 59, 59);
        System.out.println("Starting time: " + time.toString());
        
        System.out.println("\nTesting tick (increment by one second):");
        time.tick();
        System.out.println("After tick: " + time.toString());
        System.out.println("Universal: " + time.toUniversalString());
        
        // Test increment into next minute
        System.out.println("\nTesting increment into next minute:");
        time.setTime(10, 59, 59);
        System.out.println("Start: " + time.toString());
        time.tick();
        System.out.println("After tick: " + time.toString());
        
        // Test increment into next hour
        System.out.println("\nTesting increment into next hour:");
        time.setTime(11, 59, 59);
        System.out.println("Start: " + time.toString());
        time.tick();
        System.out.println("After tick: " + time.toString());
        
        // Test increment into next day
        System.out.println("\nTesting increment into next day:");
        time.setTime(23, 59, 59);
        System.out.println("Start: " + time.toString());
        time.tick();
        System.out.println("After tick: " + time.toString());
        System.out.println("Universal: " + time.toUniversalString());
    }
}