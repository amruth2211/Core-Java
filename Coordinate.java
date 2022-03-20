import java.util.Scanner;

public class Coordinate {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the Coordinates");
        int x = scr.nextInt();
        int y = scr.nextInt();
        if (x > 0 && y > 0)
            System.out.println(x + "," + y + " is in first Quadrant");
        else if (x < 0 && y > 0)
            System.out.println(x + "," + y + " is in Second Quadrant");
        else if (x < 0 && y < 0)
            System.out.println(x + "," + y + " is in third Quadrant");
        else
            System.out.println(x + "," + y + " is in Fourth Quadrant");

    }
}
