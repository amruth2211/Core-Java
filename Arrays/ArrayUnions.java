package Arrays;

import java.util.Scanner;

public class ArrayUnions {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the sizes of two arrays");
        int n1 = scr.nextInt();
        int n2 = scr.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        System.out.println("Enter first array elements");
        for (int i = 0; i < n1; i++) {
            a[i] = scr.nextInt();
        }
        System.out.println("Enter second array elements");
        for (int i = 0; i < n2; i++) {
            b[i] = scr.nextInt();
        }
        System.out.println("output :");
        System.out.println(union(a, b, n1, n2));

    }

    public static int union(int[] a, int[] b, int n1, int n2) {
        int count = 0;
        for (int i = 0; i < n1; i++) {
            count++;
            for (int j = 0; j < n2; j++) {
                if (a[i] == b[j] && b[j] != 0) {
                    b[j] = 0;
                }
            }
        }

        for (int i = 0; i < n2; i++) {
            if (b[i] != 0)
                count++;
        }

        return count;
    }
}
