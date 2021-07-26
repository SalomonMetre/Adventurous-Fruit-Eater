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
    static int numberCars=5;
    static int numberFruits=5;
    static int nbCarsShot;
    static GreenfootSound carExplosionSound,eatSound,shootSound,aux,bg1,bg2,bg3,bg4;
    private GreenfootImage bgi_1,bgi_2,bgi_3,bgi_4;
    private long startTime;
    private long currentTimeVariation;
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
        nbCarsShot=0;
        initializeSounds();
        initializeImages();
        startTime=System.currentTimeMillis();
    }
    
    public void displayDetails(){
        this.showText("Score : "+Eater.score,50,30);
        this.showText("Level : "+Eater.level,300,30);
        this.showText("Lives : "+Eater.lives,550,30);
        this.showText("High Score : "+Eater.highScore,800,30);
    }
    
    public void initializeSounds(){
        carExplosionSound=new GreenfootSound("sounds/car_explosion.wav");
        eatSound=new GreenfootSound("sounds/eat.wav");
        shootSound=new GreenfootSound("sounds/shoot.wav");
        aux=new GreenfootSound("");
        bg1=new GreenfootSound("sounds/bg_sound.mp3");
        bg2=new GreenfootSound("sounds/bg_sound2.mp3");
        bg3=new GreenfootSound("sounds/bg_sound3.mp3");
        bg4=new GreenfootSound("sounds/bg_sound4.mp3");
    }
    
    public void initializeImages(){
        bgi_1=new GreenfootImage("images/bgi_1.jpg");
        bgi_2=new GreenfootImage("images/bgi_2.png");
        bgi_3=new GreenfootImage("images/bgi_3.jpg");
        bgi_4=new GreenfootImage("images/bgi_4.jpg");
    }
    
    public void regenerateCars(){
        if(nbCarsShot>=5){
            for(int i=0;i<MyWorld.nbCarsShot;i++)
                    addObject(new Car(),20+Greenfoot.getRandomNumber(MyWorld.width-40),Greenfoot.getRandomNumber(MyWorld.height-40));
            nbCarsShot=0;
        }
    }
    
    public void playBackgroundSounds(){
        bg1.play();
        bg2.play();
        bg3.play();
        bg4.play();
    }
    
    public void changeBackgroundImages(){
        currentTimeVariation=System.currentTimeMillis()-startTime;
        long variationInSecs=currentTimeVariation/1000;
        if(variationInSecs%60>=0 && variationInSecs%60<=15){
            setBackground(bgi_1);
            bg1.setVolume(100); bg2.setVolume(0); bg3.setVolume(0); bg4.setVolume(0);
        }
        else if(variationInSecs%60>15 && variationInSecs%60<=30){
            setBackground(bgi_2);
            bg1.setVolume(0); bg2.setVolume(100); bg3.setVolume(0); bg4.setVolume(0);
        }
        else if(variationInSecs%60>30 && variationInSecs%60<=45){
            setBackground(bgi_3);
            bg1.setVolume(0); bg2.setVolume(0); bg3.setVolume(100); bg4.setVolume(0);
        }
        else{
            setBackground(bgi_4);
            bg1.setVolume(0); bg2.setVolume(0); bg3.setVolume(0); bg4.setVolume(100);
        }
    }
    
    public void act(){
        displayDetails();
        regenerateCars();
        playBackgroundSounds();
        changeBackgroundImages();
    }
}
