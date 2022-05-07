package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int l = scr.nextInt();
        int p = -1;
        int q = -1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scr.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] == l) {
                p = i;
                a[i] = -1;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == l) {
                q = i;
                a[i] = -1;
            }
        }
        if (p != q && q != -1)
            System.out.println(p + " " + q);
        else
            System.out.println(p + " " + p);
    }
}
