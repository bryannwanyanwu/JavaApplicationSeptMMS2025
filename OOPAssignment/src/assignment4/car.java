package assignment4;

public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " is moving on the road using wheels.");
        System.out.println("  - Engine is running");
        System.out.println("  - Steering wheel is turning");
        System.out.println("  - Accelerator is pressed");
    }
}