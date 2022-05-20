package com.avinder.models;

import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;

import java.util.Random;
public class Snake extends BoardObject{
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Snake(String name, String colour, Path path) {
        super(path, colour,Snake.class.getName());
        this.name = name;
    }
    public static Snake initializeObject(){
        Board board = BoardObject.getBoard();
        String name = SNAKE.values()[new Random().nextInt(SNAKE.values().length)].name();
        String colour = COLOUR.values()[new Random().nextInt(COLOUR.values().length)].name();
        int from = 1+ new Random().nextInt(board.getSize()-1);
        int to = 1+ new Random().nextInt(board.getSize()-1);
        if(to > from) { to = to^from;  from = to^from;  to = to^from;}

        Snake snake = new Snake(name,colour,new Path(from, to));
        board.objectMap.put(from,snake);
        return snake;
    }

    @Override
    public String toString() {
        return "Snake{" + this.name + "} {" + super.getColour() + "} {" + super.getPath() + "}";
    }
}
