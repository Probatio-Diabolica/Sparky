package com.SPARKY.sparky.Graphics;

import java.util.Random;

import com.SPARKY.sparky.Entity.Projectiles.Projectile;
import com.SPARKY.sparky.Stage.Tile.Tile;
public class Screen {
    //private Random random=new Random();
    private int xOffset,yOffset;
    // -> mapArea == sq(noOfTiles) or size * size
    //private final int mapSize=64;
   // private int mapArea=mapSize*mapSize;
    //private int[] tiles=new int[mapArea];

    public int width,height;
    public int[] pixel;
    //private final int mapMaskSize=mapSize-1;
    
    

    
    public void setOffset(int x,int y) {
        this.xOffset=x;
        this.yOffset=y;
    }

    public Screen(int width,int height){
        this.width=width;
        this.height=height;
        pixel=new int[width*height];
        
    }
    public void clear(){
        for(int i=0;i<pixel.length;i++){
            pixel[i]=0x000000;
        }
    }

    public void renderSprite(int xp,int yp,Sprite sprite,boolean fixedOnMap){
        if(fixedOnMap){
            xp-=xOffset;
            yp-=yOffset;
        }
        for(int y=0;y<sprite.getHeight();y++){
            int ya=y+yp;
            for(int x=0;x<sprite.getWidth();x++){
                int xa=x+xp;
                if(xa<0 || xa >=width || ya < 0 || ya>=height) continue; //out of bound from the map or screen, in that case we don't want to render that.
                pixel[xa+ya*width]=sprite.pixels[x+y*sprite.getWidth()];
            }
        }
    }

    public void renderTile(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
			for (int y = 0; y < sprite.SIZE; y++){
				int ya = y + yp;
				for (int x = 0; x <sprite.SIZE; x++){
					int xa = x + xp;
					if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height ) break;
					if (xa < 0) xa = 0;
					pixel[xa + ya * width] = sprite.pixels[x + y * 16];
				}
			}
		}
    
    public void renderTile16(int xp,int yp, Tile tile){
        xp-=xOffset;
        yp-=yOffset;
    	// We want to render individual tile not sprite, because each will be easy to do animations rather than a sprite
        for(int y=0;y<tile.sprite.SIZE;y++){
            int ya=y+yp;
            for(int x=0;x<tile.sprite.SIZE;x++) {
                int xa=x+xp;
                
                //line below will load what is on the screen , not the entire map
                if(xa<-tile.sprite.SIZE || xa>=width || ya<0 ||ya>=height) break;
                if(xa<0) xa=0;
                pixel[xa+ya*width]=tile.sprite.pixels[x+y*tile.sprite.SIZE];
            }
        }
    }

    public void renderTile32(int xp,int yp, Tile tile){
        xp-=xOffset;
        yp-=yOffset;
    	// We want to render individual tile not sprite, because each will be easy to do animations rather than a sprite
        for(int y=0;y<tile.sprite.SIZE;y++){
            int ya=y+yp;
            for(int x=0;x<tile.sprite.SIZE;x++) {
                int xa=x+xp;
                
                //line below will load what is on the screen , not the entire map
                if(xa<-tile.sprite.SIZE || xa>=width || ya<0 ||ya>=height) break;
                if(xa<0) xa=0;
                pixel[xa+ya*width]=tile.sprite.pixels[x+y*tile.sprite.SIZE];
            }
        }
    }
    
    public void renderBullet(int xp, int yp, Projectile p){
		xp -= xOffset;
		yp -= yOffset;
        for (int y = 0; y < p.getSpriteSize(); y++){
            int ya = y + yp;
            for (int x = 0; x <p.getSpriteSize(); x++){
                int xa = x + xp;
                if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height ) break;
                if (xa < 0) xa = 0;
                int col=p.getSprite().pixels[x + y * p.getSpriteSize()];
                if(col!=0xffff00ff) pixel[xa + ya * width] = col;					
            }
        }
	}

    public void renderPlayer(int xp, int yp,Sprite sprite) {
        xp-=xOffset;
        yp-=yOffset;
    	// We want to render individual tile not sprite, because each will be easy to do animation s rather than a sprite
        for(int y=0;y<32;y++){
            int ya=y+yp;
            for(int x=0;x<32;x++) {
                int xa=x+xp;
                
                //line below will load what is on the screen , not the entire map
                if(xa<-32 || xa>=width || ya<0 ||ya>=height) break;
                if(xa<0) xa=0;
                
                int col=sprite.pixels[x+y*32];
                if(col!=0xffff00ff) pixel[xa+ya*width]=col;
            }
        }

    }
}
