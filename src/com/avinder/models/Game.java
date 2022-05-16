package com.avinder.models;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> playerList;
    private Player currentMovingPlayer;
    private int currentMovingPlayerIndex;

    private Scanner scan = new Scanner(System.in);
    public void initializeGame(){
        // boardInitialize, playerConfig , snakeConfig , ladderConfig
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

            // Current Player will make a move
            currentMovingPlayer.makeMove(board,currentMovingPlayer.getCurrPos());
            PlayerList.showPlayersLocation();
            // check if player won
            if (currentMovingPlayer.checkPlayerWon(board) == true)
                return currentMovingPlayer;
            nextTurn();
        }
    }
    public void nextTurn(){
        currentMovingPlayerIndex = (currentMovingPlayerIndex+1)%playerList.size();
        currentMovingPlayer = playerList.get(currentMovingPlayerIndex);
    }
}
