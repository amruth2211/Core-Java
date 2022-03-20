import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("enter the string");
        String s = scr.nextLine();
        int ucount = 0, lcount = 0, dcount = 0;
        int strlen = s.length();
        for (int i = 0; i < strlen; i++) {
            int ch = (int) s.charAt(i);
            if (ch >= 65 && ch <= 90)
                ucount++;
            else if (ch >= 97 && ch <= 122)
                lcount++;
            else
                dcount++;
        }
        System.out.println("Upper case: " + ucount);
        System.out.println("Lower case: " + lcount);
        System.out.println("Digits: " + dcount);
    }
}
