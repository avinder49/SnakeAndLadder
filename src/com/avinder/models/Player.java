package com.avinder.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.avinder.models.Game.*;

public class Player {
    private List<Path> movesList;
    private String name;
    private int currPos;

    Player(String name, int startingPos,List<Path> movesList){
        this.name = name;
        this.currPos = startingPos;
        this.movesList = movesList;
    }

    public static Player initializePlayer(String playerName ){
        return new Player(playerName,0,new ArrayList<>());
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

    public boolean checkObject(Board board,int currentPos, int rollOut){
        if(board.objectMap == null ){
            return false;
        }
        BoardObject object = board.objectMap.get(currentPos);
        if(object == null)
            return false;
        if(object.getType().contains("Snake")) {
            this.currPos = object.getPath().getTo();
            System.out.println(String.format("%s got bitten by %s", getName(), object));
            this.movesList.add(new Path(currentPos - rollOut, currPos));
            return true;
        }
        if(object.getType().contains("Ladder")) {
            this.currPos = object.getPath().getTo();
            System.out.println(String.format("%s climbed %s", getName(), object));
            this.movesList.add(new Path(currentPos - rollOut, currPos));
            return true;
        }
        return false;
    }

    public void makeMove(Board board, int initialPos, int sixCount) throws InterruptedException {
        if(currPos == board.getSize())
            return;
        if(sixCount == SIX_COUNT_LIMIT) {
            currPos = initialPos;
            return;
        }

        int rollOut = 1+ new Random().nextInt(DICE_LIMIT);
        System.out.println("Rolled number by " + this.getName() + " is " + rollOut);
//        Thread.sleep(1000);
        int prevPos = this.getCurrPos();
        this.currPos += rollOut;

        if(checkObject(board,currPos,rollOut) == true)
            return;

        if(currPos > board.getSize()) {
            currPos = initialPos;
            return;
        }
        this.movesList.add(new Path(prevPos,currPos));
        if(rollOut == 6)
            makeMove(board,initialPos,sixCount+1);
    }

    public boolean checkPlayerWon(Board board){
        return this.currPos == board.getSize();
    }

    @Override
    public String toString() {
        return  name + " {" + currPos + "}\t";
    }

}

 class PlayerList {
    protected static List<Player> initializePlayers(List<String> playersName) throws Exception {
        List<Player> players= new ArrayList<>();
        if(playersName==null || playersName.isEmpty()){
            throw new Exception("Not able to set list of players for the game");
        }
        playersName.forEach(name->players.add(Player.initializePlayer(name)));
        System.out.print("Players Added to Game\t");
        showPlayersLocation(players);
        return players;
    }

    public static void showPlayersLocation(List<Player> players){
        players.forEach(System.out::print);
        System.out.println();
    }
}
