package com.avinder.models;

import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;

import java.util.Random;
public class Snake {
    private String name;
    private String colour;
    private Path path;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getColour() {return colour;}
    public void setColour(String colour) {this.colour = colour;}
    public Path getPath() {return path;}
    public void setPath(Path path) {this.path = path;}

    public Snake(String name, String colour, Path path) {
        this.name = name;
        this.colour = colour;
        this.path = path;
    }
    public static Snake initializeSnakeRandomly(Board board){

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
        return "Snake{" + name + "} {" + colour + "} {" + path + "}";
    }
}
