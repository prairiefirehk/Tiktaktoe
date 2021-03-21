package com.tiktaktoe;

public class ComputerEnemy extends Player{

    String name = "Computer";
    int difficulty;
    String symbol = "o";
    int[] choice = new int[9];
    int move = 0;

    public enum difficulties {
        Dumb,
        Easy,
        Normal
    }

    public ComputerEnemy(int difficulty){
        this.difficulty = difficulty;
        switch (difficulty){

            case 0:
                System.out.println("Dumb enemy selected. You suck.");
                break;

            case 1:
                System.out.println("Easy enemy selected.");
                break;

            case 2:
                System.out.println("There is no Hard enemy in this shitty game. Normal enemy selected.");
                break;
        }
    }

    public int giveChoice(Board board){
        boolean valid = false;
        int pcChoice = -1;

        System.out.println(board.unoccupiedGrid);
        while(!valid){

            pcChoice = (int)(Math.random() * 10) ;
            if (!board.occupiedGrid.contains(pcChoice)) {
                valid = true;

            }
        }
        board.unoccupiedGrid.remove(pcChoice);
        this.choice[this.move] = pcChoice;
        board.occupiedGrid.add(pcChoice);
        return pcChoice;
    }

}
