package main.game.terrain.tile;

import java.awt.Graphics;

import main.graphics.textures.Animation;
import main.graphics.textures.Sprite;

public class TileObject extends Tile {

  /** The foreground Sprite */
  private Animation foreground;

  public TileObject(short id, Animation background, Animation foreground) {
    super(id, background);
    this.foreground = foreground;
  }

  public TileObject(short id, Sprite background, Sprite foreground) {
    this(id, new Animation(background), new Animation(foreground));
  }

  public void update() {
    super.update();
    this.foreground.update();
  }

  @Override
  public void renderAt(Graphics g, int x, int y) {
    super.renderAt(g, x, y);
    g.drawImage(this.foreground.getSprite(), x, y, WIDTH, HEIGHT, null);
  }

}
