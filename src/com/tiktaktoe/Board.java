package com.tiktaktoe;
import java.util.*;

public class Board {

    //[row length][column length]
    String[][] grid = new String[3][3];

    ArrayList<Integer> unoccupiedGrid = new ArrayList<>();
    ArrayList<Integer> occupiedGrid = new ArrayList<>();

    public Board(){
        //System.out.println(this.grid[this.grid.length-1].length * this.grid.length);
    }

    public void resetUnoccupiedGrid(Board board){

        board.unoccupiedGrid.removeAll(unoccupiedGrid);

        //row length * column length
        for (int i = 1; i < board.grid[board.grid.length-1].length * board.grid.length + 1; i++){
            board.unoccupiedGrid.add(i);

        }

    }
}
