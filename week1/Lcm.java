package week1;

import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the numbers");
        int a = scr.nextInt();
        int b = scr.nextInt();
        int gcd = 1, lcm;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        lcm = (a * b) / gcd;
        System.out.println("Lcm of the numbers " + a + "," + b + " is equal to " + lcm);
    }
}
