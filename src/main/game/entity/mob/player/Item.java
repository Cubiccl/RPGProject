package main.game.entity.mob.player;

import main.graphics.textures.Animation;

/** An item in the player inventory. Not an entity */
public class Item {

  /** The ID of the pile of item */
  private int id;
  /** The number of items in the pile */
  private int stacksize;
  /** The sprite of the item */
  private Animation animation;

  /** Constructs an item using an ID , a sprite and an ammount */
  public Item(int id, Animation animation, int ammount) {
    this.animation = animation;
    this.id = id;
    this.stacksize = ammount;
  }

  /** Creates a single items of the specified sprite and ID. */
  public Item(int id, Animation animation) {
    this(id, animation, 1);
  }

  /** adds i items to the stack. */
  public void addcount(int i) {
    this.stacksize += i;
  }

  /** Returns the ammount of items in the stack */
  public int getsize() {
    return this.stacksize;
  }

  /** Set the count of an item to the desired value. */
  public void setsize(int count) {
    this.stacksize = count;
  }

  /** Gets the sprite of the item */
  public Animation getAnimation() {
    return this.animation;
  }

  /**
   * The hardcore way of changing the id of the item. Shouldn't really be used.
   */
  public void resetID(int id, Animation animation) {
    this.animation = animation;
    this.id = id;
  }

  /** Gets the item ID */
  public int getid() {
    return this.id;
  }
}
