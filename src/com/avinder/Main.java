package com.avinder;
import com.avinder.models.Game;
import com.avinder.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String st;

        while(true) {
            logger.info("SERVER IS UP AND RUNNING");
            System.out.println("ENTER YOUR CHOICE");
            System.out.println("1. START GAME");
            System.out.println("2. STOP SERVER");
            System.out.println("3. CONTINUE");
             st = scan.next();
            if(st.contentEquals("1")){
                logger.info("STARTING THE GAME");
                startGame();
            }
            if(st.contentEquals("2"))
            {
                logger.info("STOPPING SERVER");
                return;
            }

        }

    }

    public static void startGame() throws Exception {
        Game g = takeInputFromSystem();
        System.out.println();
        Player winningPlayer = g.startGame();
        logger.log(Level.INFO, String.format("Found Winning Player:%s", winningPlayer.getName()));
        System.out.println();
        System.out.println("Sequence Of Moves");
        winningPlayer.getMovesList().forEach(System.out::println);
    }

    public static int takeBoardInput(){
        System.out.println("Enter the size of board");
        int boardSize = scan.nextInt();
        while(boardSize<=0){
            System.out.println("Enter Valid Size Of Board");
            boardSize = scan.nextInt();
        }
        return boardSize;
    }

    public static String takePlayerInput(){
        System.out.println("Enter Player Name");
        String playerName = scan.next();
        return playerName;
    }

    public static List<String> takePlayersInput(){
        System.out.println("Enter No of Players");
        int playersCount = scan.nextInt();
        List<String> playersNameList = new ArrayList<>();
        while(playersCount<=0 ){
            System.out.println("Enter Valid Number");
            playersCount = scan.nextInt();
        }
        for(int i=0;i<playersCount;i++) {
            String playerName = takePlayerInput();
            playersNameList.add(playerName);
        }
        return playersNameList;
    }

    private static Game takeInputFromSystem() throws Exception {
        int boardSize = takeBoardInput();
        List<String> playersNameList = takePlayersInput();
        return initGame(boardSize, playersNameList);
    }

    private static Game initGame(int boardSize, List<String> playersNameList) throws Exception {
        return Game.initializeGame(boardSize,playersNameList);
    }
}
