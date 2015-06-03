package main.graphics.states;

import main.RPGProject;

public class MainMenuState extends MenuState {

  public MainMenuState() {
    this.addButton(new MSButton("Start this awesome game !") {

      @Override
      public void onClick() {
        RPGProject.getGame().setState(StateManager.GAME);
      }
    });
    this.addButton(new MSButton("Customize Keys") {

      @Override
      public void onClick() {
        RPGProject.getGame().setState(StateManager.KEYS);
      }
    });

    this.addButton(new MSButton("Quit game") {

      @Override
      public void onClick() {
        System.exit(0);
      }
    });
  }

}
