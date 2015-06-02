package main.game.entity.mob;

import main.Utils;
import main.game.entity.Entity;
import main.game.terrain.Map;
import main.graphics.textures.Animation;

public class Mob extends Entity {

	private int health;
	private int facing;
	private float speed;
	private float speedController;
	protected float xMotion;
	protected float yMotion;
	private Animation[] movementSprites, standingSprites;

	public Mob(int health, float speed, float x, float y, Animation animation) {
		super(x, y, animation);
		this.health = health;
		this.speed = speed;

		this.facing = Utils.DOWN;
		this.speedController = 1.0f;
		this.xMotion = 0;
		this.yMotion = 0;
		this.movementSprites = new Animation[] { animation, animation,
				animation, animation };
		this.standingSprites = new Animation[] { animation, animation,
				animation, animation };
	}

	public void setMovementAnimations(Animation downSprite, Animation upSprite,
			Animation leftSprite, Animation rightSprite) {
		this.movementSprites[Utils.DOWN] = downSprite;
		this.movementSprites[Utils.UP] = upSprite;
		this.movementSprites[Utils.LEFT] = leftSprite;
		this.movementSprites[Utils.RIGHT] = rightSprite;
	}

	public void setStandingAnimations(Animation downSprite, Animation upSprite,
			Animation leftSprite, Animation rightSprite) {
		this.standingSprites[Utils.DOWN] = downSprite;
		this.standingSprites[Utils.UP] = upSprite;
		this.standingSprites[Utils.LEFT] = leftSprite;
		this.standingSprites[Utils.RIGHT] = rightSprite;
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

		if (this.yMotion > 0) {
			this.yMotion -= slow;
			if (this.yMotion < 0)
				this.yMotion = 0;
			this.facing = Utils.DOWN;
		}

		if (this.xMotion < 0) {
			this.xMotion += slow;
			if (this.xMotion > 0)
				this.xMotion = 0;
			this.facing = Utils.LEFT;
		}

		if (this.xMotion > 0) {
			this.xMotion -= slow;
			if (this.xMotion < 0)
				this.xMotion = 0;
			this.facing = Utils.RIGHT;
		}

		if (this.yMotion < 0) {
			this.yMotion += slow;
			if (this.yMotion > 0)
				this.yMotion = 0;
			this.facing = Utils.UP;
		}

		this.manageSprites();
	}

	private void manageSprites() {

		if (this.xMotion == 0 && this.yMotion == 0) {
			this.standingSprites[this.facing].update();
			this.setAnimation(this.standingSprites[this.facing]);
		} else {
			this.movementSprites[this.facing].update();
			this.setAnimation(this.movementSprites[this.facing]);
		}
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
