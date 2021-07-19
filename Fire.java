import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        detectAndRemoveCar();
        shoot();
    }
    
    public void shoot(){
        setLocation(getX(),getY()-10);
        if(getY()<2){
            getWorld().removeObject(this);
        }
    }
    
    public void detectAndRemoveCar(){
        Actor carTouched=getOneObjectAtOffset(0,0,Car.class);
        if(carTouched!=null){
            getWorld().removeObject(carTouched);
            Eater.score+=2;
            if(MyWorld.nbCarsShot<5)
                MyWorld.nbCarsShot+=1;
            else{
                for(int i=0;i<MyWorld.nbCarsShot;i++)
                    getWorld().addObject(new Car(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-20));
                    MyWorld.nbCarsShot=0;
                }
        }
    }
    
}
