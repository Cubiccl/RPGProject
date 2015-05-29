package main.game.entity.item;

import main.game.entity.Entity;
import main.game.entity.mob.player.Item;
import main.graphics.textures.Sprite;

/**
 * Entities that are items, capable of being picked up by the player. Entity
 * items are entities carying an item stack, as in an inventory.
 */
public class EntityItem extends Entity {

	/** The ID of the item contained in the entity */
	private Item content;

	/** Creates an entityItem using an Item and a sprite. */
	EntityItem(Item item, float x, float y, Sprite sprite) {
		super(x, y, sprite);
		this.content = item;
	}

	/** Creates an entityItem using the item sprite */
	public EntityItem(Item item, float x, float y) {
		super(x, y, item.getSprite());
		this.content = item;
	}
	
	/** Returns the item contained by the entity */
	public Item getItem() {
		return this.content;
	}

}
