package Serialization;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String s = scr.nextLine();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ')
                count++;
        }
        if (count == 0)
            System.out.println("No spaces");
        else
            System.out.println(count);
    }
}
