package com.SPARKY.sparky.Entity.Projectiles;

import com.SPARKY.sparky.Entity.Entity;
import com.SPARKY.sparky.Graphics.Sprite;





// ->Double is more accurate than float which is more accurate than int

public abstract class Projectile extends Entity {
	protected final int spawnX,spawnY;
	protected double angle,ny,nx,distance;
	protected Sprite sprite;
	protected double speed,damage,range,xPos,yPos;
	
	public Projectile(int x,int y,double dir) {
		this.spawnX = x;
		this.spawnY = y;
		angle=dir;
		this.xPos=x;
		this.yPos=y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}
	protected void move() {
		
	}
}
