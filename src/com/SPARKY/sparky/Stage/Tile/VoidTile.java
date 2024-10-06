package com.SPARKY.sparky.Stage.Tile;

import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);

	}
	public void render(int x, int y, Screen screen) {
		screen.renderTile16(x<<4, y<<4, this);
	}
	
}
