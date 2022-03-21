package Reflections;

import java.lang.Class;
import java.lang.reflect.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class Vehicle {

    String brand;
    int noofWheels;
    boolean isRegistered = false;

    public Vehicle() {
        this.brand = "";
        this.noofWheels = 0;
    }

    public Vehicle(String brand, int noofWheels) {
        this.brand = brand;
        this.noofWheels = noofWheels;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoofWheels() {
        return noofWheels;
    }

    public void setNoofWheels(int noofWheels) {
        this.noofWheels = noofWheels;
    }

    private void drivingOrientation() {
        System.out.println("Right side orientation");
    }

    void register(String brand, int noofWheels) {
        this.brand = brand;
        this.noofWheels = noofWheels;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        System.out.println("Registered date: " + sdf.format(d));
        drivingOrientation();
        isRegistered = true;
    }

    @Override
    public String toString() {
        return "Vehicle [brand=" + brand + ", noofWheels=" + noofWheels + "]";
    }

}

class Car extends Vehicle {

    String carName;
    int yearofManufacture;

    public Car(String carName) {
        super();
        this.carName = carName;
        this.yearofManufacture = 2021;
    }

    public Car(String brand, int noofWheels, String carName) {
        super(brand, noofWheels);
        this.carName = carName;
        this.yearofManufacture = 2021;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getYearofManufacture() {
        return yearofManufacture;
    }

    public void register(String brand, int noofWheels, String carName) {
        super.register(brand, noofWheels);
        System.out.println(carName);
    }

    @Override
    public String toString() {
        return "Car [carName=" + carName + ", yearofManufacture=" + yearofManufacture + "]";
    }

}

public class ReflectionDemo {
    public static void main(String[] args) {

        try {
            Car c = new Car("Toyata", 4, "Fortuner");
            c.register("Toyata", 4, "Fortuner");

            Class obj = c.getClass();

            Method[] methods = obj.getDeclaredMethods();
            Constructor[] constructors = obj.getDeclaredConstructors();

            for (Method m : methods) {
                System.out.println("Method Name: " + m.getName());
                int modifier = m.getModifiers();
                System.out.println("Modifier: " + Modifier.toString(modifier));
                System.out.println("Return Types: " + m.getReturnType());
                System.out.println(" ");
            }

            for (Constructor cn : constructors) {

                System.out.println("Constructor Name: " + cn.getName());
                int modifier = cn.getModifiers();
                String mod = Modifier.toString(modifier);
                System.out.println("Modifier: " + mod);
                System.out.println("Parameters: " + cn.getParameterCount());
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
