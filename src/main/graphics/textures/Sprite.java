package main.graphics.textures;

import java.awt.image.BufferedImage;

public enum Sprite {

	black("/textures/tiles/black.png"),
	grass("/textures/tiles/grass1.png"),
	rock1("/textures/tiles/rock1.png"),
	rock2("/textures/tiles/rock2.png"),
	cornerBL("/textures/tiles/cornerBL.png"),
	cornerBR("/textures/tiles/cornerBR.png"),
	cornerTL("/textures/tiles/cornerTL.png"),
	cornerTR("/textures/tiles/cornerTR.png"),
	edgeB("/textures/tiles/edgeB.png"),
	edgeL("/textures/tiles/edgeL.png"),
	edgeR("/textures/tiles/edgeR.png"),
	edgeT("/textures/tiles/edgeT.png"),
	playerDown("/textures/entity/player/playerD2.png"),
	playerUp("/textures/entity/player/playerU2.png"),
	playerLeft("/textures/entity/player/playerL2.png"),
	playerRight("/textures/entity/player/playerR2.png");
	
	public static final int DOWN = 0, UP = 1, LEFT = 2, RIGHT = 3;

	private BufferedImage img;

	private Sprite(String path) {
		this.img = ImageLoader.load(path);
	}

	public BufferedImage getSprite() {
		return this.img;
	}

}
