package week1;

import java.util.Scanner;
import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        boolean flag = true;
        if (s1.length() != s2.length()) {
            flag = false;
        } else {
            char[] c1 = s1.toLowerCase().toCharArray();
            char[] c2 = s2.toLowerCase().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            flag = Arrays.equals(c1, c2);
        }
        return flag;

    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the first String");
        String s1 = scr.nextLine();
        System.out.println("Enter the second String");
        String s2 = scr.nextLine();

        if (isAnagram(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
        scr.close();

    }
}
