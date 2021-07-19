import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eater extends Actor
{
    /**
     * Act - do whatever the Eater wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int moveDistance=3;
    static int score;
    int limitBombs=100;
    
    Eater(){
        score=0;
    }
    
    public void moveEater(){
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-moveDistance);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+moveDistance);
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+moveDistance,getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-moveDistance,getY());
        }
        if(Greenfoot.isKeyDown("r")){
            if(moveDistance<=5)
                moveDistance+=1;
        }
        if(Greenfoot.isKeyDown("g")){
            if(moveDistance>=2)
                moveDistance-=1;
        }
        if(Greenfoot.isKeyDown("Space")){
            if(limitBombs>=1){
            getWorld().addObject(new Fire(),getX(),getY());
            limitBombs-=1;
            }
        }
    }
    
    public void act()
    {
        // Add your action code here.
        eatFruit();
        moveEater();
    }
    
    public void eatFruit(){
        Actor fruit=getOneObjectAtOffset(0,0,Fruit.class);
        if(fruit!=null){
            getWorld().addObject(new Fruit(),Greenfoot.getRandomNumber(MyWorld.width),Greenfoot.getRandomNumber(MyWorld.height-20));
            getWorld().removeObject(fruit);
            score+=5;
        }
    }
    
    
}
