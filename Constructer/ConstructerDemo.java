package Constructer;

class Addition {
    int a;
    int b;
    int c = 5;
    static int d = 6;

    public Addition(int m, int n) {
        this.a = m; // this points the varible of the class to the variable
        this.b = n;
        System.out.println(a + b);
    }

    public Addition(float a, float b, float c) // constructer overloading
    {
        this(a, b); // this function points to that constucter
        System.out.println(a + b);
    }

    public Addition() {
    }

    public Addition(float a2, float b2) {
        System.out.println(a2 + b2);
    }

    public void method() {
        System.out.println("calling the method using the object ");
    }

}

public class ConstructerDemo {
    public static void main(String[] args) {
        Addition obj1 = new Addition();
        Addition obj2 = new Addition(2, 3);
        obj1.method();
        obj2.method(); // calling method using the objects

        System.out.println(obj1.c); // 5
        System.out.println(obj1.d); // 6
        obj2.c = 9; // here when we change the value of the instance variable using one object then
                    // the value of the other obj wont change
        obj2.d = 10; // but when varible declared static the value stored in the stack so if change
                     // then for all other objs changes
        System.out.println(obj1.c); // 5
        System.out.println(obj1.d); // 10
    }
}
