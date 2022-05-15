package com.avinder.models;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    private List<Player> playerList;
    private Player currentMovingPlayer;
    private int currentMovingPlayerIndex;
    private Player winningPlayer;

    private Scanner scan = new Scanner(System.in);
    public void initializeGame(){
        // boardInitialize, playerConfig , snakeConfig , ladderConfig
        System.out.println("Welcome to Snake And Ladder Game");

        this.board = Board.initializeBoard(scan);

        this.playerList = PlayerList.initializePlayers(scan);
        this.currentMovingPlayerIndex = 0;
        this.currentMovingPlayer = this.playerList.get(currentMovingPlayerIndex);

    }

    public Player startGame() throws InterruptedException {

        while(winningPlayer == null){

            if(winningPlayer!=null){
                System.out.println("Already player has won.. which can't be!!");
                return currentMovingPlayer;
            }
            System.out.println();
            System.out.println(currentMovingPlayer.getName() + " is rolling");

            // Current Player will make a move
            this.currentMovingPlayer.makeMove();
            PlayerList.showPlayersLocation();
            // check if player won
            if (currentMovingPlayer.checkPlayerWon(board) == true) {
                System.out.println();
                System.out.println("Found Winning Player:->  "+currentMovingPlayer.getName());
                return currentMovingPlayer;
            }
            currentMovingPlayerIndex = (currentMovingPlayerIndex+1)%playerList.size();
            currentMovingPlayer = playerList.get(currentMovingPlayerIndex);
        }
        return winningPlayer;
    }
}
