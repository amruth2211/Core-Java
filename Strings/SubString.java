package Strings;

import java.util.*;

public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string ");
        String mainStr = sc.nextLine();
        String y = "";
        int x = 1;
        boolean flag = true;
        System.out.println("Enter the elements ");
        while (flag) {
            y = sc.next().toLowerCase();
            if (y.matches("\\d")) {
                flag = false;
            }

            else if (mainStr.indexOf(y) == -1) {
                x = 1;
            } else {
                x = 0;
            }
        }
        if (x == 1)
            System.out.println("Given inputs are substrings");
        else {
            System.out.println("Given inputs are not substrings");
        }
        sc.close();

    }
}
