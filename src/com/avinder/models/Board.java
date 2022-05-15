package com.avinder.models;
import java.util.Scanner;

public class Board {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected static Board initializeBoard(Scanner scan ){
        System.out.println("Enter the size of board");
        int boardSize = scan.nextInt();
        return new Board(boardSize*boardSize);
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
