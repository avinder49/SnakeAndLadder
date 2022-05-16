package com.avinder.models;
import java.util.*;

public class Board {
    private int size;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    public Map<Integer,Snake> snakeMap;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected static Board initializeBoard(Scanner scan ){
        System.out.println("Enter the size of board");
        int boardSize = scan.nextInt();
        Board board=  new Board(boardSize*boardSize);
        System.out.println("Board initialized");
        board.initializeSnakesRandomly();
        System.out.println("Snakes Initialization Complete");
        board.snakeMap.forEach((k,v)-> System.out.println(k+"  "+v));
        return board;
    }

    public List<Snake> getSnakeList(){
       return this.snakeList;
    }

    public void initializeSnakesRandomly() {
        this.snakeMap = new HashMap<>();
        int snakes = 1 + new Random().nextInt(6);
        List<Snake> snakeList = new ArrayList<>(snakes);
        for (int i = 0; i < snakes; i++)
            snakeList.add(Snake.initializeSnakeRandomly(this));

        this.snakeList =  snakeList;
    }
     public Board(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                '}';
    }


}
