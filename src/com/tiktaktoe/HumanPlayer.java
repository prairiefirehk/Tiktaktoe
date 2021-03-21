package com.tiktaktoe;
import java.util.Scanner;

public class HumanPlayer extends Player {

    String name = "You";
    boolean isPressed = false;
    String symbol = "x";
    int[] choice = new int[9];
    int move = 0;

    public void pressEnterKeyToContinue() {

        System.out.println("Press Enter key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        this.isPressed = true;
    }

    public void confirmContinue(){

        while (!this.isPressed) {
            this.pressEnterKeyToContinue();
        }
    }

    public void resetConfirmContinueStatus(){
        this.isPressed = false;
    }

    public int selectDifficulty(){
        int difficulty = -1;
        boolean valid = true;

        do {
            valid = true;
            Scanner scan = new Scanner(System.in);
            String difficulty = scan.hasNextInt();
            System.out.println("Select game difficulty: " + "\n" +
                               "Dumb: 1, Easy: 2, Hard: 3");


            if (scan.hasNextInt()) {
                difficulty = scan.nextInt() - 1;

                if (difficulty <= -1 || difficulty > 2 ){
                    System.out.println("Hey, 1-3 only! No secret difficulty for this shitty game.");
                    valid = false;

                }

            } else if(){


            } else {
                System.out.println("What did you type? Numbers and 1-3 only!");
                valid = false;

            }

        } while (!valid);

        return difficulty;
    }

    public int giveChoice(Board board){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice(1-9): ");

        int choice = scan.nextInt();
        this.choice[this.move] = choice;
        board.occupiedGrid.add(choice);
        return choice;
    }

}
