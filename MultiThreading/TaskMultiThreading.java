package MultiThreading;

import java.util.Scanner;

public class TaskMultiThreading {

    static int limit = 10;

    synchronized void printEven() {
        try {
            wait();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Even values ");

        for (int i = 2; i < limit; i += 2) {
            System.out.println(i);
        }
    }

    synchronized void printOdd() {
        System.out.println("odd values ");
        for (int i = 1; i < limit; i += 2) {
            System.out.println(i);
        }
        notifyAll();
    }

    public static void main(String[] args) {

        TaskMultiThreading t = new TaskMultiThreading();
        new Thread() {
            public void run() {
                t.printEven();
            }
        }.start();
        new Thread() {
            public void run() {
                t.printOdd();
            }
        }.start();

    }
}
