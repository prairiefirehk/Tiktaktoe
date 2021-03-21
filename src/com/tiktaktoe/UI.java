package com.tiktaktoe;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class UI {

    boolean winnerCreated = false;
    public void resetGrid(Board board){

        for (int row = 0; row < board.grid.length; row++){

            for (int column = 0; column < board.grid.length; column++){
                board.grid[row][column] = " ";

            }
        }
    }

    public void sayHello(){
        System.out.println("Welcome to Tiktaktoe!");
    }

    public boolean decideFirstPlayer(){

        boolean humanFirst = false;
        int rand = (int)(Math.random() * 10) + 1;
        System.out.println(rand);
        if (rand < 6){
            humanFirst = true;
            System.out.println("You will select choices first.");

        } else {
            System.out.println("Computer will select choices first.");

        }
        return humanFirst;
    }

    public void sayRandomDraw(){
        System.out.println("Now first-player will be randomly selected: ");
    }

    public void printGrid(Board board){

        System.out.printf("+---+---+---+" + "\n" +
                           "| %s | %s | %s |" + "\n" +
                           "+---+---+---+" + "\n" +
                           "| %s | %s | %s |" + "\n" +
                           "+---+---+---+" + "\n" +
                           "| %s | %s | %s |" + "\n" +
                           "+---+---+---+", board.grid[0][0], board.grid[0][1], board.grid[0][2], board.grid[1][0], board.grid[1][1], board.grid[1][2], board.grid[2][0], board.grid[2][1], board.grid[2][2]);
    }

    public void processChoice(int choice, String symbol, Board board){

        choice = choice - 1;
        int xcoord = choice / board.grid[0].length;
        int ycoord = choice % board.grid[0].length;
        if (ycoord < 0){
            ycoord = 0;

        }

        board.grid[xcoord][ycoord] = symbol;
    }

    public boolean checkWinforPc(Board board){

        for(int row = 0; row < board.grid[0].length; row++) {
            int column = 0;

            //row 3 strikes
            if (board.grid[row][column] == "o" && board.grid[row][column+1] == "o" && board.grid[row][column+2] == "o"){
                this.winnerCreated = true;

            } else {
                this.winnerCreated = false;

            }
        }
        return winnerCreated;

    }

    public boolean checkWinforHuman(Board board){

        for(int row = 0; row < board.grid[0].length; row++) {
            int column = 0;

                //row 3 strikes
                if (board.grid[row][column] == "x" && board.grid[row][column+1] == "x" && board.grid[row][column+2] == "x"){
                    this.winnerCreated = true;

                } else {
                    this.winnerCreated = false;

                }
        }
        return winnerCreated;

    }

    public void announceWinner(Player a, Player b){

        if (a.isWinner){
            System.out.println( a.name + " wins!");

        } else if (b.isWinner){
            System.out.println( b.name + " wins!");

        }

    }

}
