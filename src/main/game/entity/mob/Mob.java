package main.game.entity.mob;

import main.game.entity.Entity;
import main.game.terrain.Map;
import main.graphics.textures.Sprite;

public class Mob extends Entity {

	private int health;
	private float speed;
	private float speedController;
	protected float xMotion;
	protected float yMotion;
	private Sprite[] movementSprites;

	public Mob(int health, float speed, float x, float y, Sprite sprite) {
		super(x, y, sprite);
		this.health = health;
		this.speed = speed;
		this.speedController = 1.0f;
		this.xMotion = 0;
		this.yMotion = 0;
		this.movementSprites = new Sprite[] { sprite, sprite, sprite, sprite };
	}

	public void setMovementSprites(Sprite downSprite, Sprite upSprite,
			Sprite leftSprite, Sprite rightSprite) {
		this.movementSprites[Sprite.DOWN] = downSprite;
		this.movementSprites[Sprite.UP] = upSprite;
		this.movementSprites[Sprite.LEFT] = leftSprite;
		this.movementSprites[Sprite.RIGHT] = rightSprite;
	}

	@Override
	public void update(Map map) {
		super.update(map);
		this.manageMotion();
		this.controlSpeed();
		this.move();
	}

	private void controlSpeed() {
		if (this.xMotion != 0 && this.yMotion != 0)
			this.speedController = 0.75f;
		else
			this.speedController = 1.0f;
	}

	private void manageMotion() {
		float slow = 0.2f;

		if (this.xMotion < 0) {
			this.xMotion += slow;
			if (this.xMotion > 0)
				this.xMotion = 0;
		} else {
			this.xMotion -= slow;
			if (this.xMotion < 0)
				this.xMotion = 0;
		}

		if (this.yMotion < 0) {
			this.yMotion += slow;
			if (this.yMotion > 0)
				this.yMotion = 0;
		} else {
			this.yMotion -= slow;
			if (this.yMotion < 0)
				this.yMotion = 0;
		}

		if (this.yMotion < 0)
			this.setSprite(this.movementSprites[Sprite.UP]);
		else if (this.xMotion < 0)
			this.setSprite(this.movementSprites[Sprite.LEFT]);
		else if (this.xMotion > 0)
			this.setSprite(this.movementSprites[Sprite.RIGHT]);
		else if (this.yMotion > 0)
			this.setSprite(this.movementSprites[Sprite.DOWN]);
	}

	public void setHealth(int health) {
		if (health >= 0)
			this.health = health;
	}

	public int getHealth() {
		return this.health;
	}

	public void move() {
		this.x += this.xMotion * this.speed * this.speedController;
		this.y += this.yMotion * this.speed * this.speedController;
	}

}
