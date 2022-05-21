package com.avinder.models;

import com.avinder.constants.COLOUR;

import java.util.Random;

public class Ladder extends BoardObject{

    public Ladder(String colour, Path path) {
        super(path, colour,Ladder.class.getName());
    }
    public static Ladder initializeLadderRandomly(){
        Board board = BoardObject.getBoard();
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
        return "Ladder{" + super.getColour() + "} {" + super.getPath() + "}";
    }
}
