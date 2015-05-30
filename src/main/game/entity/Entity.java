package main.game.entity;

import java.awt.Graphics;

import main.RPGProject;
import main.game.terrain.Map;
import main.graphics.textures.Sprite;

public abstract class Entity {

	public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;

	protected float x, y;
	private int width, height;
	private Sprite sprite;

	public Entity(float x, float y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
		this.sprite = sprite;
	}

	public void update(Map map) {
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(Graphics g) {
		g.drawImage(
				this.sprite.getSprite(),
				(int) (this.x - RPGProject.getWindow().getCamera().getXOffset()),
				(int) (this.y - RPGProject.getWindow().getCamera().getYOffset()),
				32, 32, null);
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}
}
