package com.sortusritus;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();



    }
       public static void playGame(){
           Grid g = new Grid();
           System.out.println("Welcome to 2048 by Zachary Coppin use wasd to move grid.");
           g.initialize();
           g.print();;
           while(g.getMaxValue() < 2048 && g.checkForValidMove()){
               for(String s : getInput()){
               if(s.equals("w")){

                   if(g.checkUpValid()) {
                       g.moveUp();
                       g.generate();
                   }
                   g.print();
               }
               if(s.equals("s")){
                   if(g.checkDownValid()) {
                       g.moveDown();
                       g.generate();
                   }
                   g.print();
               }
               if(s.equals("a")){
                   if(g.checkLeftValid()) {
                       g.moveLeft();
                       g.generate();
                   }
                   g.print();
               }
               if(s.equals("d")){
                   if(g.checkRightValid()){
                       g.moveRight();
                       g.generate();
                   }
                   g.print();
               }}
           }
           if(g.getMaxValue() <= 2048){
               System.out.println("You win!");
           }
           else{
               System.out.println("You lose!");
           }


       }
    public static String[] getInput(){
        String c = "z";
        while(!c.equals("w") && !c.equals("s")  && !c.equals("a") && !c.equals("d")){
            Scanner s = new Scanner(System.in);
            System.out.println("Use 'w' 'a' 's' 'd' to move grid.");
            c = s.next();
        }
        return c.split(" ");
    }
}
