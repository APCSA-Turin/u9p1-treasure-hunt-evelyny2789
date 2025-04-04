package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite{
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0; 
        numLives = 2; 
        win = false; 
    }

    public int getTreasureCount(){
        return treasureCount;
    }
    public int getLives(){
        return numLives;
    }
    public boolean getWin(){
        return win;
    }

    @Override
    public String getCoords(){
        return "Player:" + super.getCoords(); 
    }

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
            if (direction.equals("w")){
                this.setY(this.getY() + 1);
            }
            if (direction.equals("s")){
                this.setY(this.getY() - 1); 
            }
            if (direction.equals("a")){
                this.setX(this.getX() - 1); 
            }
            if (direction.equals("d")){
                this.setX(this.getX() + 1); 
            }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (isValid(size, direction)){
            if (obj instanceof Treasure && !(obj instanceof Trophy)){
                treasureCount++; 
            }
    
            if (obj instanceof Trophy && numTreasures == treasureCount){
                win = true;
            }

            if (obj instanceof Enemy){
                numLives--;
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        int xPos = getX(); 
        int yPos = getY();
        if (direction.equals("w") ){
            if(yPos == size-1){
                return false; 
            }
        }
        if (direction.equals("s")){
            if (yPos == 0){
                return false; 
            }
        }
        if (direction.equals("a")){
            if (xPos == 0){
                return false; 
            }
        }
        if (direction.equals("d")){
            if (xPos == size - 1){
                return false; 
            }
        }
        return true;
    }

    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size);
    }

}



