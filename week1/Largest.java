package week1;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the  numbers");
        int a = scr.nextInt();
        int b = scr.nextInt();
        int c = scr.nextInt();
        if (a > b && a > c)
            System.out.println(a + " is the largest number");
        else if (b > a && b > c)
            System.out.println(b + " is the largest number");
        else
            System.out.println(c + " is the largest number");
        if (a < b && a < c)
            System.out.println(a + " is the Smallest");
        else if (b < a && b < c)
            System.out.println(b + " is the Smallest");
        else
            System.out.println(c + " is the Smallest");
    }
}
