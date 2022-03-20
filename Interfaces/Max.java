package Interfaces;

import java.util.Scanner;

class Max {
    public static int print(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c)
            return b;
        else
            return c;
    }

    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        int a = scr.nextInt();
        int b = scr.nextInt();
        int c = scr.nextInt();
        scr.close();
        System.out.println(print(a, b, c) + " is the maximum number");
    }
}