package DesignPatterns.creationalPatterns;

interface Builder {
    void reset();

    void setSeats(int number);

    void setEngine(Engine engine);

    void setTripComputer();

    void setGPS();
}

class CarBuilder implements Builder {
    private Car car;

    CarBuilder() {
        this.reset();
    }

    public void reset() {
        this.car = new Car();

    }

    public void setSeats(int number) {
        car.setSeats(number);

    }

    public void setEngine(Engine engine) {
        car.setEngine(engine);

    }

    public void setTripComputer() {
        car.setTripComputer();

    }

    public void setGPS() {
        car.setGPS();

    }

    public Car getResult() {
        return car;
    }

}

class Engine {
    double volume;
    double mileage;

    Engine() {

    }

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Engine: mileage=" + mileage + ", volume=" + volume;
    }

}

class SportEngine extends Engine {

    SportEngine() {
    }

    public SportEngine(double volume, double mileage) {
        super(volume, mileage);
    }
}

class Car {
    private int seats;
    private Engine engine;
    private String GPS;
    private String tripComputer;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS() {
        this.GPS = "Functional";
    }

    public String getTripComputer() {
        return tripComputer;
    }

    public void setTripComputer() {
        this.tripComputer = "Functional";
    }

    @Override
    public String toString() {
        return "Car [GPS=" + GPS + ", engine=" + engine + ", seats=" + seats + ", tripComputer=" + tripComputer + "]";
    }

}

class AutomobileEngineer { // Director
    private Builder builder;

    public AutomobileEngineer() {

    }

    public AutomobileEngineer(Builder builder) {
        this.builder = builder;
    }

    public void makeSUV(Builder builder) {

        builder.reset();
        builder.setSeats(6);
        builder.setEngine(new Engine(3, 4.5));
        builder.setTripComputer();
        builder.setGPS();
        System.out.println("Type of car: SUV");

    }

    public void makeSportsCar(Builder builder) {

        builder.reset();
        builder.setSeats(1);
        builder.setEngine(new SportEngine(2, 7.5));
        builder.setTripComputer();
        builder.setGPS();
        System.out.println("Type of car: SPORTS CAR");

    }

}

public class BuilderPatterns {
    public static void main(String[] args) {
        AutomobileEngineer engineer = new AutomobileEngineer();
        CarBuilder builder = new CarBuilder();

        engineer.makeSportsCar(builder);
        System.out.println("Car built");
        Car car = builder.getResult();
        System.out.println(car);

        engineer.makeSUV(builder);
        System.out.println("Car built");
        Car car1 = builder.getResult();
        System.out.println(car1);

    }

}
