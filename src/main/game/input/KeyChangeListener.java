package main.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.graphics.states.KeysState;

public class KeyChangeListener implements KeyListener {

  private KeysState state;
  private KeyCustom key;

  public KeyChangeListener(KeysState state, KeyCustom key) {
    this.state = state;
    this.key = key;
  }

  @Override
  public void keyPressed(KeyEvent event) {
    this.state.doKeyChange(key, event.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent arg0) {}

  @Override
  public void keyTyped(KeyEvent arg0) {}

}
