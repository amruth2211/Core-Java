package week2;

import java.util.Scanner;

public class Last {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scr.nextInt();
        while (n != 0) {
            System.out.println(n % 10);
            n = n / 10;
        }
    }
}
