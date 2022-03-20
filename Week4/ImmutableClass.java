package Week4;

// //And I am Immutable
// Immutable class in java means that once an object is created, we cannot change its content.

// WAP to create and implement an immutable class.

final class Immutable {

  private final String name;
  private final String location;

  public Immutable() {
    this.name = "Amruth";
    this.location = "Hyderabad";
  }

  public Immutable(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return "Immutable [location=" + location + ", name=" + name + "]";
  }

}

public class ImmutableClass {
  public static void main(String[] args) {

    Immutable obj1 = new Immutable();
    System.out.println(obj1);

    Immutable obj2 = new Immutable("Aasrith", "Banglore");
    System.out.println(obj2);

  }
}
