package week1;

import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the physics,chemistry,math marks ");
        int phy = scr.nextInt();
        int chem = scr.nextInt();
        int math = scr.nextInt();
        int tot = phy + math + chem;
        if (tot >= 200)
            System.out.println("The grade is A");
        else if (tot >= 180)
            System.out.println("The grade is B");
        else if (tot >= 150)
            System.out.println("The grade is C");
        else if (tot >= 120)
            System.out.println("The grade is D");
        else
            System.out.println("Fail");
    }
}
