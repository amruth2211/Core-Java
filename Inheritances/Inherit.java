package Inheritances;

class Person {
    String name;

    Person() {
        name = "";
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printPerson() {
        System.out.println("Name: " + name);
    }
}

class Employee extends Person {
    double salary;
    int year;
    String uan;

    Employee() {
        this.salary = 0;
        this.year = 0;
        this.uan = "";
        this.name = "";
    }

    public Employee(String name, double salary, int year, String uan) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.uan = uan;
    }

    public String getUan() {
        return uan;
    }

    public void setUan(String uan) {
        this.uan = uan;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDateOfJoin() {
        return year;
    }

    public void setDateOfJoin(int year) {
        this.year = year;
    }

    public void printDetails() {
        System.out.println("Name: " + name + "\nYear : " + year + "\nsalary : " + salary + "\nuan : " + uan);
    }

}

public class Inherit {
    public static void main(String[] args) {
        Employee obj1 = new Employee("amruth", 24000, 1996, "123");
        Employee obj2 = new Employee("las", 35000, 1997, "345");
        Person obj3 = new Person("amruth");
        obj1.printDetails();
        obj2.printDetails();
        obj3.printPerson();
        if (obj3.name.equals(obj2.name) || obj3.name.equals(obj1.name))
            System.out.println("Person and employee object are equal");
        else
            System.out.println("The person and employee objects are not equal");
        if (obj1.equals(obj2))
            System.out.println("Obj1 and obj2 are equal");
        else
            System.out.println("Both the objects are not equal");
    }
}
