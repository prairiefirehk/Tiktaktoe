package com.tiktaktoe;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //start
        UI ui = new UI();
        Board board = new Board();
        HumanPlayer you = new HumanPlayer();

        ui.sayHello();

        Scanner scan = new Scanner(System.in);
        you.confirmContinue();

        //select difficulty

        int gameDifficulty = you.selectDifficulty();
        ComputerEnemy pc = new ComputerEnemy(gameDifficulty);

        //decide first move player
        ui.sayRandomDraw();

        you.isFirstPlayer = ui.decideFirstPlayer();
        pc.isFirstPlayer = !you.isFirstPlayer;
        you.resetConfirmContinueStatus();
        you.confirmContinue();

        //game loop

        board.resetUnoccupiedGrid(board);
        ui.resetGrid(board);

        //while loop start here
        while (!ui.winnerCreated){


            //first move player select
            if(you.isFirstPlayer){
                ui.processChoice(you.giveChoice(board), you.symbol, board);

            } else if (pc.isFirstPlayer){
                ui.processChoice(pc.giveChoice(board), pc.symbol, board);

            }
            //check win
            System.out.println("\n");
            ui.printGrid(board);
            you.isWinner = ui.checkWinforPc(board);
            pc.isWinner = ui.checkWinforHuman(board);

            //second move player select
            if(!you.isFirstPlayer){
                ui.processChoice(you.giveChoice(board), you.symbol, board);


            } else if (!pc.isFirstPlayer){
                ui.processChoice(pc.giveChoice(board), pc.symbol, board);

            }

            //check win
            System.out.println("\n");
            ui.printGrid(board);
            you.isWinner = ui.checkWinforPc(board);
            pc.isWinner = ui.checkWinforHuman(board);

        }

        //announce winner
        ui.announceWinner(you, pc);
        //end

        //quit

    }
}

