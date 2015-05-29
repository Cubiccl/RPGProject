package main.game.entity.mob.player;

import main.RPGProject;
import main.game.entity.mob.Mob;
import main.game.input.KeyCustom;
import main.graphics.textures.Sprite;

public class Player extends Mob {

	private Inventory inventory;
	
	public Player(float x, float y) {
		super(5, 1.6f, x, y, Sprite.playerDown);
		this.setMovementSprites(Sprite.playerDown, Sprite.playerUp,
				Sprite.playerLeft, Sprite.playerRight);
		this.inventory = new Inventory();
	}

	@Override
	public void update() {
		super.update();
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
