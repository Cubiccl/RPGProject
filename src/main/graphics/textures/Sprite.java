package main.graphics.textures;

import java.awt.image.BufferedImage;

public enum Sprite {

	black("/textures/tiles/black.png"),
	grass("/textures/tiles/grass1.png"),
	rock1("/textures/tiles/rock1.png"),
	rock2("/textures/tiles/rock2.png"),
	player("/texture/entity/player/charF.png");

	private BufferedImage img;

	private Sprite(String path) {
		this.img = ImageLoader.load(path);
	}

	public BufferedImage getSprite() {
		return this.img;
	}

}
