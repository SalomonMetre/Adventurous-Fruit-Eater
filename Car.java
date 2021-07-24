import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image1,image2;
    int xSpeed;
    Car(){
        image1=new GreenfootImage("images/car01.png");
        image2=new GreenfootImage("images/car03.png");
        xSpeed=1+Greenfoot.getRandomNumber(4);
    }
    
    public void moveCar(){
        setLocation(getX()+xSpeed,getY());
        if(getX()>MyWorld.width-10 || getX()<10){
            xSpeed*=-1;
            setLocation(getX(),Greenfoot.getRandomNumber(MyWorld.height));
            if(getImage()==image1)
                setImage(image2);
            else
                setImage(image1);
        }
    }

    public void act()
    {
        detectAndRemoveEater();
        moveCar();
    }
    
    public void detectAndRemoveEater(){
        Actor eaterTouched=getOneObjectAtOffset(0,0,Eater.class);
        if(eaterTouched!=null){
            if(Eater.lives>=1){
                Eater.lives--;
                getWorld().removeObject(eaterTouched);
                getWorld().addObject(new Eater(),MyWorld.width/2,MyWorld.height-20);
            }
            if(Eater.lives==0){
                Greenfoot.setWorld(new MyWorld());
                Eater.lives=10;
                Eater.level=0;
            }
        }
    }

    
}
