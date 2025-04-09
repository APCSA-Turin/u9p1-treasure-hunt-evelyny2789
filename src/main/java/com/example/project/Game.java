package com.example.project;
import java.util.Scanner;

public class Game{
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
        play();
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
    

        while(true){ //if the player wants to play again 
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            grid.display(); //display the grid 
            System.out.println(player.getCoords()); //prints the coordinates of the player 
            System.out.println(player.getRowCol(size)); //prints the row and column of the player 
            System.out.println(player.getTreasureCount()); //prints the amount of treasures that the player has
            System.out.println(player.getLives()); //prints the lives that the player has 
            System.out.println("Enter a direction (w,a,s,d) or 'q' to exit: " ); //returns the x value of the player 
            String input = scanner.nextLine();
            if(input.equals("a") ||input.equals("w") ||input.equals("s") ||input.equals("d")){
                //CODE to find the object that the player is going to land on here:

                player.interact(size, input, treasures.length, new Object());
                if(player.isValid(size, input)){//update this afterwards
                    player.move(input);
                }
                grid.placeSprite(player, input);
            }
            if(player.getWin()){
                grid.win();
                break;
            } else if(player.getLives() < 1){
                grid.gameover();
                break;
            }
        }
    }
    

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        player = new Player(2, 3);  //create new player
        grid = new Grid(size);   //create new grid 
        trophy = new Trophy(size - 1, size - 1);  //create new trophy
        grid.placeSprite(player); //place the player on the grid 
        grid.placeSprite(trophy); //place the trophy on the grid 
    }

    public static void main(String[] args) {
        Game a = new Game(10);
    }
}