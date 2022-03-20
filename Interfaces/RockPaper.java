package Interfaces;

import java.util.Scanner;

class Game {
    String comChoice;
    String userInput;

    void computerChoice() {
        int a = (int) (Math.random() * 3);

        if (a == 1)
            comChoice = "rock";
        else if (a == 2)
            comChoice = "paper";
        else
            comChoice = "scissors";
    }

    int resultfunction() {
        if (userInput.equals(comChoice)) {
            System.out.println("It's a tie! You have to play again!");
            return 1;
        } else if (userInput.equals("rock") && comChoice.equals("scissors")
                || (userInput.equals("scissors") && comChoice.equals("paper"))
                || (userInput.equals("paper") && comChoice.equals("rock"))) {
            System.out.println("You win!");
        } else
            System.out.println("You lose!");

        return 0;
    }

}

class RockPaper {
    public static void main(String[] args) {
        Game obj = new Game();
        Scanner scr = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your Choice: \n1. rock \n2. paper \n3. scissors");
            obj.userInput = scr.next().toLowerCase();

            obj.computerChoice();
            System.out.println("Computer chose: " + obj.comChoice);

            int result = obj.resultfunction();
            if (result == 1)
                continue;
            System.out.println("Do you want to continue playing? YES or NO");
            if (scr.next().equalsIgnoreCase("NO"))
                break;
        }
        scr.close();
    }
}
