package AbstractClasses;

abstract class Vehicle {
    abstract void drive();

    abstract void steeringMechanism();

    void start() {
        System.out.println("Vehicle Started");
    }

    void stop() {
        System.out.println("Vehicle Stopped");
    }
}

class Bike extends Vehicle {
    void drive() {
        System.out.println("Driving Bike ");
    }

    void steeringMechanism() {
        System.out.println("Bike handle ");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Driving Car ");
    }

    void steeringMechanism() {
        System.out.println("Car Steering ");
    }

}

public class AbstractClass {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();
        System.out.println("Car mechanism :");
        car.drive();
        car.steeringMechanism();
        car.start();
        car.stop();
        System.out.println("Bike mechanism :");
        bike.drive();
        bike.steeringMechanism();
        bike.start();
    }
}
