package com.SPARKY.sparky.Entity.NPC;

import com.SPARKY.sparky.Entity.Entity;
import com.SPARKY.sparky.Graphics.Sprite;
import com.SPARKY.sparky.Entity.Projectiles.Projectile;
import com.SPARKY.sparky.Entity.Projectiles.RedStarBullet;
import com.SPARKY.sparky.Entity.Projectiles.PurpleStarBullet;

public abstract class mob extends Entity{
	protected Sprite sprite;
	protected String dir="LookinAtYou";	// directon
	protected boolean moving=false;
	protected int redStarBullSpd=1;
	protected int purpleStarBullSpd=1;
	//protected BaseMultiResolutionImage;
	
	
	//protected List<Projectile> shots=new ArrayList<Projectile>();
	
	public void move(int xP,int yP) {
		//System.out.println(level.getbullets().size());
		if(xP!=0 && yP != 0) {
			move(xP,0);
			move(0,yP);
			return;
		}
		
		if(xP>0) dir="EAST"	;
		if(xP<0) dir="WEST";
		if(yP>0) dir="SOUTH";
		if(yP<0) dir="NORTH";
		if(!collision(xP,yP)) {
			xPos+=xP;
			yPos+=yP;
		}	
		
	}
	
	public void update() {
		
	}
	protected void shoot(int x, int y,double dir){
			//dir*=(180/Math.PI);
		Projectile p = new PurpleStarBullet(x,y,dir,purpleStarBullSpd);
		level.add(p);

		Projectile pOppo = new RedStarBullet(x,y,dir,redStarBullSpd);
		level.add(pOppo);
			//System.out.println("Angle of shooting = "+dir+"\n");
	}

	private boolean collision(int xP,int yP) {
		boolean object=false;
		for(int corner=0;corner<4;corner++){
			int xt=((xP+xPos)+corner/2*10 -4)>>4;
			int yt=((yP+yPos)+corner*2+9)>>4;
			if(level.getTile(xt,yt).solid()) object=true;
		}
		
		return object;
	}
	
	public void render() {
	
	}
}
