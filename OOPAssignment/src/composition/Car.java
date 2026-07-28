package composition;

public class Car {
    private String make;
    private String model;
    private int year;
    private Engine engine; // Composition - Car HAS-A Engine

    public Car(String make, String model, int year, Engine engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public void displayCarDetails() {
        System.out.println("Car Details:");
        System.out.println("  Make: " + make);
        System.out.println("  Model: " + model);
        System.out.println("  Year: " + year);
        System.out.println("  Engine: " + engine.getType());
        System.out.println("  Horsepower: " + engine.getHorsepower());
        System.out.println("  Displacement: " + engine.getDisplacement() + "L");
    }

    public void startCar() {
        System.out.print("Starting car... ");
        engine.start();
    }

    public void stopCar() {
        System.out.print("Stopping car... ");
        engine.stop();
    }
}