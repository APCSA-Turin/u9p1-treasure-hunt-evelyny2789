package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size; //initialize size 
        grid = new Sprite[size][size]; //creat a grid with the dimensions of size 
        for (int i = 0; i < size; i++){ //iterate throught the rows 
            for (int j = 0; j < size; j++){ //iterate through the columns 
                grid[i][j] = new Dot(i, j); //place dot 
            }
        }
    }

 
    public Sprite[][] getGrid(){ 
        return grid;  //returns the grid 
    }



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size - 1 - s.getY()][s.getX()] = s; //sets the sprite to the position in the grid 
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        grid[size - 1 - s.getY()][s.getX()] = s; //sets sprite to posiiton in the grid 
        Dot empty = new Dot(0,0); //create new dot 
        //placing a dot behind the player based on the direction inputted
        empty.setY(direction.equals("w") ? s.getY() - 1 : direction.equals("s") ? s.getY() + 1 : s.getY()); //if the direction is "w" the y position gets increased by 1, and if the direction equals "s", the y postition gets decreased by 1
        empty.setX(direction.equals("a") ? s.getX() + 1 : direction.equals("d") ? s.getX() - 1 : s.getX()); //if the direction equals "a", the x position gets decreased by 1, and if the direction is "d", the x position gets increased by 1
        placeSprite(empty); //places the sprite in the new spot 
    }


    public void display() { //print out the current grid to the screen 
        for(Sprite[] row :grid){ //iterate through the row in grid 
            for(Sprite sprite : row){ //iterate through the sprite in the row 
                if(sprite instanceof Dot){ //checks if the sprite is a dot object 
                    System.out.print("⬜"); //print out dot 
                } else if(sprite instanceof Player){ //checks if the spite is a player object 
                    System.out.print("👍"); //print a thumbs up 
                } else if(sprite instanceof Enemy){ //checks if the sprite is an enemy 
                    System.out.print("🦖"); //print out enemy 
                } else if (sprite instanceof Treasure && !(sprite instanceof Trophy)){ //checks if the sprite is a treasure but not a trophy 
                    System.out.print("🪙 "); //prints a coin 
                } else{ //the sprite is a trophy 
                    System.out.print("🏆"); //print a trophy 
                }
            }
            System.out.println(); //print on next line 
        }
    }
    
    public void gameover(){ //use this method to display a loss
        System.out.println("You lost"); //prints that the player lost 
    }

    public void win(){ //use this method to display a win 
        System.out.println("You won!"); //prints that the player won 
    }


}