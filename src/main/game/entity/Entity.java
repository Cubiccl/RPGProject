package main.game.entity;

import java.awt.Graphics;

import main.graphics.textures.Sprite;

public abstract class Entity {
	
	private float x;
	private float y;
	private Sprite sprite;
	
	public Entity (float x, float y, Sprite sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(this.sprite.getSprite(), (int) this.x, (int) this.y, 32, 48, null);
	}
}