package assignment4;

// Parent class
class Vehicle {
    String name;
    
    Vehicle(String name) {
        this.name = name;
    }
    
    void move() {
        System.out.println(name + " is moving");
    }
}

// Car class
class Car extends Vehicle {
    Car(String name) {
        super(name);
    }
    
    @Override
    void move() {
        System.out.println(name + " is driving on the road");
    }
}

// Bicycle class - changed to lowercase 'bicycle'
class Bicycle extends Vehicle {  // ← Changed from Bicycle to bicycle
    Bicycle(String name) {        // ← Changed constructor
        super(name);
    }
    
    @Override
    void move() {
        System.out.println(name + " is pedaling on the trail");
    }
}

// Airplane class
class Airplane extends Vehicle {
    Airplane(String name) {
        super(name);
    }
    
    @Override
    void move() {
        System.out.println(name + " is flying in the sky");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 4: Method Overriding Test ===\n");
        
        Vehicle[] vehicles = {
            new Car("Toyota Camry"),
            new Bicycle("Mountain Bike"),  // ← Changed from Bicycle to bicycle
            new Airplane("Boeing 747")
        };
        
        System.out.println("--- All Vehicles Moving ---\n");
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            System.out.println();
        }
    }
}