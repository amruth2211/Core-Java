package Tasks;

import java.util.Scanner;

class Happy {
    int n;

    public Happy(int n) {
        this.n = n;
        System.out.println("The first happy numbers from " + this.n + " number is : ");
    }

    void check(int a) {
        int rem = 0;
        int sum = 0;

        while (a != 0) {
            rem = a % 10;
            sum += Math.pow(rem, 2);
            a /= 10;
        }
        System.out.println(sum);

        if (sum == 1) {
            System.out.println(this.n + " is a happy number");
        } else if (sum == this.n) {
            System.out.println(this.n + " is a unhappy number");
        } else
            check(sum);
    }
}

public class HappyNum {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scr.nextInt();
        Happy h = new Happy(n);
        h.check(n);
        scr.close();
    }
}
