package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite{ //child  of Sprite
    
    public Enemy(int x, int y) {  //constructor 
        super(x, y);  //inherit from the Sprite class
    }


    //the methods below should override the super class 

    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords(); //return coordinates of the enemy 
    }

    @Override
    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Enemy:"+ super.getRowCol(size);  //returns the row and column of the enemy 
    }
}