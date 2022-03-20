public class Fibanocci {

    public static int fib(int n) {

        if (n == 0 || n == 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        int n = 10;

        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;

        }
        System.out.println("using for loop : " + sum);
        System.out.println("using the recursive function");
        System.out.print(fib(n - 1) + " ");

    }
}
