package main.graphics.textures;

import java.awt.image.BufferedImage;

public class Animation {

	public static final int DEFAULT_SPEED = 10;
	
	private int speed, currentTick, index;
	private Sprite[] sprites;

	public Animation(Sprite... sprites) {
		this(DEFAULT_SPEED, sprites);
	}

	public Animation(int speed, Sprite... sprites) {
		this.speed = speed;
		this.sprites = sprites;

		this.currentTick = 0;
		this.index = 0;
	}

	public void update() {
		this.currentTick++;
		if (this.currentTick >= speed) {
			this.currentTick = 0;
			this.index++;
			if (this.index >= this.sprites.length)
				this.index = 0;
		}
	}

	/** Returns the current sprite to display */
	public BufferedImage getSprite() {
		return this.sprites[this.index].getSprite();
	}

}
