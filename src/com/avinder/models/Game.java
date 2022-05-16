package com.avinder.models;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> playerList;
    private Player currentMovingPlayer;
    private int currentMovingPlayerIndex;
    public static final int SIX_COUNT_LIMIT = 3;
    public static final int DICE_LIMIT = 6;

    private Scanner scan = new Scanner(System.in);
    public void initializeGame(){
        System.out.println("Welcome to Snake And Ladder Game");

        this.board = Board.initializeBoard(scan);
        this.playerList = PlayerList.initializePlayers(scan);
        this.currentMovingPlayerIndex = new Random().nextInt(playerList.size());
        this.currentMovingPlayer = this.playerList.get(currentMovingPlayerIndex);

    }

    public Player startGame() throws InterruptedException {
        if (currentMovingPlayer.checkPlayerWon(board) == true)
            return currentMovingPlayer;
        while(true){
            System.out.println(String.format("\n%s is rolling",currentMovingPlayer.getName()));
            currentMovingPlayer.makeMove(board,currentMovingPlayer.getCurrPos(),0); // Current Player will make a move
            PlayerList.showPlayersLocation();
            if (currentMovingPlayer.checkPlayerWon(board) == true)  // check if player won
                return currentMovingPlayer;
            nextTurn();
        }
    }
    public void nextTurn(){
        currentMovingPlayerIndex = (currentMovingPlayerIndex+1)%playerList.size();
        currentMovingPlayer = playerList.get(currentMovingPlayerIndex);
    }
}
