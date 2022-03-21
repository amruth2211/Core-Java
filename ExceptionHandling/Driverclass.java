package ExceptionHandling;

import java.util.Scanner;

public class Driverclass {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the three numbers");
        int n1 = scr.nextInt();
        int n2 = scr.nextInt();
        int n3 = scr.nextInt();
        int n4 = 0;
        try {
            n4 = (n1 / n2) / n3;
        } catch (ArithmeticException e) {
            System.out.println("ArthimeticException occurs");
        }
        int[] a = new int[n4];
        // System.out.println("Enter the elements of the array of size : " + n4);

        for (int i = 0; i < n4; i++) {
            a[i] = scr.nextInt();
        }

        try {
            System.out.println("The fifth element is :" + a[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array out of bounds Exception ");
        }

        scr.close();
    }
}
