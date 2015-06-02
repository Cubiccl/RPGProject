package main.game.terrain.tile;

import java.awt.Graphics;

import main.game.terrain.Tiles;
import main.graphics.textures.Animation;
import main.graphics.textures.Sprite;

public class Tile {

	public static final int WIDTH = 32, HEIGHT = 32;

	private short id;
	private Animation animation;
	private boolean isSolid;

	public Tile(short id, Animation animation, boolean isSolid) {
		this.id = id;
		this.animation = animation;
		this.isSolid = isSolid;

		Tiles.register(this);
	}

	public Tile(short id, Sprite sprite, boolean isSolid) {
		this(id, new Animation(sprite), isSolid);
	}

	/** Returns this Tile's ID */
	public short getId() {
		return this.id;
	}

	public void update() {
		this.animation.update();
	}

	/**
	 * Renders the Tile at the given coordinates
	 * 
	 * @param g
	 *            - The Graphics to use to render the Tile
	 * @param x
	 *            - The X coordinate
	 * @param y
	 *            - The Y coordinate
	 */
	public void renderAt(Graphics g, int x, int y) {
		g.drawImage(this.animation.getSprite(), x, y, WIDTH, HEIGHT, null);
	}

	public boolean isSolid() {
		return this.isSolid;
	}

}
