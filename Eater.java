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
    int limitBombs=500;
    static int level=0;
    static int eatenFruits=0;
    static int lives=10;
    static int highScore=0;
    
    Eater(){}
    
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
        if(getX()<2 || getX()>MyWorld.width-2){
            setLocation(MyWorld.width-getX(),getY());
        }
        if(getY()<2 || getY()>MyWorld.height-2){
            setLocation(getX(),MyWorld.height-getY());
        }
    }
    
    public void act()
    {
        // Add your action code here.
        eatFruit();
        moveEater();
        increaseLevel();
    }
    
    public void eatFruit(){
        Actor fruit=getOneObjectAtOffset(0,0,Fruit.class);
        if(fruit!=null){
            MyWorld.eatSound.play();
            getWorld().addObject(new Fruit(),Greenfoot.getRandomNumber(MyWorld.width),Greenfoot.getRandomNumber(MyWorld.height-20));
            getWorld().removeObject(fruit);
            score+=5;
            eatenFruits+=1;
        }
    }
    
    public void increaseLevel(){
        if(eatenFruits==5){
            level++;
            getWorld().addObject(new Car(),Greenfoot.getRandomNumber(MyWorld.width),Greenfoot.getRandomNumber(MyWorld.height-20));
            eatenFruits=0;
        }
    }
    
    
}
