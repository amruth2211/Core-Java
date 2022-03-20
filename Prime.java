import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                count++;
        }
        if (count == 0)
            System.out.println("Prime");
        else
            System.out.println("Not prime");

    }
}
