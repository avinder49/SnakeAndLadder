package com.avinder.models;

public class Path {
    private int from;
    private int to;
    public int getFrom() {return from;}
    public void setFrom(int from) {this.from = from;}
    public int getTo() {return to;}
    public void setTo(int to) {this.to = to;}

    @Override
    public String toString() {
        return "Path{" + from +
                "->" + to + '}';
    }

    Path(int from , int to){
        this.from = from;
        this.to = to;
    }

}
