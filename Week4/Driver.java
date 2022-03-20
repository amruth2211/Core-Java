package Week4;

import java.util.Scanner;

class Task {
    void arrayelement(int[] array) {
        int n = array.length;
        if (n >= 5) {
            System.out.println(array[4]);
        } else
            System.out.println("No fifth element in the array");
    }

    void divide(int n1, int n2) {
        double r = n1 / n2;
        System.out.println("The division of n1 and n2 is " + r);
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scr.nextInt();
        int[] a = new int[n];
        Task t = new Task();
        System.out.println("Enter the elements of array");

        for (int i = 0; i < n; i++) {
            a[i] = scr.nextInt();
        }
        t.arrayelement(a);
        System.out.println("Enter the two numbers");
        int n1 = scr.nextInt();
        int n2 = scr.nextInt();
        t.divide(n1, n2);

        scr.close();
    }
}