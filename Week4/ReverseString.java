package Week4;

import java.util.Scanner;

// Reverese a string and we need to place the spaces at the positions where the space are present in tht initial string

public class ReverseString {

    public static void reverse(String s) {
        String p = "";
        int n = s.length() - 1;
        for (int i = n; i >= 0; i--) {
            p += s.charAt(i);
        }
        String res = p.replace(" ", "");

        char[] resArr = res.toCharArray();
        String output = "";

        int len = s.length();
        int i = 0, j = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                output += " ";
            } else {
                output += resArr[j++];
            }
            i++;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the string ");
        String s = scr.nextLine();
        reverse(s);
        scr.close();
    }
}
