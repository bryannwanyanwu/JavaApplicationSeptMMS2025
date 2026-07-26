public class Date2 {
    private int month;
    private int day;
    private int year;
    
    private static final String[] monthNames = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    
    private static final int[] daysPerMonth = 
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    // Constructor 1: MM/DD/YYYY
    public Date(int month, int day, int year) {
        validateDate(month, day, year);
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    // Constructor 2: Month DD, YYYY
    public Date(String monthName, int day, int year) {
        int monthNum = convertMonthNameToNumber(monthName);
        validateDate(monthNum, day, year);
        this.month = monthNum;
        this.day = day;
        this.year = year;
    }
    
    // Constructor 3: DDD YYYY
    public Date(int dayOfYear, int year) {
        if (dayOfYear < 1 || dayOfYear > 366)
            throw new IllegalArgumentException("Day of year must be 1-366");
        
        this.year = year;
        int remaining = dayOfYear;
        int month = 1;
        
        while (remaining > daysPerMonth[month] || 
               (month == 2 && remaining == 29 && !isLeapYear(year))) {
            if (month == 2 && isLeapYear(year)) {
                if (remaining > 29) {
                    remaining -= 29;
                } else {
                    break;
                }
            } else {
                remaining -= daysPerMonth[month];
            }
            month++;
        }
        
        this.month = month;
        this.day = remaining;
    }
    
    private void validateDate(int month, int day, int year) {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month must be 1-12");
        if (year < 0)
            throw new IllegalArgumentException("Year must be positive");
        if (day < 1 || day > daysPerMonth[month] && !(month == 2 && day == 29))
            throw new IllegalArgumentException("Invalid day");
        if (month == 2 && day == 29 && !isLeapYear(year))
            throw new IllegalArgumentException("Invalid day for non-leap year");
    }
    
    private boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
    
    private int convertMonthNameToNumber(String name) {
        for (int i = 1; i <= 12; i++) {
            if (monthNames[i].equalsIgnoreCase(name))
                return i;
        }
        throw new IllegalArgumentException("Invalid month name: " + name);
    }
    
    // Format: MM/DD/YYYY
    public String formatMMDDYYYY() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }
    
    // Format: Month DD, YYYY
    public String formatMonthDDYYYY() {
        return String.format("%s %d, %d", monthNames[month], day, year);
    }
    
    // Format: DDD YYYY
    public String formatDDDYYYY() {
        int dayOfYear = day;
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                dayOfYear += 29;
            } else {
                dayOfYear += daysPerMonth[i];
            }
        }
        return String.format("%03d %d", dayOfYear, year);
    }
    
    public String toString() {
        return formatMMDDYYYY();
    }
}

// Test program
public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date(6, 14, 1992);
        Date date2 = new Date("June", 14, 1992);
        Date date3 = new Date(166, 1992);
        
        System.out.println("Date 1: " + date1);
        System.out.println("  MM/DD/YYYY: " + date1.formatMMDDYYYY());
        System.out.println("  Month DD, YYYY: " + date1.formatMonthDDYYYY());
        System.out.println("  DDD YYYY: " + date1.formatDDDYYYY());
        
        System.out.println("\nDate 2: " + date2);
        System.out.println("  MM/DD/YYYY: " + date2.formatMMDDYYYY());
        System.out.println("  Month DD, YYYY: " + date2.formatMonthDDYYYY());
        System.out.println("  DDD YYYY: " + date2.formatDDDYYYY());
        
        System.out.println("\nDate 3: " + date3);
        System.out.println("  MM/DD/YYYY: " + date3.formatMMDDYYYY());
        System.out.println("  Month DD, YYYY: " + date3.formatMonthDDYYYY());
        System.out.println("  DDD YYYY: " + date3.formatDDDYYYY());
    }
}