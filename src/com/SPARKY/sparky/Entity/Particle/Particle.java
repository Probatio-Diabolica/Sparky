package com.SPARKY.sparky.Entity.Particle;


import com.SPARKY.sparky.Entity.Entity;
import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;


// ableton
// https://drive.usercontent.google.com/download?id=1f9vmjkUS-_xwEcEWpb4nFBKTTfM23Lyc&export=download&authuser=0
/**
 *@apiNote Particle class extends entity class.
    * @param 
 */
public class Particle extends Entity{

    private Sprite sprite;
    private int ParticlelifeTime;
    private int shelfLife;
    protected double XrateOfMotion,YrateOfMotion,xPos,yPos,zPos,za;
    /**
     * @
     * @param x -> this will tell the positon of particle in the x axis.
     * @param y -> this will tell the position of particle in the y axis.
     * @param life -> this will indicate the amount of time a particle would stay on the screen.
     * @apiNote This constructor will initialize the particle properties 
     */ 
    
    public Particle(int x, int y,int life){
        // this.xPos=x;
        // this.yPos=y;
        this.xPos=x;
        this.yPos=y;
        this.shelfLife=life+(random.nextInt(20)-10);
        sprite=Sprite.particle; 
        this.XrateOfMotion=random.nextGaussian(); //the direction of particles in the x asis
        this.YrateOfMotion=random.nextGaussian(); //the direction of particles in the y asis
        this.zPos=2.0+random.nextFloat();
        
        
    }



    /**
     * @apiNote this updates the position of particles in the screen and removes the particles if they have lives long enough.
     */
    public void update(){
        ParticlelifeTime++;
        if(ParticlelifeTime>=7400) ParticlelifeTime=0;
        if(ParticlelifeTime>shelfLife) remove();
        this.za-=0.1;//we are making a curve
        if(zPos<0) {
            zPos=0;
            za*=-0.5;
            XrateOfMotion*=0.4;
            YrateOfMotion*=0.4;
        }

        move(xPos+XrateOfMotion,yPos+YrateOfMotion+zPos+za);

    }
    
    private void move(double x, double y) {
        if(Collision(x,y)){
            this.XrateOfMotion*= -0.5;
            this.YrateOfMotion*= -0.5;
            this.za*= -0.5;
        }
        this.xPos+=XrateOfMotion;
        this.yPos+=YrateOfMotion;
        this.zPos+=za;
    }

    	/**
	 * @param XposForCollidingObject checks the Xposition of object
	 * @param YposForCollidingObject checks the Y position of the object
	 * @param objSize the tile size of an object
	 * @return true ;if object has collided with another object .else returns false false
	 */
	public boolean Collision(double XposForCollidingObject,double YposForCollidingObject) {
		boolean object=false;
		
		for(int corner=0;corner<4;corner++){ //there are four corners of an object.
			double xt=(XposForCollidingObject-corner%2 * 16)/16;
			double yt=(YposForCollidingObject-corner/2 * 16)/16;
            int xtemp=(int)Math.ceil(xt);
            int ytemp=(int)Math.ceil(yt);
            if(corner%2==0)  xtemp=(int)Math.floor(xt);
            if(corner/2==0)  ytemp=(int)Math.floor(yt);
                
            
			if(level.getTile(xtemp,ytemp).solid()) object=true;
		}
		
		return object;
	}


    public void render(Screen screen){
        screen.renderSprite((int)xPos,(int)yPos-(int)zPos, sprite, true); //We cast them int now because we'll loose more data if we do them before

    }
}

