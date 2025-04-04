package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size]; 
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                grid[i][j] = new Dot(i, j);
            }
        }
    }

 
    public Sprite[][] getGrid(){
        return grid;
    }



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size - 1 - s.getY()][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        grid[size - 1 - s.getY()][s.getX()] = s;
        Dot empty = new Dot(0,0);
        //placing a dot behind the player based on the direction inputted
        empty.setY(direction.equals("w") ? s.getY() - 1 : direction.equals("s") ? s.getY() + 1 : s.getY());
        empty.setX(direction.equals("a") ? s.getX() + 1 : direction.equals("d") ? s.getX() - 1 : s.getX());
        placeSprite(empty);
    }


    public void display() { //print out the current grid to the screen 
        for(Sprite[] row :grid){
            for(Sprite sprite : row){
                if(sprite instanceof Dot){
                    System.out.print("⬜");
                } else if(sprite instanceof Player){
                    System.out.print("👍");
                } else if(sprite instanceof Enemy){
                    System.out.print("🦖");
                } else if (sprite instanceof Treasure && !(sprite instanceof Trophy)){
                    System.out.print("🪙 ");
                } else{
                    System.out.print("🏆");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        System.out.println("You lost");
    }

    public void win(){ //use this method to display a win 
        System.out.println("You won!");
    }


}