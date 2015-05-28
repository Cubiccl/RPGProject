package main.graphics.textures;

import java.awt.image.BufferedImage;

public enum Sprite {

	black("/textures/tiles/black.png"),
	grass("/textures/tiles/grass1.png"),
	rock1("/textures/tiles/rock1.png"),
	rock2("/textures/tiles/rock2.png"),
	playerDown("/textures/entity/player/charF.png"),
	playerUp("/textures/entity/player/charB.png"),
	playerLeft("/textures/entity/player/charL.png"),
	playerRight("/textures/entity/player/charR.png");
	
	public static final int DOWN = 0, UP = 1, LEFT = 2, RIGHT = 3;

	private BufferedImage img;

	private Sprite(String path) {
		this.img = ImageLoader.load(path);
	}

	public BufferedImage getSprite() {
		return this.img;
	}

}
