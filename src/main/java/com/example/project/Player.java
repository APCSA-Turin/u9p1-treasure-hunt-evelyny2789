package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite{
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2, constructor 
        super(x, y); //calls super from the sprite class 
        treasureCount = 0; //sets treasureCount = 0
        numLives = 2; //sets numLives = 2
        win = false; //sets win to be false 
    }

    public int getTreasureCount(){
        return treasureCount;  //returns the number of treasures 
    }
    public int getLives(){
        return numLives; //return the number of lives the player has 
    }
    public boolean getWin(){
        return win; //returns if the player won 
    }

    @Override
    public String getCoords(){
        return "Player:" + super.getCoords(); //returns the coordinates of the player 
    }

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
            if (direction.equals("w")){ //if the directon is "w"
                this.setY(this.getY() + 1); //increments y by 1 
            }
            if (direction.equals("s")){ //if the direction is "s"
                this.setY(this.getY() - 1); //decrements y by 1 
            }
            if (direction.equals("a")){ //if the direction is "a"
                this.setX(this.getX() - 1); //decrements x by 1
            }
            if (direction.equals("d")){ //if the direction is "d"
                this.setX(this.getX() + 1); //increments x by 1 
            }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (isValid(size, direction)){ //if the player is able to move in the direction 
            if (obj instanceof Treasure && !(obj instanceof Trophy)){ //if the ovject is a treasure but not a trophy 
                treasureCount++; //increment the number of treasures by 1 
            }
    
            if (obj instanceof Trophy && numTreasures == treasureCount){ //checks if the object is a trophy and the amount of treasures the player has collected is equal to the number of treasures 
                win = true;  //sets win to be true 
            }

            if (obj instanceof Enemy){ //if the object is an enemy 
                numLives--; //decrements the amount of lives by 1 
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        int xPos = getX(); //sets xPos to the x coordinate 
        int yPos = getY(); //sets yPos to the y coordinate 
        if (direction.equals("w") ){ //checks if the directon is "w"
            if(yPos == size-1){ //checks if the y position is one less than the size/boundary of the grid 
                return false; 
            }
        }
        if (direction.equals("s")){ //checks if the direction is "s"
            if (yPos == 0){ //checks if the y position is equal to 0 
                return false; 
            }
        }
        if (direction.equals("a")){ //checks if the driection is equal to "a"
            if (xPos == 0){ //checks if the x position is equal to 0 
                return false; 
            }
        }
        if (direction.equals("d")){ //checks if the direction is equal to "d"
            if (xPos == size - 1){ //checks if the x position is one less than the size/boundary of the grid
                return false; 
            }
        }
        return true; //returns true when the sprite is able to move in the direction 
    }

    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size); //returns the row and column of the player
    }

}



