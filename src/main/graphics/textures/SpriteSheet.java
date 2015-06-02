package main.graphics.textures;

import java.awt.image.BufferedImage;

import main.game.terrain.tile.Tile;

public enum SpriteSheet {

	liquids("/textures/tileset/TileA1.png"),
	outside("/textures/tileset/TileA2.png"),
	ceiling("/textures/tileset/TileA3.png"),
	grounds("/textures/tileset/TileA4.png"),
	grounds2("/textures/tileset/TileA5.png"),
	city("/textures/tileset/TileB.png"),
	indoor("/textures/tileset/TileC.png"),
	dungeon("/textures/tileset/TileD.png");

	private BufferedImage img;

	private SpriteSheet(String path) {
		this.img = ImageLoader.load(path);
	}

	public BufferedImage cut(int x, int y) {
		return this.img.getSubimage(x * Tile.WIDTH, y * Tile.HEIGHT,
				Tile.WIDTH, Tile.HEIGHT);
	}

}
