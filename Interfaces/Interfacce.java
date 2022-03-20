package Interfaces;

interface Shape {
    void draw();
}

interface Polygon {

    double getArea();

    double getPerimeter();

    boolean isPolygon();
}

class Line implements Shape {

    @Override
    public void draw() {
        System.out.println("I am of " + this.getClass().getName() + "Shape");
    }

}

class Rectangle implements Polygon, Shape {
    double area;
    double perimeter;
    int noOfSides;
    double l;
    double b;
    String name;

    public Rectangle(String name, int noOfSides, int l, int b) {
        this.name = name;
        this.l = l;
        this.b = b;
        this.noOfSides = noOfSides;
    }

    public double getArea() {
        return l * b;
    }

    public double getPerimeter() {
        return 2 * (l + b);
    }

    public boolean isPolygon() {
        return this.noOfSides > 1;
    }

    public void draw() {
        System.out.println("I am of " + name + " shape");
    }

    @Override
    public String toString() {
        return "Rectangle [noOfSides=" + noOfSides + ", b=" + b + ", l=" + l + ", name=" + name + " ]";
    }

}

class Triangle implements Polygon, Shape {
    double area;
    double perimeter;
    int noOfSides;
    int a;
    double b;
    int c;
    double height;
    double base;
    String name;

    public Triangle(String name, int noOfSides, int a, int b, int c, double height, double base) {
        this.noOfSides = noOfSides;
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
        this.base = base;
        this.name = name;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public boolean isPolygon() {
        return this.noOfSides > 1;
    }

    public void draw() {
        System.out.println("I am of " + name + " shape");
    }

    @Override
    public String toString() {
        return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", base=" + base + ", height=" + height
                + ", name=" + name + ", noOfSides=" + noOfSides + " ]";
    }

}

public class Interfacce {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle("Rectangle", 4, 10, 12);
        Triangle tr = new Triangle("Triangle", 3, 15, 20, 30, 12, 20);

        System.out.println(rect);
        System.out.println("Area : " + rect.getArea());
        System.out.println("Perimeter : " + rect.getPerimeter());
        rect.draw();
        System.out.println("It is a Polygon : " + rect.isPolygon());

        System.out.println(tr);
        System.out.println("Area : " + tr.getArea());
        System.out.println("Perimeter : " + tr.getPerimeter());
        tr.draw();
        System.out.println("It is a Polygon : " + tr.isPolygon());

    }
}