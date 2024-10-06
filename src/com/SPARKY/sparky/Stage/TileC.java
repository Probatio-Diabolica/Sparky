package com.SPARKY.sparky.Stage;

public class TileC {
	private int x=0,y=0;
	private final int Tile_Size=16;
	public TileC(int x,int y) {
		this.x=x*Tile_Size;
		this.y=y*Tile_Size;
	}
	public int x(){
		return this.x;
	}
	public int y(){
		return this.y;
	}

	public int[] corordinates(){
		int[] co=new int[2];
		co[0]=x();
		co[1]=y();
		return co;
	} 
}
