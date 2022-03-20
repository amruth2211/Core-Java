import java.util.Scanner;

//displays prime and amstrong
public class Primes {
    public static void amstrong(int n) {
        int n1 = n, rem = 0, res = 0;
        while (n != 0) {
            rem = n % 10;
            res += Math.pow(rem, 3);
            n /= 10;
        }
        if (res == n1)
            System.out.println(n + " is Amstrong");
        else
            System.out.println(n + " is not Amstrong");

    }

    public static void prime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0)
                amstrong(i);
            else
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        for (int i = 1; i <= n; i++) {
            prime(i);
        }
    }
}
