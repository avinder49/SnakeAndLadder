package com.avinder.models;
import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;

import java.util.*;

import static com.avinder.models.Game.SIX_COUNT_LIMIT;

public class Board {
    private int size;
    public Map<Integer,BoardObject> objectMap;

    public Board(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    protected static Board initializeBoard(Scanner scan ){
        System.out.println("Enter the size of board");
        int boardSize = scan.nextInt();
        while(boardSize<=0){
            System.out.println("Enter Valid Size Of Board");
            boardSize = scan.nextInt();
        }
        Board board=  new Board(boardSize*boardSize);
        System.out.println("Board initialized");
        board.objectMap = new TreeMap<>();
        BoardObject.setBoard(board);
        board.initializeSnakesRandomly();
        board.initializeLaddersRandomly();
        System.out.println("Snakes & Ladder Initialization Complete");
        board.objectMap.forEach((k,v)-> System.out.println(k+"  "+v));

        System.out.println(board);
        return board;
    }

    public void initializeSnakesRandomly() {
        int snakes = SIX_COUNT_LIMIT + new Random().nextInt(SIX_COUNT_LIMIT);//[3,5]
        for (int i = 0; i < snakes; i++)
            Snake.initializeObject();
    }

    public void initializeLaddersRandomly() {
        int ladders = SIX_COUNT_LIMIT + new Random().nextInt(SIX_COUNT_LIMIT);//[3,5]
        for (int i = 0; i < ladders; i++)
            Ladder.initializeObject();
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", objectMap=" + objectMap +
                '}';
    }
}
