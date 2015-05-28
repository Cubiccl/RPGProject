package main.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	/** True if the key is pressed */
	private boolean[] keyPressedAbsolute;
	/** True if the key has been pressed and not processed */
	private byte[] keyPressedInstant;

	public KeyInput() {
		this.keyPressedAbsolute = new boolean[256];
		this.keyPressedInstant = new byte[256];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.keyPressedAbsolute[e.getKeyCode()] = true;
		if (this.keyPressedInstant[e.getKeyCode()] == 0)
			this.keyPressedInstant[e.getKeyCode()] = 2;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.keyPressedAbsolute[e.getKeyCode()] = false;
		this.keyPressedInstant[e.getKeyCode()] = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Returns true if the key is pressed.
	 * 
	 * @param keyCode
	 *            - The code of the Key
	 */
	public boolean isKeyPressedAbsolute(int keyCode) {
		if (keyCode >= 0 && keyCode < 256)
			return this.keyPressedAbsolute[keyCode];
		return false;
	}

	/**
	 * Returns true if the key is pressed instantly. (Then sets it to false)
	 * 
	 * @param keyCode
	 *            - The code of the Key
	 */
	public boolean isKeyPressedInstant(int keyCode) {
		if (keyCode >= 0 && keyCode < 256) {
			boolean pressed = this.keyPressedInstant[keyCode] == 2;
			if (pressed)
				this.keyPressedInstant[keyCode] = 1;
			return pressed;
		}
		return false;
	}

}
