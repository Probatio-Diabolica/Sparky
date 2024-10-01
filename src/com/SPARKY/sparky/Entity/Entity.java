package com.SPARKY.sparky.Entity;

import java.util.Random;

import com.SPARKY.sparky.Graphics.Screen;
import com.SPARKY.sparky.Stage.BaseLevel;
/*
!!  An entity is an object {like in physical world which does not have a shape/visiblility yet has a mass} which does not have an sprite but will still get rendered 

=
*/
public abstract class Entity {
	public int xPos,yPos;
	private boolean removed=false;
	protected BaseLevel level;
	protected final Random random=new Random();
	public void update() {
		
	}
	public void render(Screen screen) {
		
	}
	public void remove() {
		// Removing the entity from level
		removed=true;
	}
	public boolean isRemoved(){
		return removed;
	}
	public void init(BaseLevel level) {
		this.level = level;
	}
}
