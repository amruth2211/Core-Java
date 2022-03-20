package Week4;

import java.util.Arrays;
import java.util.Scanner;

class SortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = str1 + str2;

        char[] temp = str3.toCharArray();
        Arrays.sort(temp);

        String sorted = new String(temp);
        System.out.println(sorted);

        sc.close();
    }
}
