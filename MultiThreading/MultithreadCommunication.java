package MultiThreading;

class Number {
    static int limit = 100;
    int i = 1;

    synchronized void displayOddNumbers() {
        while (i < limit) {
            while (i % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println((i++));
            notifyAll();
        }
    }

    synchronized void displayEvenNumbers() {
        while (i < limit) {
            while (i % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println((i++));
        }

    }
}

public class MultithreadCommunication {

    public static void main(String[] args) {
        final Number n = new Number();

        Thread t1 = new Thread() {
            public void run() {
                n.displayOddNumbers();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                n.displayEvenNumbers();
            }
        };

        long startTime = System.nanoTime();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
