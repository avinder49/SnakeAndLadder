package com.avinder.models;

import java.util.*;

import static com.avinder.models.Game.SIX_COUNT_LIMIT;

public class Board {
    private int size;
    public Map<Integer,BoardObject> objectMap;

    public Board(int size) throws Exception {// Whenever Board is set , then all those dependencies should be set , wherever board static Object is being referenced
        if(size<=0){
            throw new Exception("Enter Valid Size Of Board");
        }
        this.size = size;
        BoardObject.setBoard(this);
    }

    public int getSize() {return size;}
    public void setSize(int size) {this.size = size;}
    public Map<Integer, BoardObject> getObjectMap() {return objectMap;}
    public void setObjectMap(Map<Integer, BoardObject> objectMap) {this.objectMap = objectMap;}

    public static Board initializeBoard(int boardSize) throws Exception {
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
