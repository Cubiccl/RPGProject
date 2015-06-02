package main.graphics.textures;

import java.awt.image.BufferedImage;

public enum Sprite {

	black("/textures/tiles/black.png"),
	grass(SpriteSheet.outside, 1, 3),
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
	playerDown1("/textures/entity/player/playerD1.png"),
	playerDown2("/textures/entity/player/playerD2.png"),
	playerDown3("/textures/entity/player/playerD3.png"),
	playerUp1("/textures/entity/player/playerU1.png"),
	playerUp2("/textures/entity/player/playerU2.png"),
	playerUp3("/textures/entity/player/playerU3.png"),
	playerLeft1("/textures/entity/player/playerL1.png"),
	playerLeft2("/textures/entity/player/playerL2.png"),
	playerLeft3("/textures/entity/player/playerL3.png"),
	playerRight1("/textures/entity/player/playerR1.png"),
	playerRight2("/textures/entity/player/playerR2.png"),
	playerRight3("/textures/entity/player/playerR3.png");

	private BufferedImage img;

	private Sprite(String path) {
		this.img = ImageLoader.load(path);
	}

	private Sprite(SpriteSheet sheet, int x, int y) {
		this.img = sheet.cut(x, y);
	}

	public BufferedImage getSprite() {
		return this.img;
	}

}
