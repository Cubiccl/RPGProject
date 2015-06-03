package main.graphics.textures;

import java.awt.image.BufferedImage;

import main.game.terrain.tile.Tile;

public enum SpriteSheet {

	liquids("/textures/tileset/TileA1.png", 32, 24),
	outside("/textures/tileset/TileA2.png", 32, 24),
	ceiling("/textures/tileset/TileA3.png", 32, 16),
	grounds("/textures/tileset/TileA4.png", 32, 30),
	grounds2("/textures/tileset/TileA5.png", 16, 32),
	city("/textures/tileset/TileB.png", 32, 32),
	indoor("/textures/tileset/TileC.png", 32, 32),
	dungeon("/textures/tileset/TileD.png", 32, 32);

	private BufferedImage img;
	private Sprite[][] sprites;

	private int width, height;

	private SpriteSheet(String path, int width, int height) {
		this.img = ImageLoader.load(path);
		this.width = width;
		this.height = height;
		this.sprites = new Sprite[this.width][this.height];

		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.sprites[x][y] = new Sprite(this, x, y);
			}
		}
	}

	public BufferedImage cut(int x, int y) {
		return this.img.getSubimage(x * Tile.WIDTH, y * Tile.HEIGHT,
				Tile.WIDTH, Tile.HEIGHT);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public static void init() {
		System.out.println("Sprites initialized");
	}

}
