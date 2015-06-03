package main.graphics.states;

import main.RPGProject;
import main.game.input.KeyCustom;

public class KeysState extends MenuState {

  public KeysState() {
    this.addButton(new MSButton("Up : UP") {

      @Override
      public void onClick() {
        System.out.println("up");
      }
    });

    this.addButton(new MSButton("Back") {

      @Override
      public void onClick() {
        RPGProject.getGame().setState(StateManager.MENU);
      }
    });
  }

  public void update() {
    if (RPGProject.getGame().getKeyManager().isKeyPressedInstant(KeyCustom.escape.getKeyCode()))
      RPGProject.getGame().setState(StateManager.MENU);
    super.update();
  }

}
