package main.game.entity.mob.player;

import java.awt.event.KeyEvent;

import main.RPGProject;
import main.game.entity.mob.Mob;
import main.graphics.textures.Sprite;

public class Player extends Mob {

	public Player(float x, float y) {
		super(5, 1.6f, x, y, Sprite.playerDown);
		this.setMovementSprites(Sprite.playerDown, Sprite.playerUp,
				Sprite.playerLeft, Sprite.playerRight);
	}

	@Override
	public void update() {
		super.update();
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_UP)) {
			this.yMotion = -1;
			if (RPGProject.getGame().getKeyManager()
					.isKeyPressedAbsolute(KeyEvent.VK_DOWN))
				this.yMotion = 0;
		} else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_DOWN))
			this.yMotion = 1;

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_RIGHT)) {
			this.xMotion = 1;
			if (RPGProject.getGame().getKeyManager()
					.isKeyPressedAbsolute(KeyEvent.VK_LEFT))
				this.xMotion = 0;
		} else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_LEFT))
			this.xMotion = -1;

	}
}
