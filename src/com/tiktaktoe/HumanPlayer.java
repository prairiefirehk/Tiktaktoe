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
        boolean valid = false;

        while (!valid) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select game difficulty: " + "\n" +
                               "Dumb: 1, Easy: 2, Hard: 3");

            //first turn input into string, since here is for checking if the input is integer or not.
            String inputInString = scan.nextLine();
            boolean isInt = false;

            if (inputInString.isEmpty() || inputInString.isBlank()) {
                System.out.println("Hey, type something.");
                isInt = false;

            } else if (inputInString.chars().allMatch(Character::isAlphabetic)) {
                System.out.println("What did you type? Numbers and 1-3 only!");
                isInt = false;

            } else {
                System.out.println("Seriously wtf did you just type?");
                isInt = false;
            }

            //now it can be sure that the input is an integer
            if (isInt) {

                int input = Integer.parseInt(inputInString);

                if (input < 1 || input > 3){
                    System.out.println("Hey, 1-3 only! No secret difficulty for this shitty game.");
                    valid = false;

                } else {
                    //start from 0, so have to -1
                    difficulty = input - 1;
                    valid = true;
                }

            }

        }
        valid = false;
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
