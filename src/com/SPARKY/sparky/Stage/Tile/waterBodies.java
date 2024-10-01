package com.SPARKY.sparky.Stage.Tile;

import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;

public class waterBodies extends Tile {
	public waterBodies(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile16(x<<4, y<<4, this);
	}
	
	public boolean solid() {
		return true;
		
		/*
		-> Default false by nature;
		
!! but here this time we will make it true because, you can't walk over water , I suppose.
		Unless you're Jesus ofc.
		
		 * 
		 * */
	}
	
}
