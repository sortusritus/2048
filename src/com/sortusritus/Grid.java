package com.sortusritus;

import com.sortusritus.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    List<Tile> grid = new ArrayList<>();
    public Grid(){
        for(int i =1; i <= 16; i++ ){
            Tile tile = new Tile(i);
            grid.add(tile);
        }
    }
    public void print(){
        for(int i=1; i<= 16;i++){
            if((i-1) % 4 == 0){
                System.out.println(" ");
            }
            for(Tile t : grid){
                if(t.getLocation() == i){
                    t.print();
                }
            }
        }
        System.out.println(" ");
    }
    public void generate() {
        boolean generated = false;
        while (!generated) {
            Random r = new Random();
            int location = r.nextInt(16) + 1;
            for (Tile t : grid) {
                if (t.getLocation() == location && !t.isOccupied()) {
                    t.generate();
                    generated = true;
                }
            }
        }
    }
    public boolean gridIsOccupied() {
    for(Tile t : grid){
        if(!t.isOccupied()){
            return false;
        }
    }
    return true;
    }
    public void initialize(){
        int a;
        int b;
        Random random = new Random();
        a = random.nextInt(16) + 1;
        b = random.nextInt(16) + 1;
        while(b == a){
            b = random.nextInt(16) + 1;
        }
        for(Tile t : grid){
            if(t.getLocation() == a || t.getLocation() == b){
                t.generate();
            }
        }
    }
    public Tile getTileByLocation(int location){
        for(Tile t : this.grid){
            if(t.getLocation() == location){
                return t;
            }
        }
        return null;
    }
    public boolean moveUp() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() > 4 && !getTileByLocation(t.getLocation() - 4).isOccupied()) {
                t.swap(getTileByLocation(t.getLocation() - 4));
                moveUp();
                return true;
            } else if (t.isOccupied() && t.getLocation() > 4 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() - 4).getValue()) {
                t.merge(getTileByLocation(t.getLocation() - 4));
                moveUp();
                return true;
            }
        }
        clear(); return false;
    }

        public boolean moveDown () {
            for (Tile t : this.grid) {
                if (t.isOccupied() && t.getLocation() < 13 && !getTileByLocation(t.getLocation() + 4).isOccupied()) {
                    t.swap(getTileByLocation(t.getLocation() + 4));
                    moveDown();
                    return true;
                } else if (t.isOccupied() && t.getLocation() < 13 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() + 4).getValue()) {
                    t.merge(getTileByLocation(t.getLocation() + 4));
                    moveDown();
                    return true;
                }
            }
            clear();
            return false;
        }

        public boolean moveLeft1() {
            for (Tile t : this.grid) {
                if (t.isOccupied() && t.getLocation() > 1 && !getTileByLocation(t.getLocation() - 1).isOccupied() && t.getLocation() < 5) {
                    t.swap(getTileByLocation(t.getLocation() - 1));
                    return true;
                } else if (t.isOccupied() && t.getLocation() > 1 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() - 1).getValue() && t.getLocation() < 5) {
                    t.merge(getTileByLocation(t.getLocation() - 1));
                    return true;
                }
            } clear(); return false;
        }
    public boolean moveLeft2() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() > 5 && !getTileByLocation(t.getLocation() - 1).isOccupied() && t.getLocation() < 9) {
                t.swap(getTileByLocation(t.getLocation() - 1));
                return true;
            } else if (t.isOccupied() && t.getLocation() > 5 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() - 1).getValue() && t.getLocation()< 9) {
                t.merge(getTileByLocation(t.getLocation() - 1));
                return true;
            }
        } clear(); return false;
    }
    public boolean moveLeft3() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() > 9 && !getTileByLocation(t.getLocation() - 1).isOccupied() && t.getLocation() < 13) {
                t.swap(getTileByLocation(t.getLocation() - 1));
                return true;
            } else if (t.isOccupied() && t.getLocation() > 9 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() - 1).getValue() && t.getLocation()< 13) {
                t.merge(getTileByLocation(t.getLocation() - 1));
                return true;
            }
        } clear(); return false;
    }
    public boolean moveLeft4() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() > 13 && !getTileByLocation(t.getLocation() - 1).isOccupied() && t.getLocation() < 17) {
                t.swap(getTileByLocation(t.getLocation() - 1));
                return true;
            } else if (t.isOccupied() && t.getLocation() > 13 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() - 1).getValue() && t.getLocation()< 17) {
                t.merge(getTileByLocation(t.getLocation() - 1));
                return true;
            }
        } clear(); return false;
    }

    public boolean moveLeft() {
        while(moveLeft1()){

        }while(moveLeft2()) {
        }
        while(moveLeft3()){

        }while(moveLeft4()) {
        }
       return false;
            }
    public boolean moveRight () {
        moveRight1();
        moveRight2();
        moveRight3();
        moveRight4();
        return true;
    }
    public boolean moveRight4() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() < 16 && !getTileByLocation(t.getLocation() + 1).isOccupied() && t.getLocation() >= 13) {
                t.swap(getTileByLocation(t.getLocation() + 1));
                moveRight4();
                return true;
            } else if (t.isOccupied() && t.getLocation() < 16 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() + 1).getValue() && t.getLocation() >= 13) {
                t.merge(getTileByLocation(t.getLocation() + 1));
                moveRight4();
                return true;
            }
        }
        clear();
        return false;
    }
    public boolean moveRight3() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() < 12 && !getTileByLocation(t.getLocation() + 1).isOccupied() && t.getLocation()>= 9) {
                t.swap(getTileByLocation(t.getLocation() + 1));
                moveRight3();
                return true;
            } else if (t.isOccupied() && t.getLocation() < 12 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() + 1).getValue() && t.getLocation()>= 9) {
                t.merge(getTileByLocation(t.getLocation() + 1));
                moveRight3();
                return true;
            }
        }
        clear();
        return false;
    }
    public boolean moveRight2() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() < 8 && !getTileByLocation(t.getLocation() + 1).isOccupied() && t.getLocation()>= 5) {
                t.swap(getTileByLocation(t.getLocation() + 1));
                moveRight2();
                return true;
            } else if (t.isOccupied() && t.getLocation() < 8 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() + 1).getValue() && t.getLocation() >= 5) {
                t.merge(getTileByLocation(t.getLocation() + 1));
                moveRight2();
                return true;
            }
        }
        clear();
        return false;
    }
    public boolean moveRight1() {
        for (Tile t : this.grid) {
            if (t.isOccupied() && t.getLocation() < 4 && !getTileByLocation(t.getLocation() + 1).isOccupied() && t.getLocation() >= 1) {
                t.swap(getTileByLocation(t.getLocation() + 1));
                moveRight1();
                return true;
            } else if (t.isOccupied() && t.getLocation() < 4 && !t.hasMerged() && t.getValue() == getTileByLocation(t.getLocation() + 1).getValue() && t.getLocation()>= 1) {
                t.merge(getTileByLocation(t.getLocation() + 1));
                moveRight1();
                return true;
            }
        }
        clear();
        return false;
    }
        public void clear(){
       for(Tile t : this.grid){
           t.clear();
       }

        }
        public int getMaxValue(){
        int max = 0;
        for(Tile t: this.grid){
            if(t.getValue() > max){
                max = t.getValue();
            }
        }
        return max;
        }
    public boolean checkForValidMove(){
        if(!gridIsOccupied()){
            return true;
        }
        for(Tile t : this.grid){
            if(t.getValue() == getTileByLocation(t.getLocation() -1).getValue() || t.getValue() == getTileByLocation(t.getLocation() + 1).getValue() || t.getValue() == getTileByLocation(t.getLocation() + 4).getValue() || t.getValue() == getTileByLocation(t.getLocation() -4).getLocation()){
                return true;
            }
        }return false;
    }
    public boolean checkUpValid(){
        boolean valid = false;
        for(Tile t : grid){
            if(t.getLocation() > 4 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() - 4).isOccupied() || getTileByLocation(t.getLocation() - 4).getValue() == t.getValue()){
                    valid = true;
                }
            }
        } return valid;
    }
    public boolean checkDownValid(){
        boolean valid = false;
        for(Tile t : grid){
            if(t.isOccupied() && t.getLocation() < 13){

                if(!getTileByLocation(t.getLocation() + 4).isOccupied() || getTileByLocation(t.getLocation() + 4).getValue() == t.getValue()){
                    valid = true;

            }}
        } return valid;
    }
    public boolean checkLeftValid(){
        boolean valid = false;
        for(Tile t : grid){
            if(t.getLocation() > 1 && t.getLocation() <= 4 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() - 1).isOccupied() || getTileByLocation(t.getLocation() -1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() > 5 && t.getLocation() <= 8 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() - 1).isOccupied() || getTileByLocation(t.getLocation() -1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() > 9 && t.getLocation() <= 12 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() - 1).isOccupied() || getTileByLocation(t.getLocation() -1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() > 13 && t.getLocation() <= 16 && t.isOccupied()){
                if(!(getTileByLocation(t.getLocation() - 1).isOccupied()) || getTileByLocation(t.getLocation() -1).getValue() == t.getValue()){
                    valid = true;
                }
            }
        } return valid;
    }
    public boolean checkRightValid(){
        boolean valid = false;
        for(Tile t : grid){
            if(t.getLocation() >= 1 && t.getLocation() < 4 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() + 1).isOccupied() || getTileByLocation(t.getLocation() + 1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() >= 5 && t.getLocation() < 8 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() + 1).isOccupied() || getTileByLocation(t.getLocation() + 1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() >= 9 && t.getLocation() < 12 && t.isOccupied()){
                if(!getTileByLocation(t.getLocation() + 1).isOccupied() || getTileByLocation(t.getLocation() + 1).getValue() == t.getValue()){
                    valid = true;
                }
            }
            if(t.getLocation() >= 13 && t.getLocation() < 16 && t.isOccupied()){
                if(!(getTileByLocation(t.getLocation() + 1).isOccupied()) || getTileByLocation(t.getLocation() + 1).getValue() == t.getValue()){
                    valid = true;
                }
            }
        } return valid;
    }

    }


