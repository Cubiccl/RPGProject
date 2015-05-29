package main.game.entity.mob.player;

public class Inventory {

	private Item[] content;

	public Inventory() {
		this.content = new Item[30];
	}

	/** Returns the specified item */
	public Item getItemAt(int i) {
		return content[i];
	}
}
