package com.example.project;

public class Sprite {
    private int x, y;

    public Sprite(int x, int y) {
        this.x = x;    //initialize x
        this.y = y;    //initialize y
    }

    public int getX(){return x;} //returns the x value 
    public int getY(){return y;} //returns the y value 

    public void setX(int num){ x=num;} //sets the x value to the new value in the parameter
    public void setY(int num){y=num;} //sets the y value to the new value in the parameter

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + x + "," + y + ")"; 
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "[" + (size - 1 - y) + "][" + x + "]";
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
