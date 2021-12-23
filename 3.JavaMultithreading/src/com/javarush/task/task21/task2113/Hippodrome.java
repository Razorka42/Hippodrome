package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    };
    public void move(){
        for (Horse horse: horses){
            horse.move();
        }
    };
    public void print(){
        for (Horse horse: horses){
            horse.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    };
    public Horse getWinner(){
        double best = 0;
        Horse bestHorse = null;
        for (Horse horse: horses){
            if( horse.getDistance() > best){
                best = horse.getDistance();
                bestHorse = horse;
            }
        }
        return bestHorse;
    };
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("Betty", 3, 0);
        Horse horse2 = new Horse("Funny", 3, 0);
        Horse horse3 = new Horse("Bunny", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        Hippodrome hippodrome = new Hippodrome(horses);
        game = hippodrome;
        game.run();
        game.printWinner();
    }
}
