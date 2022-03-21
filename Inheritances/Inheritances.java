package Inheritances;

class Parent {
    String firstname;
    String lastname;

    Parent() {
        this.lastname = "Chowdary";
    }

    Parent(String firstname) {
        this(); // calls the non parameterised constructer
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("Firstname: %s %nLastname: %s", this.firstname, this.lastname);
    }
}

class Child extends Parent {
    Child() {
        super(); // calls the non parameterisedconstructer of parent class
    }

    Child(String firstname) {
        // super(firstname); //calls the parameterisedconstructer of parent class
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        System.out.println("CHILD OBJECT::");
        return String.format("Firstname: %s %nLastname: %s", this.firstname, this.lastname);
    }
}

public class Inheritances {
    public static void main(String[] args) {
        Parent p = new Parent("Siva");
        Child c = new Child("Amruth");

        System.out.println(p.toString());
        System.out.println(c.toString());
    }
}
