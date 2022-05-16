package com.avinder.models;

public class Path {
    @Override
    public String toString() {
        return "Path{" + from +
                "->" + to + '}';
    }

    int from;
    int to;
    Path(int from , int to){
        this.from = from;
        this.to = to;
    }

}
