package com.avinder.models;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board;

    private List<Player> playerList;

    public Player getCurrentMovingPlayer() {
        return currentMovingPlayer;
    }

    public void setCurrentMovingPlayer(Player currentMovingPlayer) {
        this.currentMovingPlayer = currentMovingPlayer;
    }

    public int getCurrentMovingPlayerIndex() {
        return currentMovingPlayerIndex;
    }

    public void setCurrentMovingPlayerIndex(int currentMovingPlayerIndex) {
        this.currentMovingPlayerIndex = currentMovingPlayerIndex;
    }

    private Player currentMovingPlayer;
    private int currentMovingPlayerIndex;
    public static final int SIX_COUNT_LIMIT = 3;
    public static final int DICE_LIMIT = 6;

    private Scanner scan = new Scanner(System.in);
    public void initializeGame() throws Exception {
        System.out.println("Welcome to Snake And Ladder Game");

        this.board = Board.initializeBoard(scan);
        this.playerList = PlayerList.initializePlayers(scan);
        this.currentMovingPlayerIndex = new Random().nextInt(playerList.size());
        this.currentMovingPlayer = this.playerList.get(currentMovingPlayerIndex);

    }

    public Player startGame() throws Exception {
        if(currentMovingPlayer == null){
            throw new Exception("No current Moving Player Initialized");
        }
        if (currentMovingPlayer.checkPlayerWon(board) == true)
            return currentMovingPlayer;
        while(true){
            System.out.println(String.format("\n%s is rolling",currentMovingPlayer.getName()));
            currentMovingPlayer.makeMove(board,currentMovingPlayer.getCurrPos(),0); // Current Player will make a move
//            PlayerList.showPlayersLocation();
            System.out.println(this);
            if (currentMovingPlayer.checkPlayerWon(board) == true)  // check if player won
                return currentMovingPlayer;
            nextTurn();
        }
    }
    public void nextTurn(){
        currentMovingPlayerIndex = (currentMovingPlayerIndex+1)%playerList.size();
        currentMovingPlayer = playerList.get(currentMovingPlayerIndex);
    }

    public Board getBoard() {return board;}

    public List<Player> getPlayerList() {return playerList;}

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayerList(List<Player> playerList) throws Exception {
        if(playerList==null || playerList.size()<=0){
            throw new Exception("Not able to set list of players for the game");
        }
        this.playerList = playerList;
    }

    public Game (){ // Whenever Game object is created , then all those dependencies should be set , wherever static game Object is being referenced
        PlayerList.game = this;
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", playerList=" + playerList +
                ", currentMovingPlayer=" + currentMovingPlayer +
                ", currentMovingPlayerIndex=" + currentMovingPlayerIndex +
                '}';
    }
}
