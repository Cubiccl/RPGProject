package main.game.input;

import java.awt.event.KeyEvent;

public enum KeyCustom {

  up(KeyEvent.VK_UP), down(KeyEvent.VK_DOWN), right(KeyEvent.VK_RIGHT), left(KeyEvent.VK_LEFT), enter(
      KeyEvent.VK_ENTER), escape(KeyEvent.VK_ESCAPE);

  private int keyCode;

  private KeyCustom(int keyCode) {
    this.keyCode = keyCode;
  }

  public void setKeyCode(int keyCode) {
    this.keyCode = keyCode;
  }

  public int getKeyCode() {
    return this.keyCode;
  }

  public String getKeyName() {
    return KeyEvent.getKeyText(this.keyCode);
  }

}
