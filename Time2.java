public class Time2 {
    private int totalSeconds; // number of seconds since midnight
    
    // No-argument constructor
    public Time2() {
        this(0, 0, 0);
    }
    
    // Constructor with hour supplied
    public Time2(int hour) {
        this(hour, 0, 0);
    }
    
    // Constructor with hour and minute supplied
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }
    
    // Constructor with hour, minute, and second supplied
    public Time2(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    
    // Constructor with another Time2 object supplied
    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }
    
    // Set Methods
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
            
        totalSeconds = hour * 3600 + minute * 60 + second;
    }
    
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        int minute = getMinute();
        int second = getSecond();
        totalSeconds = hour * 3600 + minute * 60 + second;
    }
    
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        int hour = getHour();
        int second = getSecond();
        totalSeconds = hour * 3600 + minute * 60 + second;
    }
    
    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
        int hour = getHour();
        int minute = getMinute();
        totalSeconds = hour * 3600 + minute * 60 + second;
    }
    
    // Get Methods
    public int getHour() {
        return totalSeconds / 3600;
    }
    
    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }
    
    public int getSecond() {
        return totalSeconds % 60;
    }
    
    // Convert to Universal Time String
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
    
    // Convert to Standard Time String
    public String toString() {
        return String.format("%d:%02d:%02d %s", 
            ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
            getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}