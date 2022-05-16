package com.avinder.models;

import com.avinder.constants.COLOUR;
import com.avinder.constants.SNAKE;

import java.util.Random;
public class Snake {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private String colour;
    private Path path;

    public Snake(String name, String colour, Path path) {
        this.name = name;
        this.colour = colour;
        this.path = path;
    }
    public static Snake initializeSnakeRandomly(Board board){

        String name = SNAKE.values()[new Random().nextInt(SNAKE.values().length)].name();
        String colour = COLOUR.values()[new Random().nextInt(COLOUR.values().length)].name();
        int from = new Random().nextInt(board.getSize());
        int to = new Random().nextInt(board.getSize());
        if(to > from){
            from = to^from;
            to= to^from;
            from = to^from;
        }

        Snake snake = new Snake(name,colour,new Path(from, to));
        board.snakeMap.put(from,snake);
        return snake;
    }

    @Override
    public String toString() {
        return "Snake{" + name + "} {" + colour + "} {" + path;
    }
}
