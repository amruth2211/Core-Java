package MultiThreading;

class FirstThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(" 5 " + " * " + i + " = " + 5 * i);
        }

    }

}

class SecomdThread implements Runnable {

    public void run() {
        String[] s = new String[] { "India", "Russia", "Japan", "America" };
        for (String e : s) {
            System.out.println(e);
        }

    }

}

public class MultiThreading {
    public static void main(String[] args) {
        FirstThread t1 = new FirstThread();
        t1.start();
        SecomdThread t = new SecomdThread();
        Thread t2 = new Thread(t);
        t2.start();
        System.out.println("Name : Amruth");

    }
}
