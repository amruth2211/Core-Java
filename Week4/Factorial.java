package Week4;

import java.util.Scanner;

class getFactorial {

    int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not possible!");
        }
        if (n > 16) {
            throw new IllegalArgumentException("arguments > 16");
        }
        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getFactorial fact = new getFactorial();
        int n = scanner.nextInt();
        try {
            System.out.println(fact.factorial(n));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument");
        }
    }

}
