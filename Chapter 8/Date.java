public class Date {
    private int month; // 1-12
    private int day;   // 1-31 based on month
    private int year;  // any year
    
    private static final int[] daysPerMonth = 
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Date(int month, int day, int year) {
        // Validate month
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        
        // Validate day
        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + 
                ") out-of-range for the specified month and year");
        
        // Check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !isLeapYear(year))
            throw new IllegalArgumentException("day (" + day + 
                ") out-of-range for the specified month and year");
        
        // Validate year
        if (year < 0)
            throw new IllegalArgumentException("year (" + year + ") must be positive");
        
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    private boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
    
    public void nextDay() {
        if (day < daysPerMonth[month] || (month == 2 && day == 29)) {
            day++;
        } else {
            day = 1;
            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }
    }
    
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}

// Test program
public class DateTest {
    public static void main(String[] args) {
        // Test incrementing into next month
        System.out.println("Testing increment into next month:");
        Date date1 = new Date(1, 31, 2024);
        for (int i = 0; i < 5; i++) {
            System.out.println(date1);
            date1.nextDay();
        }
        
        // Test incrementing into next year
        System.out.println("\nTesting increment into next year:");
        Date date2 = new Date(12, 31, 2024);
        for (int i = 0; i < 5; i++) {
            System.out.println(date2);
            date2.nextDay();
        }
    }
}