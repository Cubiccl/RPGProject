package main.game.entity.mob;

import java.awt.event.KeyEvent;

import main.RPGProject;
import main.graphics.textures.Sprite;

public class Player extends Mob {

	public Player(float x, float y) {
		super(5, 1.0f, x, y, Sprite.player);
	}

	@Override
	public void update() {
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_UP))
			setYMotion(-1);
		else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_DOWN))
			setYMotion(1);
		else
			setYMotion(0);
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_RIGHT))
			setXMotion(1);
		else if (RPGProject.getGame().getKeyManager()
				.isKeyPressedAbsolute(KeyEvent.VK_LEFT))
			setXMotion(-1);
		else
			setXMotion(0);

	}

}
