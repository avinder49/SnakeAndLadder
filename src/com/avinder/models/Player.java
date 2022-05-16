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

    public boolean checkObject(Board board,int currentPos, int rollOut){
        Object object = board.objectMap.get(currentPos);
        Snake snake = null;
        Ladder ladder = null;
        if(object instanceof Snake){
            snake = (Snake) object;
        }
        if(object instanceof Ladder){
            ladder = (Ladder) object;
        }

        if(snake == null && ladder == null)
            return false;

        if(snake !=null) {
            this.currPos = snake.getPath().getTo();
            System.out.println(String.format("%s got bitten by %s", getName(), snake));
            this.movesList.add(new Path(currentPos - rollOut, currPos));
        }
        if(ladder !=null) {
            this.currPos = ladder.getPath().getTo();
            System.out.println(String.format("%s climbed %s", getName(), ladder));
            this.movesList.add(new Path(currentPos - rollOut, currPos));
        }
        return true;
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
        Thread.sleep(1000);
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

}

 class PlayerList {
    static List<Player> players;
    protected static List<Player> initializePlayers(Scanner scan){
        System.out.println("Enter No of Players");
        int playersCount = scan.nextInt();
        while(playersCount<=0 ){
            System.out.println("Enter Valid Number");
            playersCount = scan.nextInt();
        }
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
