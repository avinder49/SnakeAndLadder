package com.avinder.models;

import com.avinder.constants.COLOUR;

import java.util.Random;

public class Ladder {
    private String colour;
    private Path path;

    public String getColour() {return colour;}
    public void setColour(String colour) {this.colour = colour;}
    public Path getPath() {return path;}
    public void setPath(Path path) {this.path = path;}

    public Ladder(String colour, Path path) {
        this.colour = colour;
        this.path = path;
    }
    public static Ladder initializeLadderRandomly(Board board){

        String colour = COLOUR.values()[new Random().nextInt(COLOUR.values().length)].name();
        int from = 1+ new Random().nextInt(board.getSize()-1);
        int to = 1+ new Random().nextInt(board.getSize()-1);
        if(to < from) { to = to^from;  from = to^from;  to = to^from;}

        Ladder ladder = new Ladder(colour,new Path(from, to));
        board.objectMap.put(from,ladder);
        return ladder;
    }

    @Override
    public String toString() {
        return "Ladder{" + colour + "} {" + path + "}";
    }
}
