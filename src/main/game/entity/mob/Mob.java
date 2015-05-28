package main.game.entity.mob;

import main.game.entity.Entity;
import main.graphics.textures.Sprite;

public class Mob extends Entity{
	
	private int health;
	private float speed;
	private float xMotion;
	private float yMotion;
		
	public Mob (int health, float speed, float x, float y, Sprite sprite){
		super(x, y, sprite);
		this.health = health;
		this.speed = speed;
		this.xMotion = 0;
		this.yMotion = 0;
	}
	
	public void setHealth(int health){
		if (health >= 0)
			this.health = health;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setXMotion(float xMotion){
		this.xMotion = xMotion;
	}
	
	public void setYMotion(float yMotion){
		this.xMotion = yMotion;
	}
	
	public void move(){
		
	}
	
}
