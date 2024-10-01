package com.SPARKY.sparky.Stage.Tile;

import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;

public class Flora extends Tile{

	public Flora(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile16(x<<4, y<<4, this);
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
