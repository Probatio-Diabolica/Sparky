package com.SPARKY.sparky.Graphics;

public class Sprite {
	
	private int xC,yC,height,width;
	public final int SIZE;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite voidSprite=new Sprite(16,16,0xf76902);
	
	//Flora Sprites
	public static Sprite flower= new Sprite(16,0,0,SpriteSheet.primitiveTile);
	public static Sprite grassb= new Sprite(16,1,0,SpriteSheet.primitiveTile);
	public static Sprite pod= new Sprite(16,2,0,SpriteSheet.primitiveTile);
	public static Sprite rock= new Sprite(16,3,0,SpriteSheet.primitiveTile);
	public static Sprite sea=new Sprite(16,0,1,SpriteSheet.primitiveTile);
	public static Sprite pathway= new Sprite(16,1,1,SpriteSheet.primitiveTile);
	/* 
	public static Sprite treeOO = new Sprite(16,0,12,SpriteSheet.Grassland);
	public static Sprite treeO1 = new Sprite(16,1,12,SpriteSheet.Grassland);
	public static Sprite treeO2 = new Sprite(16,2,12,SpriteSheet.Grassland);
	public static Sprite treeO3 = new Sprite(16,3,12,SpriteSheet.Grassland);

	public static Sprite tree1O = new Sprite(16,0,13,SpriteSheet.Grassland);
	public static Sprite tree11 = new Sprite(16,1,13,SpriteSheet.Grassland);
	public static Sprite tree12 = new Sprite(16,2,13,SpriteSheet.Grassland);
	public static Sprite tree13 = new Sprite(16,3,13,SpriteSheet.Grassland);

	public static Sprite tree2O = new Sprite(16,0,14,SpriteSheet.Grassland);
	public static Sprite tree21 = new Sprite(16,1,14,SpriteSheet.Grassland);
	public static Sprite tree22 = new Sprite(16,2,14,SpriteSheet.Grassland);
	public static Sprite tree23 = new Sprite(16,3,14,SpriteSheet.Grassland);

	public static Sprite tree3O = new Sprite(16,0,15,SpriteSheet.Grassland);
	public static Sprite tree31 = new Sprite(16,1,15,SpriteSheet.Grassland);
	public static Sprite tree32 = new Sprite(16,2,15,SpriteSheet.Grassland);
	public static Sprite tree33 = new Sprite(16,3,15,SpriteSheet.Grassland);
	!! end of tree 
	*/

	
	
//	public static Sprite player0=new Sprite(16,0,10,SpriteSheet.tile);
//	public static Sprite player1=new Sprite(16,1,10,SpriteSheet.tile);
//	public static Sprite player2=new Sprite(16,0,11,SpriteSheet.tile);
//	public static Sprite player3=new Sprite(16,1,11,SpriteSheet.tile);
	
	//player going up
	// public static Sprite playerUP_stand=new Sprite(32,0,5,SpriteSheet.primitiveTile);
	// public static Sprite playerUPOne=new Sprite(32,0,6,SpriteSheet.primitiveTile);
	// public static Sprite playerUPTwo=new Sprite(32,0,7,SpriteSheet.primitiveTile);
	public static Sprite playerUP_stand=new Sprite(32,0,1,SpriteSheet.PlayerTest);
	public static Sprite playerUPOne=new Sprite(32,1,1,SpriteSheet.PlayerTest);
	public static Sprite playerUPTwo=new Sprite(32,2,1,SpriteSheet.PlayerTest);
	
	//player going DOWN
	public static Sprite playerDOWN_stand =new Sprite(32,0,0,SpriteSheet.PlayerTest);
	public static Sprite playerDOWNOne	  =new Sprite(32,1,0,SpriteSheet.PlayerTest);
	public static Sprite playerDOWNTwo	  =new Sprite(32,2,0,SpriteSheet.PlayerTest);
	
	//player going LEFT
	public static Sprite playerLeft	  =	new Sprite(32,0,2,SpriteSheet.PlayerTest);
	public static Sprite playerLeftOne=	new Sprite(32,1,2,SpriteSheet.PlayerTest);
	public static Sprite playerLeftTwo=	new Sprite(32,2,2,SpriteSheet.PlayerTest);
	
	//player going right
	public static Sprite playerRight	= new Sprite(32,0,3,SpriteSheet.PlayerTest);
	public static Sprite playerRightOne = new Sprite(32,1,3,SpriteSheet.PlayerTest);
	public static Sprite playerRightTwo = new Sprite(32,2,3,SpriteSheet.PlayerTest);
	
//Bullets
	public static Sprite normalBull=new Sprite(16,0,0,SpriteSheet.bullet);
	public static Sprite normalBullB=new Sprite(16,1,0,SpriteSheet.bullet);

// Particles
	public static Sprite particle = new Sprite(1, 0xff0000);


	public Sprite(int tileSqSize,int x, int y, SpriteSheet sheet) {	
		// For squares
		SIZE=tileSqSize;
		this.height=this.width=tileSqSize;
		pixels=new int[SIZE*SIZE];
		this.xC=x*tileSqSize;
		this.yC=y*tileSqSize;
		this.sheet=sheet;
		load();
	
	}

	public Sprite(int width,int height,int color){
		this.height=height;
		this.width=width;
		SIZE=-1;
		pixels=new int[width*height];
		setColor(color);
	}
	
	
	public Sprite(int size,int color) {
		// For non-Sprites
		SIZE=size;
		this.height=size;
		this.width=size;
		pixels=new int[SIZE*SIZE];
		setColor(color);
	}

	public int getWidth(){
		return width;
	}


	public int getHeight(){
		return height;
	}
	
	private void setColor(int color) {
		for(int i=0;i<height*width;i++) {
			pixels[i]=color;
		}
	}

	private void load() {
			for(int yXX=0;yXX<SIZE;yXX++) {
				for(int xXX=0;xXX<SIZE;xXX++) {
					pixels[xXX+yXX*SIZE]=sheet.pixels[(xXX+this.xC)+(yXX+this.yC)*sheet.SIZE];
				}

			}
	}
}
