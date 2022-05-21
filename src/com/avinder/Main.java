package com.avinder;
import com.avinder.models.Game;
import com.avinder.models.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        Game g = new Game();
        g.initializeGame();
        System.out.println();
        Player winningPlayer = g.startGame();
        logger.log(Level.INFO,String.format("Found Winning Player:%s",winningPlayer.getName()));

//        logger.log(Level.INFO,String.format("Moves List :%s",winningPlayer.getName()));
        System.out.println();
        winningPlayer.getMovesList().forEach(path-> {
            logger.log(Level.INFO,path.toString());
            System.out.println();
        });

    }
}
