package main.graphics.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import main.RPGProject;
import main.game.input.KeyChangeListener;
import main.game.input.KeyCustom;

public class KeysState extends MenuState {

  private boolean isChoosingKey;
  private KeyChangeListener listener;

  public KeysState() {

    this.isChoosingKey = false;

    this.addButton(new MSButton("Up : " + KeyEvent.getKeyText(KeyCustom.up.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.up);
      }
    });

    this.addButton(new MSButton("Down : " + KeyEvent.getKeyText(KeyCustom.down.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.down);
      }
    });

    this.addButton(new MSButton("Left : " + KeyEvent.getKeyText(KeyCustom.left.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.left);
      }
    });

    this.addButton(new MSButton("Right : " + KeyEvent.getKeyText(KeyCustom.right.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.right);
      }
    });

    this.addButton(new MSButton("Confirm : " + KeyEvent.getKeyText(KeyCustom.enter.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.enter);
      }
    });

    this.addButton(new MSButton("Cancel : " + KeyEvent.getKeyText(KeyCustom.escape.getKeyCode())) {
      @Override
      public void onClick() {
        prepareKeyChange(KeyCustom.escape);
      }
    });

    this.addButton(new MSButton("Back") {

      @Override
      public void onClick() {
        RPGProject.getGame().setState(StateManager.MENU);
      }
    });
  }

  private void prepareKeyChange(KeyCustom key) {
    this.isChoosingKey = true;
    this.listener = new KeyChangeListener(this, key);
    RPGProject.getGame().getKeyManager().setEnabled(false);
    RPGProject.getWindow().addKeyListener(this.listener);
  }

  public void doKeyChange(KeyCustom key, int newKeyCode) {
    RPGProject.getWindow().removeKeyListener(this.listener);
    this.listener = null;
    key.setKeyCode(newKeyCode);

    this.updateButtons();
    this.isChoosingKey = false;
    RPGProject.getGame().getKeyManager().setEnabled(true);
  }

  private void updateButtons() {
    String[] names = new String[6];
    names[0] = "Up : " + KeyEvent.getKeyText(KeyCustom.up.getKeyCode());
    names[1] = "Down : " + KeyEvent.getKeyText(KeyCustom.down.getKeyCode());
    names[2] = "Left : " + KeyEvent.getKeyText(KeyCustom.left.getKeyCode());
    names[3] = "Right : " + KeyEvent.getKeyText(KeyCustom.right.getKeyCode());
    names[4] = "Confirm : " + KeyEvent.getKeyText(KeyCustom.enter.getKeyCode());
    names[5] = "Escape : " + KeyEvent.getKeyText(KeyCustom.escape.getKeyCode());

    ArrayList<MSButton> buttons = this.getButtons();
    for (int i = 0; i < buttons.size() && i < 6; i++) {
      buttons.get(i).setText(names[i]);
    }
  }

  @Override
  public void update() {
    if (this.isChoosingKey)
      return;

    if (RPGProject.getGame().getKeyManager().isKeyPressedInstant(KeyCustom.escape.getKeyCode()))
      RPGProject.getGame().setState(StateManager.MENU);
    super.update();
  }

  @Override
  public void render(Graphics g) {
    super.render(g);
    if (!this.isChoosingKey)
      return;

    int width = RPGProject.getWindow().getWidth();
    int height = RPGProject.getWindow().getHeight();
    Font font = g.getFont();

    g.setColor(new Color(0, 0, 0, 200));
    g.fillRect(0, 0, width, height);

    g.setColor(Color.GREEN);
    g.setFont(font.deriveFont(font.getSize() * 1.4F));
    g.drawString("Type your new key",
        width / 2 - g.getFontMetrics().stringWidth("Type your new key") / 2, height / 2 - height
            / 16);
    g.setFont(font);

  }

}
