package main.game.entity.mob.player;

import main.RPGProject;
import main.game.entity.mob.Mob;
import main.game.input.KeyCustom;
import main.game.terrain.Map;
import main.graphics.textures.Sprite;

public class Player extends Mob {

	private static final float DEFAULT_SPEED = 10.0f;
	// TODO mettre une vitesse convenable
	private Inventory inventory;

	public Player(float x, float y) {
		super(5, DEFAULT_SPEED, x, y, Sprite.playerDown);

		this.setMovementSprites(Sprite.playerDown, Sprite.playerUp,
				Sprite.playerLeft, Sprite.playerRight);
		this.setSize(32, 48);

		this.inventory = new Inventory();
	}

	@Override
	public void update(Map map) {
		this.manageInput();
		super.update(map);
		RPGProject.getWindow().getCamera().centerOnEntity(this, map);
	}

	private void manageInput() {
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyCustom.up.getKeyCode())) {
			this.yMotion = -1;
			if (RPGProject.getGame().getKeyManager()
					.isKeyPressedAbsolute(KeyCustom.down.getKeyCode()))
				this.yMotion = 0;
		} else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyCustom.down.getKeyCode()))
			this.yMotion = 1;

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyCustom.right.getKeyCode())) {
			this.xMotion = 1;
			if (RPGProject.getGame().getKeyManager()
					.isKeyPressedAbsolute(KeyCustom.left.getKeyCode()))
				this.xMotion = 0;
		} else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyCustom.left.getKeyCode()))
			this.xMotion = -1;
	}
}
