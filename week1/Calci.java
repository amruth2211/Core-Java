package week1;

import java.util.Scanner;

public class Calci {
    public static void main(String[] args) {
        System.out.println("Enter a,b values");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter operation");
        char c = sc.next().charAt(0);
        switch (c) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '%':
                System.out.println(a % b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
