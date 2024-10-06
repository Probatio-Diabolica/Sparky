package com.SPARKY.sparky;


// Some Imports

import java.awt.Canvas;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


import javax.swing.JFrame;
import com.SPARKY.sparky.Entity.NPC.MC;
import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Stage.BaseLevel;
//import com.SPARKY.sparky.Stage.Home;
import com.SPARKY.sparky.Stage.TileC;
//import com.SPARKY.sparky.Stage.randomLevel;
import com.SPARKY.sparky.inputs.Input;
import com.SPARKY.sparky.inputs.Mouse;



//Canvas is a class which is extended while Runnable is an interface which is implemented
public class MAIN extends Canvas implements Runnable{
	
	//	This shall work as the versioning of the game :)
	private static final long serialVersionUID = 1L;
	
	
	// Screen size	
	private static int width=400;
	private static int height=width/16*9;//width/16*9;
    private static int scale=3;
    
    // Miscellaneous
    private MC player;
    private BaseLevel level;
    private Input key;
    

//    The Window of the game
    private Screen screen;
    private boolean running=false;
    private JFrame frame;
    public static String Title="Name this thing";
    
        
    
    //BufferImage and pixel array of the screen along with the thread 
    private Thread thread;
    private BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    private int[] pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    
    public static int getGameWidth() {
        return width*scale;
    }
    
    public static int getGameHeight() {
        return height*scale;
    }
    
//The constructor
    public MAIN(){    	
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);
        

        screen = new Screen(width, height);
        frame=new JFrame();
        key=new Input();
        level=BaseLevel.home;
        //level=new Home("Resources/Textures/Stages/stageOneChoiceAAA.png");
        //level=new randomLevel(64,64);
        TileC playerSpawn= new TileC(6,3);
        player = new MC(playerSpawn.x(),playerSpawn.y(),key);

        player.init(level);
        addKeyListener(key);        
        Mouse mouse=new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        //1920/1080; 960/540; 480/270;240/130;120/65;24/13
    
    }


    //* Synchronization in Java is the capability to control the access of multiple threads to any shared resource.
    //* Java Synchronization is better option where we want to allow only one thread to access the shared resource.
    /*
    The synchronization is mainly used to :
            * To prevent thread interference.
            * To prevent consistency problem.
    
    *   There are two types of synchronization

        *    Process Synchronization
        *    Thread Synchronization
    
    */
    
    
//public synchronized 
    public synchronized void begin(){
/*  
!!      Window is running in a synchronized manner. 
//      However ,in 50% of tests unsynchronized method gave better performance. 
->      One possibility could be that CPU now controls the access of the threads on the shared resources.
??      Maybe, it requires GPU to handle that  
*/
        running=true;
        thread=new Thread(this,"Screen"); //this=> new MAIN()
        thread.start();

    }


    public synchronized void stop(){
    	//Same thing with this too
        running=false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        /* 
        // this method has been implemented from Runnable interface
        // this method will make sure our screen thread keeps running
        */
        long lastTime=System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns=1000000000.0/60.0; //ns-> nanoSecond
        double delta=0;

        int frames=0; // Frames in a single second
        int updates=0; // the "updates" times the update() has been called in a second
        requestFocus(); //
        
        while(running){//-> while the window is running,i.e, window is on the screen/game is being played, do this.  
            //here we are going to implement the logic and graphical of the game like calculations for physics, events,processing,networking,rendering,etc 
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while (delta>=1) {
                update();//this method will do calculations regarding logic,functionality,etc. it will be restricted to run at 60/sec
                updates++;// for each time update is called. And it should be 60/sec
                delta--;
            }
            render();//this method will do the graphical rendering
            frames++; //this will show the no. of times the render() is called.
            
            if(System.currentTimeMillis()-timer > 1000){
                timer+=1000;
                frame.setTitle(Title +" | Fps :" + frames +" Ups : "+ updates);
                updates=0;

                frames=0;
            }
        }
        stop();
    }

    public void update(){
        key.update();
        player.update();
        level.update();
    }
    
    
    public void render(){
        // this method will handle rendering
        // this technique is known as buffer strategy
        /*
        !! IMPORTANT CONCEPT:
        -> a buffer generally refers to a temporary storage area used to hold data temporarily while it's being moved from one place to  
        -> another, such as between input/output devices, within a program, or between different processes.
         */
        BufferStrategy bs= getBufferStrategy();
        //since we will call render in the run() method, therefore we only need to create BufferStrategy only once. 
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        
        /*
        NOTE: WE ACTUALLY MOVED THE MAP SO THAT PLAYER IS IN THE CENTER
        
        
        !! For reference
        //int Xscroll=player.xPos - screen.width/2;
        //int Yscroll=player.yPos - screen.height/2;
        
         */
        level.render(player.xPos- screen.width/2, player.yPos- screen.height/2 ,screen);
        player.render(screen);
            
        for(int i=0;i<pixels.length;i++){
            pixels[i]=screen.pixel[i];
        }  
        Graphics g=bs.getDrawGraphics();//"g" is a link between our bufferStrategy and our rendering  
    
        /*
            ->All of our Graphic work will happen between 
            Graphics g=bs.getDrawGraphics(); and g.dispose();
         */
        g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
        
        //g.setColor(Color.WHITE);
        
        
        g.dispose(); //!! we are calling dispose here because our render() is in run() method. 
        //so at the end of the loop in the run, we need to remove our graphics and free system memory
        bs.show();
        //Makes the next available buffer visible by either copying the memory (blitting) or changing the display pointer (flipping).
    }



    public static void main(String[] Args){
        MAIN game = new MAIN();
        game.frame.setResizable(false);
        //!! this method fixes the resizability of a frame or a window. 
        
        game.frame.setTitle(MAIN.Title);
        game.frame.add(game); 
        //the reason why our class's instance is able to get passed on because our class extends Canvas making it the subclass of canvas
        
        game.frame.pack();// this method sets the size of the frame according to the value we have passed on it. 
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //it exits upon hitting the "X"/close button on the window.
        game.frame.setLocationRelativeTo(null);// it centers our window.
        game.frame.setVisible(true);

        game.begin();
        
    }
}
