package week1;

public class Amstrong {
    public static void main(String[] args) {
        int n = 123, rem = 0, res = 0;
        while (n != 0) {
            rem = n % 10;
            res += Math.pow(rem, 3);
            n /= 10;
        }
        if (res == n)
            System.out.println("Amstrong number");
        else
            System.out.println("Not an amstrong number");
    }
}
