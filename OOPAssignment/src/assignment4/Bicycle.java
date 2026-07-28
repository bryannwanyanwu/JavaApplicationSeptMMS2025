
package assignment4;


public class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " is moving using pedaling power.");
        System.out.println("  - Pedals are rotating");
        System.out.println("  - Chain is turning the gears");
        System.out.println("  - Human power is being used");
    }
}
    

