package main.game.terrain.tile;

import java.awt.Graphics;

import main.graphics.textures.Sprite;

public class TileObject extends Tile {

	/** The foreground Sprite */
	private Sprite foreground;

	public TileObject(short id, Sprite background, Sprite foreground,
			boolean isSolid) {
		super(id, background, isSolid);
		this.foreground = foreground;
	}

	@Override
	public void renderAt(Graphics g, int x, int y) {
		super.renderAt(g, x, y);
		g.drawImage(this.foreground.getSprite(), x, y, WIDTH, HEIGHT, null);
	}

}
