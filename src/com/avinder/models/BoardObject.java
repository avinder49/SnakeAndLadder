package com.avinder.models;

public abstract class BoardObject{
    private static  Board board;
    private final Path path;
    private final String colour;
    private final String type;

    public BoardObject(Path path, String colour,String type){
        this.path = path;
        this.colour = colour;
        this.type = type;
    }

    public static void setBoard(Board board){ // Single static Board can be shared among many boardObject objects
        if(BoardObject.board == null)
        BoardObject.board = board;

    }

    public static Board getBoard(){
        return BoardObject.board;
    }

    public Path getPath()   {return path;}
    public String getColour() {return colour;}
    public String getType() {return type;}
    public static BoardObject initializeObject(){
        return null;
    };
}
