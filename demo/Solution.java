package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        ArrayList<Integer> b = new ArrayList<>();
        int n = scr.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scr.nextInt();
            b.add(a[i]);
        }
        while (b.size() > 1) {
            int sum = 0;
            for (int i = 0; i < b.size(); i++) {
                sum += b.get(i);
            }
            int p = sum / 2;
            for (int i = b.size() - 1; i >= 0; i--) {
                if (b.get(i) < p) {
                    b.remove(i);
                    break;
                }
            }
        }

        System.out.println(b.get(0));
    }
}
