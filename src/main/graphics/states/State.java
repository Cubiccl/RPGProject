package main.graphics.states;

import java.awt.Graphics;

public abstract class State {

  /**
   * Called to draw the state onto the screen
   * 
   * @param g - The Graphics to use
   */
  public abstract void render(Graphics g);

  /** Called to update the game state */
  public abstract void update();

}
