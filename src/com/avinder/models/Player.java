package com.avinder.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private String name;

    @Override
    public String toString() {
        return  name + " {" + currPos + "}\t";
    }

    private int currPos;


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

    Player(String name, int startingPos){
        this.name = name;
        this.currPos = startingPos;
    }

    public void makeMove() throws InterruptedException {
        // Roll a dice
        int rollOut = 1+ new Random().nextInt(6);
        Thread.sleep(rollOut*1000);
        System.out.println("Rolled number by "+this.getName()+" is "+ rollOut);
        this.currPos += rollOut;
    }

    public boolean checkPlayerWon(Board board){
        if(this.currPos >=board.getSize())
            return true;
        return false;
    }


}

 class PlayerList {
    static List<Player> players;
    protected static List<Player> initializePlayers(Scanner scan){
        System.out.println("Enter No of Players");
        int playersCount = scan.nextInt();
        players= new ArrayList<>(playersCount);
        for(int i=0;i<playersCount;i++) {
            System.out.println("Enter Player Name");
            String playerName = scan.next();
            players.add(new Player(playerName,0));
        }

        System.out.println("Players Added to Game");
        return players;
    }

    public static void showPlayersLocation(){
        players.forEach(System.out::print);
        System.out.println();

    }
}
