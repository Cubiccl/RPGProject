package main.game.entity.mob.player;

import java.awt.Color;
import java.awt.Graphics;

import main.RPGProject;
import main.game.entity.mob.Mob;
import main.game.input.KeyCustom;
import main.game.terrain.Map;
import main.game.terrain.tile.Tile;
import main.graphics.textures.Animation;
import main.graphics.textures.Sprite;

public class Player extends Mob {

  private static final float DEFAULT_SPEED = 0.3f;

  private Inventory inventory;

  public Player(float x, float y) {
    super(5, DEFAULT_SPEED, x, y, new Animation(Sprite.playerDown2));

    this.setMovementAnimations(new Animation(Sprite.playerDown1, Sprite.playerDown2,
        Sprite.playerDown3, Sprite.playerDown2), new Animation(Sprite.playerUp1, Sprite.playerUp2,
        Sprite.playerUp3, Sprite.playerUp2), new Animation(Sprite.playerLeft1, Sprite.playerLeft2,
        Sprite.playerLeft3, Sprite.playerLeft2), new Animation(Sprite.playerRight1,
        Sprite.playerRight2, Sprite.playerRight3, Sprite.playerRight2));
    this.setStandingAnimations(new Animation(Sprite.playerDown2), new Animation(Sprite.playerUp2),
        new Animation(Sprite.playerLeft2), new Animation(Sprite.playerRight2));
    this.setSize(32, 48);

    this.inventory = new Inventory();
  }

  @Override
  public void update(Map map) {
    this.manageInput();
    super.update(map);
    RPGProject.getWindow().getCamera().centerOnEntity(this, map);
  }

  private void manageInput() {
    if (RPGProject.getGame().getKeyManager().isKeyPressedAbsolute(KeyCustom.up.getKeyCode())) {
      this.yMotion = -1;
      if (RPGProject.getGame().getKeyManager().isKeyPressedAbsolute(KeyCustom.down.getKeyCode()))
        this.yMotion = 0;
    } else if (RPGProject.getGame().getKeyManager()
        .isKeyPressedAbsolute(KeyCustom.down.getKeyCode()))
      this.yMotion = 1;

    if (RPGProject.getGame().getKeyManager().isKeyPressedAbsolute(KeyCustom.right.getKeyCode())) {
      this.xMotion = 1;
      if (RPGProject.getGame().getKeyManager().isKeyPressedAbsolute(KeyCustom.left.getKeyCode()))
        this.xMotion = 0;
    } else if (RPGProject.getGame().getKeyManager()
        .isKeyPressedAbsolute(KeyCustom.left.getKeyCode()))
      this.xMotion = -1;
  }

  public void render(Graphics g) {
    super.render(g);
    g.setColor(Color.RED);
    g.fillRect(30, 30, 200, 10);
    g.drawImage(Sprite.healthbar.getSprite(), 10, 10, 299, 60, null);
  }

}
