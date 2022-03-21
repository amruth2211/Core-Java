package week2;

import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int count = 0;
        while (!scr.next().equals("q")) {
            count++;
        }
        System.out.println(count);
    }
}
