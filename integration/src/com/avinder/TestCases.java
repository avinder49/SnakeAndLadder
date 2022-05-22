package com.avinder;

import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;
import com.avinder.models.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class TestCases {

    @Test
    public void testGameWithBoardOfSize0() {
        try {
            new Board(0);
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Enter Valid Size Of Board");
        }
    }
    @Test
    public void testGameWithBoardOfValidSize() throws Exception {
        Game g = new Game();
        g.setBoard(new Board(10));
        assertNotNull(g.getBoard());

    }

    @Test
    public void testGameWithBoardOfValidSizeAndInvalidPlayers() {
        try {
            Game.initializeGame(10,null);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("Not able to set list of players for the game",e.getMessage());
        }

    }

    @Test
    public void testGameWithBoardOfValidSizeAnd0Players() {
        try {
            Game.initializeGame(10,new ArrayList<>());
        } catch (Exception e) {
            assertEquals("Not able to set list of players for the game",e.getMessage());
        }

    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4Players(){
        try {
            Game g = Game.initializeGame(10, Arrays.asList("A", "B", "C" , "D"));
            g.setCurrentMovingPlayer(null);
            g.startGame();
        } catch (Exception e) {
            assertEquals("No current Moving Player Initialized",e.getMessage());
        }
    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4PlayersWithNoBoardObjects() throws Exception {
        Game g = Game.initializeGame(10, Arrays.asList("A", "B", "C" , "D"));
        g.getBoard().setObjectMap(null);
        System.out.println(g);
        try {
            assertNotNull(g.startGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4PlayersAWithBoardObjects() throws Exception {
        Game g = Game.initializeGame(10, Arrays.asList("A", "B", "C" , "D"));
        try {
            assertNotNull(g.startGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
