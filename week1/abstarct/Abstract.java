package week1.abstarct;

abstract class Shape {
    String name;
    double area;
    double perimeter;

    protected Shape() {
        this.name = "";
        this.area = 0.0;
        this.perimeter = 0.0;
    }

    protected Shape(String name) {
        this.name = name;
    }

    abstract void draw();

    abstract void calculateArea();

    abstract void calculatePerimeter();

    @Override
    public String toString() {
        return "Shape [area=" + area + ", name=" + name + ", perimeter=" + perimeter + "]";
    }

}

class Rectangle extends Shape {
    double l;
    int b;

    public Rectangle(double l, int b) {
        this.l = l;
        this.b = b;
    }

    public Rectangle(String name, double l, int b) {
        super(name);
        this.l = l;
        this.b = b;
    }

    void calculateArea() {
        area = l * b;
    }

    void calculatePerimeter() {
        perimeter = 2 * (l + b);
    }

    void draw() {
        name = "Rectangle";
    }

    @Override
    public String toString() {
        return "Rectangle [b=" + b + ", l=" + l + "]" + super.toString();
    }

}

class Square extends Shape {

    double l;

    public Square(double l) {
        this.l = l;
    }

    public Square(String name, double l) {
        super(name);
        this.l = l;
    }

    void calculateArea() {
        area = l * l;
    }

    void calculatePerimeter() {
        perimeter = 4 * l;
    }

    void draw() {
        name = "Square";
    }

    @Override
    public String toString() {
        return "Square [l=" + l + "]" + super.toString();
    }

}

class Circle extends Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    public Circle(String name, int r) {
        super(name);
        this.r = r;
    }

    void calculateArea() {
        area = 4 * 3.14 * r * r;
    }

    void calculatePerimeter() {
        perimeter = 2 * 3.14 * r;
    }

    void draw() {
        name = "Circle";
    }

    @Override
    public String toString() {
        return "Circle [r=" + r + "]" + super.toString();
    }

}

public class Abstract {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle("rectangle", 5, 4);
        rect.calculateArea();
        rect.calculatePerimeter();
        rect.draw();
        System.out.println(rect);

        Circle circle = new Circle("Circle", 5);
        rect.calculateArea();
        rect.calculatePerimeter();
        rect.draw();
        System.out.println(circle);

        Square square = new Square("Square", 3.0);
        rect.calculateArea();
        rect.calculatePerimeter();
        rect.draw();
        System.out.println(square);
    }
}
