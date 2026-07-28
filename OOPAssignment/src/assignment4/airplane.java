package assignment4;

public class airplane extends Vehicle {
    public airplane(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " is flying through the air.");
        System.out.println("  - Jets are thrusting");
        System.out.println("  - Wings are providing lift");
        System.out.println("  - Altitude is increasing");
    }
}