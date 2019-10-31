package com.sortusritus;

import java.util.Random;

public class Tile {
    private int value;
    private int location;
    private boolean occupied;
    private boolean merged;


    public Tile(int location) {
        this.value = 0;
        this.location = location;
        this.occupied = false;
    }

    public int getLocation() {
        return this.location;
    }

    public boolean isOccupied() {
        return occupied;
    }
    public boolean hasMerged(){return merged;}
    public void clear(){
        merged = false;
    }

    public void merge(Tile t) {
        if (t != null) {
            if (t.equals(this)) {
                t.value *= 2;
                t.merged = true;
                this.value = 0;
                this.occupied = false;

            }
        }
    }
    public void swap(Tile t){
        int temp;
        temp = t.location;

        t.location = this.location;
        this.location = temp;


    }

    public int getValue(){return this.value;}



    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tile)) {
            return false;
        } else {
            Tile t = (Tile) obj;
            if (t.value == this.value) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void print() {
        if (!isOccupied()) {
            System.out.print("[ ]");
        } else {
            System.out.print("[" + Integer.toString(this.value) + "]");
        }
    }

    public boolean generate() {
        if (!this.isOccupied()) {
            Random r = new Random();
            int i = r.nextInt((10 - 1) + 1) + 1;
            if (i == 1) {
                this.value = 4;
                this.occupied = true;
                return true;
            } else {
                this.value = 2;
                this.occupied = true;
                return true;
            }
        }
        return false;
    }




}
