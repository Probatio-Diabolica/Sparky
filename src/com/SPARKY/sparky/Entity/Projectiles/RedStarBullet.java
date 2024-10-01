package com.SPARKY.sparky.Entity.Projectiles;



import com.SPARKY.sparky.MAIN;
import com.SPARKY.sparky.Entity.Spawner.ParticleSpawner;
import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;


public class RedStarBullet extends Projectile {
	public static final int FIRERATE=10;
	
	public RedStarBullet(int x, int y, double dir,int spd) {
		super(x, y, dir);
		damage=20;
		range=MAIN.getGameWidth()/2;
		speed=spd*2;
		nx=speed*Math.cos(angle);
		ny=speed*Math.sin(angle);
		
		sprite=Sprite.normalBullB;
	}
	public void update() {
		if(level.tileCollision((int) (xPos+nx),(int)(yPos+ny),8,5,4)){
			level.add(new ParticleSpawner((int)xPos, (int)yPos, 0,40,level));

			remove();
			}
		move();	
	}
	protected void move() {
		xPos+=nx;
		yPos+=ny;
		
		if(calculateDistance()>range) {
			remove();
		}
		
	
	}

	private double calculateDistance() {
		double dist=0;
		
		//pythagoras theorem
		dist=Math.sqrt(Math.abs((spawnX-xPos)*(spawnX-xPos)+(spawnY-yPos)*(spawnY-yPos)));
		return dist;
	}
	public void render(Screen screen){
		screen.renderBullet((int)xPos-12, (int)yPos-2, this);
		//screen.renderTile(xPos, yPos, sprite);
	}


}
