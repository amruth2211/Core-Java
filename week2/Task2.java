package week2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the value ");
        int m = scr.nextInt();
        int n;
        if (m > 0) {
            n = 1;
            System.out.println("n = " + n);
        } else if (m == 0) {
            n = 0;
            System.out.println("n = " + n);
        } else {
            n = -1;
            System.out.println("n = " + n);
        }
    }
}
