package com.SPARKY.sparky.Entity.Spawner;



import com.SPARKY.sparky.Entity.Entity;
import com.SPARKY.sparky.Stage.BaseLevel;

public class EntitySpawner extends Entity {
	//private List<Entity> entity = new ArrayList<Entity>();
	
	/**
	 * @apiNote Enum creates a variable with custom data type
	 * for example here's a custom data type Hearn. public enum Hearn{
		MOB, PARTICLE ;
	}
	* it is used as : Type type;
	 */
	public enum Type{
		MOB, PARTICLE ;
	}
	private Type type;
	public EntitySpawner(int x,int y,Type type, int amt,BaseLevel level){
		init(level);
		this.xPos=x;
		this.yPos=y;
		this.type=type;
	}
}
