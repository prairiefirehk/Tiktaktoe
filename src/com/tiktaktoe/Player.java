package com.tiktaktoe;

public abstract class Player {

    String name;
    boolean isFirstPlayer = false;
    String symbol;
    int[] choice;
    int move;
    boolean isWinner = false;

    public abstract int giveChoice(Board board);


}
