package com.avinder.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private List<Path> movesList;
    private String name;
    private int currPos;

    @Override
    public String toString() {
        return  name + " {" + currPos + "}\t";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrPos() {
        return currPos;
    }
    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
    public List<Path> getMovesList() {return movesList;}
    public void setMovesList(List<Path> movesList) {this.movesList = movesList;}

    Player(String name, int startingPos,List<Path> movesList){
        this.name = name;
        this.currPos = startingPos;
        this.movesList = movesList;
    }

    public static Player initializePlayer(Scanner scan ){
        System.out.println("Enter Player Name");
        String playerName = scan.next();
        return new Player(playerName,0,new ArrayList<>());
    }

    public boolean checkBitBySnake(Board board,int currPos){
        Snake possibleSnake = board.snakeMap.get(currPos);
        if(possibleSnake == null )
            return false;
        this.currPos =  possibleSnake.getPath().to;
        System.out.println(String.format("%s got bitten by Snake %s",getName(),possibleSnake));
        return true;
    }

    public void makeMove(Board board, int initialPos) throws InterruptedException {
        if(currPos == board.getSize())
            return;

        int rollOut = 1+ new Random().nextInt(6);
        System.out.println("Rolled number by " + this.getName() + " is " + rollOut);

        Thread.sleep(1000);
        int prevPos = this.getCurrPos();
        this.currPos += rollOut;

        if(checkBitBySnake(board,currPos) == true)
            return;
        if(currPos > board.getSize()) {
            currPos = initialPos;
            return;
        }
        this.movesList.add(new Path(prevPos,currPos));
        if(rollOut == 6)
            makeMove(board,initialPos);
    }

    public boolean checkPlayerWon(Board board){
        return this.currPos == board.getSize();
    }

}

 class PlayerList {
    static List<Player> players;
    protected static List<Player> initializePlayers(Scanner scan){
        System.out.println("Enter No of Players");
        int playersCount = scan.nextInt();
        players= new ArrayList<>(playersCount);
        for(int i=0;i<playersCount;i++)
            players.add(Player.initializePlayer(scan));

        System.out.println("Players Added to Game");
        return players;
    }

    public static void showPlayersLocation(){
        players.forEach(System.out::print);
        System.out.println();
        System.out.println();
    }
}
