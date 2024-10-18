package com.SPARKY.sparky.Entity.NPC;


import com.SPARKY.sparky.MAIN;
import com.SPARKY.sparky.Entity.Projectiles.Projectile;
//import com.SPARKY.sparky.Entity.Projectiles.PurpleStarBullet;
import com.SPARKY.sparky.Entity.Projectiles.RedStarBullet;
import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;
import com.SPARKY.sparky.inputs.Input;
import com.SPARKY.sparky.inputs.Mouse;

public class MC extends mob {
	//private int xP=0,yP=0;
	private Input input; 
	private Sprite sprite;
	private int anim=0; //->animataion of player
	private boolean movement=false;

	private int redFireRate=RedStarBullet.FIRERATE;
	//public int purpleFireRate=PurpleStarBullet.FIRERATE;
	public MC(Input input) {
// it will create an mc at a default position	
		this.input=input;
	}
	public MC(int x,int y,Input input) {
		//it will create an mc at a specific position
		this.xPos=x;
		this.yPos=y;
		this.input=input;
	}
	
	// will fix it later
	public void render(Screen screen) {
		int move=anim%35;
		if(dir=="NORTH"){
			sprite=Sprite.playerUP0;
			if(movement) {
				if(move<5) sprite=Sprite.playerUP1;
				else if(move<10) sprite=Sprite.playerUP2;
				else if(move<15) sprite =Sprite.playerUP3;
				else if(move<20) sprite =Sprite.playerUP4;
				else if(move<25) sprite =Sprite.playerUP5;
				else if(move<30) sprite =Sprite.playerUP6;
				else if(move<35) sprite =Sprite.playerUP7;
				
			}
		}
		if(dir=="SOUTH" || dir == "LookinAtYou"){
			sprite=Sprite.playerDOWN0;
			if(movement) {
				if(move<5) sprite=Sprite.playerDOWN1;
				else if(move<10) sprite=Sprite.playerDOWN2;
				else if(move<15) sprite =Sprite.playerDOWN3;
				else if(move<20) sprite =Sprite.playerDOWN4;
				else if(move<25) sprite =Sprite.playerDOWN5;
				else if(move<30) sprite =Sprite.playerDOWN6;
				else if(move<35) sprite =Sprite.playerDOWN7;
				
			}
			
		}
		if(dir=="EAST"){
			sprite=Sprite.playerRight0;
			if(movement) {
				if(move<5) sprite=Sprite.playerRight1;
				else if(move<10) sprite=Sprite.playerRight2;
				else if(move<15) sprite =Sprite.playerRight3;
				else if(move<20) sprite =Sprite.playerRight4;
				else if(move<25) sprite =Sprite.playerRight5;
				else if(move<30) sprite =Sprite.playerRight6;
				else if(move<35) sprite =Sprite.playerRight7;
			}

		}
		if(dir=="WEST"){
			sprite=Sprite.playerLeft0;
			if(movement) {
				if(move<5) sprite=Sprite.playerLeft1;
				else if(move<10) sprite=Sprite.playerLeft2;
				else if(move<15) sprite =Sprite.playerLeft3;
				else if(move<20) sprite =Sprite.playerLeft4;
				else if(move<25) sprite =Sprite.playerLeft5;
				else if(move<30) sprite =Sprite.playerLeft6;
				else if(move<35) sprite =Sprite.playerLeft7;
			}

		}
		
		screen.renderPlayer(xPos-16, yPos-16, sprite);
		
	}
	public void update() {
		if(redFireRate>0) redFireRate--;
		//if(purpleFireRate>0) purpleFireRate--;
		int xXX=0,yXX=0;
		if(anim<7500) anim++;else anim=0;
		if(input.up) yXX--;
		if(input.down) yXX++;
		if(input.left) xXX--;
		if(input.right) xXX++;
		if(xXX!=0 || yXX!=0) {
			move(xXX,yXX);
			movement=true;
		}else {
			movement=false;
		}
		clear();
		updateShooting();
		
	}
	private void clear() {
		for(int i=0;i<level.getbullets().size();i++){
			Projectile p = level.getbullets().get(i);
			if(p.isRemoved()) level.getbullets().remove(i);
		}
	}
	private void updateShooting() {
		int isLeftBtnPressed=0;
		isLeftBtnPressed=Mouse.getButton();
		if(isLeftBtnPressed==1 && (redFireRate<=0)) {
			double dX= Mouse.getX()-(MAIN.getGameWidth()/2);
			double dY= Mouse.getY()-(MAIN.getGameHeight()/2);
			double aimDir=Math.atan2(dY, dX);
			// try {
			// 	Thread.sleep(1);
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
			shoot(this.xPos, this.yPos, aimDir);
			redFireRate=RedStarBullet.FIRERATE;
			//Bgm.bulletSnd.playBgm();
			//System.out.println("shotting : "+aimDir);
			//isLeftBtnPressed=-1;
		}
	}
} //1:15:35


//  TODO: how about we aim with "W,S,A and D" instead of mouse
