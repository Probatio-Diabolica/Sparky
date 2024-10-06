package com.SPARKY.sparky.Stage;

import java.util.ArrayList;
import java.util.List;

import com.SPARKY.sparky.Entity.Entity;
import com.SPARKY.sparky.Entity.Particle.Particle;
import com.SPARKY.sparky.Entity.Projectiles.Projectile;
import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Stage.Tile.Tile;


/* 
!! this class will be our base class and other level will inherit it
-> this is going to be a template for our levels. it's content will be empty. But, shall be overridden by the derived classes.
*/ 
public class BaseLevel {
	//protected  Tile[] tiles ;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> shots = new ArrayList<Projectile>();
	private List<Particle> particle = new ArrayList<Particle>();
    
	protected int width,height,tile_size ;
	protected int[] tileBL;
	protected int[] tiles;//this array will contain the color value of a level
	
	//public static BaseLevel home = new Home("Resources/Textures/Stages/stageOneChoiceAAA.png"); 
	public static BaseLevel home = new Home("Resources/Textures/Stages/stageDemo.png"); 

	public BaseLevel(int height,int width){
		this.height=height;
		this.width=width;
		tileBL=new int[height*width]; //Error probability high
		genStage();
	}
	
	public  BaseLevel(String path){
		loadLevel(path);
		genStage();
	}

	public List<Projectile> getbullets(){
		return shots;
	}

	/**
	 * @param XposForCollidingObject checks the Xposition of object
	 * @param YposForCollidingObject checks the Y position of the object
	 * @param objSize the tile size of an object
	 * @return true ;if object has collided with another object .else returns false false
	 */
	public boolean tileCollision(int XposForCollidingObject,int YposForCollidingObject,int objSize,int xOffset, int yOffset) {
		boolean object=false;
		
		for(int corner=0;corner<4;corner++){ //there are four corners of an object.
			int xt=(XposForCollidingObject-corner%2 * objSize+xOffset )>>4;
			int yt=(YposForCollidingObject-corner/2 *objSize+yOffset)>>4;
			if(getTile(xt,yt).solid()) object=true;
		}
		
		return object;
	}

	protected void loadLevel(String path) {
	}
	
	protected void genStage() {
		for(int y=0;y<200;y++){
			for(int x=0;x<100;x++){
				getTile(x, y);
			}
		}
		tile_size=16;
	}
	public void update(){
		// This will do the update in the level like bot actions, traps,NPCs,bosses,etc;
		for(int i=0;i<entities.size();i++){
			//it is calling the update method of entity class.
			entities.get(i).update(); // ->entities.get(i) is an object of entity class
		}
		for(int i=0;i<shots.size();i++){
			shots.get(i).update(); 
		}
		for(int i=0;i<particle.size();i++){
			particle.get(i).update(); 
		}
		remove();
	}
	public void render(int Xpos,int Ypos,Screen screen){
		
		screen.setOffset(Xpos, Ypos);
		// graphic rendering
//		X0, and x1 are the corner of the x axis
		int x0=Xpos>>4;// same as "Xpos/16" but shifting is faster than dividing
		int x1=(Xpos+screen.width + 16) >> 4;
		
		int y0=Ypos>>4;
		int y1=(Ypos+screen.height +  16)>>4;
		
		for(int y=y0;y<y1;y++) {
			for(int x=x0;x<x1;x++) {
				getTile(x,y).render(x,y,screen);
			}
		}

		for(int i=0;i<entities.size();i++){
			entities.get(i).render(screen);; 
		}
		for(int i=0;i<shots.size();i++){
			shots.get(i).render(screen);; 
		}
		for(int i=0;i<particle.size();i++){
			particle.get(i).render(screen);; 
		}
		
	}
		
	private void remove(){
		for(int i=0;i<entities.size();i++){
			if(entities.get(i).isRemoved()) entities.remove(i);
		}
		for(int i=0;i<shots.size();i++){
			if(shots.get(i).isRemoved()) shots.remove(i);
		}
		for(int i=0;i<particle.size();i++){
			if(particle.get(i).isRemoved()) particle.remove(i); 
		}
	}

	public void add(Entity e) {
		e.init(this);
		if(e instanceof Particle){
			particle.add((Particle)e); // it is ok to do that here because we have checked if ti same or not
		}else if(e instanceof Projectile){
			shots.add((Projectile) e);
		}
		else{
			entities.add(e);
		}
		
		
	}
	
	
	public Tile getTile(int x,int y) {
		if(x<0 || y<0 ||y>=height || x>=width) return Tile.voidTile;
		if(tiles[x+y*width]==Tile.grassColor)  return Tile.grass;
		if(tiles[x+y*width]==Tile.rockColor)  return Tile.rock;
		if(tiles[x+y*width]==Tile.flowerColor)  return Tile.flower;
		if(tiles[x+y*width]==Tile.podColor)  return Tile.pod;
		if(tiles[x+y*width]==Tile.seaColor) return Tile.sea;
		if(tiles[x+y*width]==Tile.PathwayColor) return Tile.pathway;
		//if(tiles[x+y*width]==0xff7C75FF)  return Tile.tree;
		//if(tiles[x+y*width]==0xff7F0000)  return Tile.tree; needs rest of the rendering
		//if((tiles[x+y*width]!=3)||(tiles[x+y*width]!=3)||(tiles[x+y*width]!=3)||(tiles[x+y*width]!=3)) return 
		
		
		return Tile.voidTile;
	}
}
