package main.game.input;

import java.awt.event.KeyEvent;

public enum KeyCustom {

	up(KeyEvent.VK_UP),
	down(KeyEvent.VK_DOWN),
	right(KeyEvent.VK_RIGHT),
	left(KeyEvent.VK_LEFT);

	private int keyCode;

	private KeyCustom(int keyCode) {
	}

	public void setKey(int keyCode) {
		this.keyCode = keyCode;
	}

	public int getKeyCode() {
		return this.keyCode;
	}
	
	public String getKeyName() {
		return KeyEvent.getKeyText(this.keyCode);
	}

}