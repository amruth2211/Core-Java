package StreamsAPI;

import java.util.Scanner;

public class CodeSolutions {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scr.nextInt();
        }
        int m = scr.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scr.nextInt();
        }
        int i = 0, j = 0, k = 0;
        if (a[0] < b[0]) {
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    k++;
                    i++;
                } else {
                    k++;
                    j++;
                }
            }

        } else {
            while (i < a.length && j < b.length) {
                if (b[j] < a[i]) {
                    k++;
                    j++;

                } else {
                    k++;
                    i++;
                }
            }

        }
        System.out.println(k);
        scr.close();
    }
}
