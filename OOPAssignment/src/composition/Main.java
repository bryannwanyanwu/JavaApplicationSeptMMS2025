
package composition;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 7: Composition Test ===\n");
        
        // Create an engine
        Engine engine1 = new Engine("V8 Petrol", 450, 5.0);
        
        // Create a car with the engine
        Car car1 = new Car("Ford", "Mustang", 2024, engine1);
        
        // Display car details
        car1.displayCarDetails();
        
        // Start the car
        car1.startCar();
        
        // Stop the car
        car1.stopCar();
        
        // Create another car with a different engine
        System.out.println("\n--- Creating Another Car ---");
        Engine engine2 = new Engine("Electric", 200, 0.0);
        Car car2 = new Car("Tesla", "Model 3", 2024, engine2);
        
        car2.displayCarDetails();
        car2.startCar();
        car2.stopCar();
    }
}
    
}
