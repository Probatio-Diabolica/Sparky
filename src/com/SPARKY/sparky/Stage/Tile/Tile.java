package com.SPARKY.sparky.Stage.Tile;

import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;
//import com.SPARKY.sparky.Graphics.SpriteSheet;

public class Tile {
	//public static boolean solidity; 
	public int x,y;
	public Sprite sprite;
	//!! Identifiers:
	public final static int grassColor=0xff21FF33; 
	public final static int flowerColor=0xffE70000;
	public final static int podColor=0xff7F0000;
	public final static int rockColor=0xffBE796D;
	public final static int playerSpawnPoint=0xff000000;
	public final static int seaColor=0xff00C3FF;
	public final static int PathwayColor=0xffFFD800;
	// public final static int grassColor=0xff16FF45;


	// task: Flora
	public static Tile flower= new Flora(Sprite.flower);
	public static Tile grass= new Flora(Sprite.grassb);
	public static Tile pod= new Flora(Sprite.pod);
	public static Tile rock= new Flora(Sprite.rock);
	public static Tile voidTile=new VoidTile(Sprite.voidSprite);
	

	//task: Grassland
	public static Tile pathway=new Flora(Sprite.pathway);
	/*
	public static Tile tree00 = new Grassland(Sprite.treeOO);
	public static Tile tree01 = new Grassland(Sprite.treeO1);
	public static Tile tree02 = new Grassland(Sprite.treeO2);
	public static Tile tree03 = new Grassland(Sprite.treeO3);
	public static Tile tree10 = new Grassland(Sprite.tree1O);
	public static Tile tree11 = new Grassland(Sprite.tree11);
	public static Tile tree12 = new Grassland(Sprite.tree12);
	public static Tile tree13 = new Grassland(Sprite.tree13);
	public static Tile tree20 = new Grassland(Sprite.tree2O);
	public static Tile tree21 = new Grassland(Sprite.tree21);
	public static Tile tree22 = new Grassland(Sprite.tree22);
	public static Tile tree23 = new Grassland(Sprite.tree23);
	public static Tile tree30 = new Grassland(Sprite.tree3O);
	public static Tile tree31 = new Grassland(Sprite.tree31);
	public static Tile tree32 = new Grassland(Sprite.tree32);
	public static Tile tree33 = new Grassland(Sprite.tree33);
	*/

	// task=> Desert

	// task=> WaterBodies
	public static Tile sea = new waterBodies(Sprite.sea);
	// task=> Nirvana
	// task=> City


	public Tile(Sprite sprite) {
		this.sprite=sprite;
	}

	
	public void render(int x,int y,Screen sc){

	}
	
	public boolean solid() {
		return false;
		
		/*
		-> Default false by nature	
		& This method will help us tell which tile is not crossable or untouchable
		 * 
		 * */
	}
}
