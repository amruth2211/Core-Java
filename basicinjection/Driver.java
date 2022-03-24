package basicinjection;

class Foo {
    private String name;

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Bar {
    private String name;
    private int age;
    private Foo foo;

    public Bar() {

    }

    public Bar(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setFod(Foo foo) {
        this.foo = foo;
    }

    public void processFooName() {
        System.out.println("Name in Injection Foo is: " + foo.getName());
    }

    @Override
    public String toString() {
        return "Bar [age=" + age + ", foo=" + foo + ", name=" + name + "]";
    }

}

public class Driver {
    public static void main(String[] args) {
        Foo f = new Foo("qwe");
        Bar b = new Bar("abc", 21);
        System.out.println(b);
        b.setFod(f);
        b.processFooName();
        System.out.println(b);
    }
}
