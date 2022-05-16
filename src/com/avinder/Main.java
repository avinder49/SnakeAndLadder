package com.avinder;
import com.avinder.models.Game;
import com.avinder.models.Player;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
        g.initializeGame();
        System.out.println();
        Player winningPlayer = g.startGame();
        System.out.println("Found Winning Player:->  "+winningPlayer.getName());
        System.out.println();
        System.out.println("Sequence Of Moves::");
        winningPlayer.getMovesList().forEach(System.out::println);

    }
}
