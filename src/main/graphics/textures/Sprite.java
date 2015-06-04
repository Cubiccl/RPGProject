package main.graphics.textures;

import java.awt.image.BufferedImage;

public class Sprite {

  public static Sprite[] sprites = new Sprite[8192];
  private static int index = 0;

  public static Sprite black = new Sprite("/textures/tiles/black.png"), playerDown1 = new Sprite(
      "/textures/entity/player/playerD1.png"), playerDown2 = new Sprite(
      "/textures/entity/player/playerD2.png"), playerDown3 = new Sprite(
      "/textures/entity/player/playerD3.png"), playerUp1 = new Sprite(
      "/textures/entity/player/playerU1.png"), playerUp2 = new Sprite(
      "/textures/entity/player/playerU2.png"), playerUp3 = new Sprite(
      "/textures/entity/player/playerU3.png"), playerLeft1 = new Sprite(
      "/textures/entity/player/playerL1.png"), playerLeft2 = new Sprite(
      "/textures/entity/player/playerL2.png"), playerLeft3 = new Sprite(
      "/textures/entity/player/playerL3.png"), playerRight1 = new Sprite(
      "/textures/entity/player/playerR1.png"), playerRight2 = new Sprite(
      "/textures/entity/player/playerR2.png"), playerRight3 = new Sprite(
      "/textures/entity/player/playerR3.png"), healthbar = new Sprite(
      "/textures/hud/hp.png");

  private BufferedImage img;

  public Sprite(String path) {
    this.img = ImageLoader.load(path);
  }

  private static void register(Sprite sprite) {
    sprites[index] = sprite;
    index++;
  }

  public static Sprite getSpriteFromTileID(int id) {
    if (id == 0)
      return black;
    return sprites[id];
  }

  public Sprite(SpriteSheet sheet, int x, int y) {
    this.img = sheet.cut(x, y);

    register(this);
  }

  public BufferedImage getSprite() {
    return this.img;
  }

}
