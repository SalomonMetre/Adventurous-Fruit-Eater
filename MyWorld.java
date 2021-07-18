import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static int width=1000,height=600;
    static int numberCars=15;
    static int numberFruits=5;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width,height, 1);
        for(int i=0;i<numberCars;i++)
            addObject(new Car(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-20));
        for(int i=0;i<numberFruits;i++)
            addObject(new Fruit(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-20));
        addObject(new Eater(),MyWorld.width/2,MyWorld.height-20);
    }
}
