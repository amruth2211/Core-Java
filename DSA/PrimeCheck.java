package DSA;

import java.util.Scanner;

//To check if the number is prime or not in different ways of time complexities
public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number to check if it is prime or not");
        int n = scr.nextInt();
        System.out.println(isPrime(n));
        scr.close();
    }

    // This has the time complexities of Big O(sqrt(n))
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2 || n==3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5; i*i<=n; i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }

    //This has the time complexities of Big O(n)
    public static boolean isPrimeNumber(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    // This has the time complexities of Big O(n/2)
    public static boolean isPrimeOrNot(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<=n/2; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    // This has the time complexities of Big O(sqrt(n))
    public static boolean isPrimeOrNot2(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
