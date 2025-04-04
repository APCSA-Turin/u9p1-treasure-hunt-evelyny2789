package com.example.project;
import java.util.Scanner;

public class Game{//game
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Grid getGrid(){  //returns the grid 
        return grid; 
    }

    public Player getPlayer(){ //returns the player 
        return player; 
    }

    public Enemy[] getEnemies(){ //returns the enemies 
        return enemies; 
    }

    public Treasure[] getTreasures(){ //returns the treasures 
        return treasures; 
    }

    public int getSize(){  //returns the size 
        return size; 
    }

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;  //initialize size
        this.initialize();

    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        String input = ""; 

        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            //here
        }
            
            

    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        player = new Player(2, 3);
        grid = new Grid(size);
        trophy = new Trophy(size- 1, size -1);
        grid.placeSprite(player);
        grid.placeSprite(trophy);
    }

    public static void main(String[] args) {
        Game a = new Game(10);
        a.getGrid().display();
        System.out.println(a.getPlayer().getX());
    }
}