package composition;

public class Engine {
    private String type;
    private int horsepower;
    private double displacement; // in liters

    public Engine(String type, int horsepower, double displacement) {
        this.type = type;
        this.horsepower = horsepower;
        this.displacement = displacement;
    }

    public void start() {
        System.out.println(type + " engine started.");
    }

    public void stop() {
        System.out.println(type + " engine stopped.");
    }

    // Getters
    public String getType() { return type; }
    public int getHorsepower() { return horsepower; }
    public double getDisplacement() { return displacement; }
}