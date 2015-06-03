package main.game.entity;

import java.awt.Graphics;

import main.RPGProject;
import main.game.terrain.Map;
import main.game.terrain.tile.Tile;
import main.graphics.textures.Animation;

public abstract class Entity {

  public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;

  protected float x, y;
  private int width, height;
  private Animation animation;

  public Entity(float x, float y, Animation animation) {
    this.x = x;
    this.y = y;
    this.width = DEFAULT_WIDTH;
    this.height = DEFAULT_HEIGHT;
    this.animation = animation;
  }

  public void update(Map map) {}

  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setAnimation(Animation animation) {
    this.animation = animation;
  }

  public void render(Graphics g) {
    g.drawImage(this.animation.getSprite(), (int) (this.x * Tile.WIDTH - RPGProject.getWindow()
        .getCamera().getXOffset())
        - this.getWidth() / 4, (int) (this.y * Tile.HEIGHT - RPGProject.getWindow().getCamera()
        .getYOffset())
        - this.getHeight() / 4, 32, 32, null);
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }
}
