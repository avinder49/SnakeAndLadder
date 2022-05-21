package com.avinder;

import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;
import com.avinder.models.*;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testGameWithBoardOfValidSize() {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setBoard(b);
        assertNotNull(g.getBoard());

    }

    @Test
    public void testGameWithBoardOfValidSizeAndInvalidPlayers() {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setBoard(b);
        assertNotNull(g.getBoard());
        try {
            g.setPlayerList(null);
        } catch (Exception e) {
            assertNull(g.getPlayerList());
            assertEquals("Not able to set list of players for the game",e.getMessage());
        }
        assertNull(g.getPlayerList());

    }

    @Test
    public void testGameWithBoardOfValidSizeAnd0Players() {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setBoard(b);
        assertNotNull(g.getBoard());
        try {
            g.setPlayerList(new ArrayList<>(0));
        } catch (Exception e) {
            assertNull(g.getPlayerList());
            assertEquals("Not able to set list of players for the game",e.getMessage());
        }

    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4Players() throws Exception {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setBoard(b);
        assertNotNull(g.getBoard());
        g.setPlayerList(new ArrayList<>(){
            {
                add(new Player("A"));
                add(new Player("B"));
                add(new Player("C"));
                add(new Player("D"));
            }
        });
        assertNotNull(g.getPlayerList());
        List<Player> players = g.getPlayerList();

        assertEquals(players.size(),4);
        try {
            g.startGame();
        } catch (Exception e) {
            assertEquals("No current Moving Player Initialized",e.getMessage());
        }
    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4PlayersAndCurrentMovingPlayerTo1stPlayer() throws Exception {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setBoard(b);
        assertNotNull(g.getBoard());
        g.setPlayerList(new ArrayList<>(){
            {
                add(new Player("A"));
                add(new Player("B"));
                add(new Player("C"));
                add(new Player("D"));
            }
        });
        assertNotNull(g.getPlayerList());
        List<Player> players = g.getPlayerList();

        assertEquals(players.size(),4);
        g.setCurrentMovingPlayer(players.get(0));
        g.setCurrentMovingPlayerIndex(0);

        try {
            assertNotNull(g.startGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGameWithBoardOfValidSizeAnd4PlayersAndCurrentMovingPlayerTo1stPlayerWithBoardObjects() throws Exception {
        Game g = new Game();
        Board b = null;
        try {
            b = new Board(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        b.setObjectMap(new TreeMap<>(){
            {
                put(5,new Snake(SNAKE.COBRA.name(), COLOUR.BLUE.name(), new Path(2,5)));
                put(9,new Snake(SNAKE.COBRA.name(), COLOUR.RED.name(), new Path(1,9)));
                put(3,new Ladder( COLOUR.BLUE.name(), new Path(3,8)));
                put(4,new Ladder(COLOUR.GREEN.name(), new Path(4,6)));

            }
        });
        g.setBoard(b);
        assertNotNull(g.getBoard());
        g.setPlayerList(new ArrayList<>(){
            {
                add(new Player("A"));
                add(new Player("B"));
                add(new Player("C"));
                add(new Player("D"));
            }
        });
        assertNotNull(g.getPlayerList());
        List<Player> players = g.getPlayerList();

        assertEquals(players.size(),4);
        g.setCurrentMovingPlayer(players.get(0));
        g.setCurrentMovingPlayerIndex(0);

        try {
            assertNotNull(g.startGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
