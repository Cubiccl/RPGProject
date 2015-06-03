package main.graphics;

import main.game.entity.Entity;
import main.game.terrain.Map;
import main.game.terrain.tile.Tile;

public class GameCamera {

  private float xOffset, yOffset;

  public GameCamera() {
    this.xOffset = 0f;
    this.yOffset = 0f;
  }

  public void centerOnEntity(Entity entity, Map map) {
    this.xOffset = entity.getX() * Tile.WIDTH - Display.WIDTH / 2 + entity.getWidth() / 2;
    this.yOffset = entity.getY() * Tile.HEIGHT - Display.HEIGHT / 2 + entity.getHeight() / 2;

    float xMax = map.getSize() * Tile.WIDTH - Display.WIDTH;
    float yMax = map.getSize() * Tile.HEIGHT - Display.HEIGHT;
    if (this.xOffset > xMax)
      this.xOffset = xMax;
    if (this.yOffset > yMax)
      this.yOffset = yMax;

    if (this.xOffset < 0)
      this.xOffset = 0;
    if (this.yOffset < 0)
      this.yOffset = 0;
  }

  public float getXOffset() {
    return this.xOffset;
  }

  public float getYOffset() {
    return this.yOffset;
  }

}
