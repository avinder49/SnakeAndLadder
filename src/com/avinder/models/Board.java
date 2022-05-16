package com.avinder.models;
import java.util.*;

import static com.avinder.models.Game.SIX_COUNT_LIMIT;

public class Board {
    private int size;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    public Map<Integer,Object> objectMap;

    public Board(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<Snake> getSnakeList(){
        return this.snakeList;
    }
    public void setSnakeList(List<Snake> snakeList) { this.snakeList = snakeList;}
    public List<Ladder> getLadderList() { return ladderList;}
    public void setLadderList(List<Ladder> ladderList) {this.ladderList = ladderList;}

    protected static Board initializeBoard(Scanner scan ){
        System.out.println("Enter the size of board");
        int boardSize = scan.nextInt();
        while(boardSize<=0){
            System.out.println("Enter Valid Size Of Board");
            boardSize = scan.nextInt();
        }
        Board board=  new Board(boardSize*boardSize);
        System.out.println("Board initialized");
        board.objectMap = new HashMap<>();
        board.initializeSnakesRandomly();
        board.initializeLaddersRandomly();
        System.out.println("Snakes & Ladder Initialization Complete");
        board.objectMap.forEach((k,v)-> System.out.println(k+"  "+v));

        System.out.println(board);
        return board;
    }

    public void initializeSnakesRandomly() {
        int snakes = SIX_COUNT_LIMIT + new Random().nextInt(SIX_COUNT_LIMIT);//[3,5]
        List<Snake> snakeList = new ArrayList<>(snakes);
        for (int i = 0; i < snakes; i++)
            snakeList.add(Snake.initializeSnakeRandomly(this));
        this.snakeList =  snakeList;
    }

    public void initializeLaddersRandomly() {
        int ladders = SIX_COUNT_LIMIT + new Random().nextInt(SIX_COUNT_LIMIT);//[3,5]
        List<Ladder> ladderList = new ArrayList<>(ladders);
        for (int i = 0; i < ladders; i++)
            ladderList.add(Ladder.initializeLadderRandomly(this));
        this.ladderList =  ladderList;
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", snakeList=" + snakeList +
                ", ladderList=" + ladderList +
                ", objectMap=" + objectMap +
                '}';
    }


}
