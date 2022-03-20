
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the sides of a traingle");
        int a = scr.nextInt();
        int b = scr.nextInt();
        int c = scr.nextInt();
        if (a == b && b == c)
            System.out.println("Equilateral triangle");
        else if (a == b || b == c || c == a)
            System.out.println("Isosceles triangle");
        else
            System.out.println("Scalene triangle");
        scr.close();

    }
}
