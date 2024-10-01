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
	
	public void render(Screen screen) {
		if(dir=="NORTH"){
			sprite=Sprite.playerUP_stand;
			if(movement) {
				if(anim%20>10) {
					sprite=Sprite.playerUPOne;
					sprite=Sprite.playerUPTwo;
				}else {
				}
			}
		}
		if(dir=="SOUTH" || dir == "LookinAtYou"){
			sprite=Sprite.playerDOWN_stand;
			if(movement) {
				if(anim%20>10) {
					sprite=Sprite.playerDOWNOne;
				}else {
					sprite=Sprite.playerDOWNTwo;
				}
				
			}
			
		}
		if(dir=="EAST"){
			sprite=Sprite.playerRight;
			if(movement) {
				if(anim%20>10) {
					sprite=Sprite.playerRightOne;
				}else {
					sprite=Sprite.playerRightTwo;
				}
			}

		}
		if(dir=="WEST"){
			sprite=Sprite.playerLeft;
			if(movement) {
				if(anim%20>10) {
					sprite=Sprite.playerLeftOne;
				}else {
					sprite=Sprite.playerLeftTwo;
				}
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
