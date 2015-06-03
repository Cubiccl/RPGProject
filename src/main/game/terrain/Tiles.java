package main.game.terrain;

import main.Utils;
import main.game.terrain.tile.Tile;
import main.graphics.textures.Sprite;

public class Tiles {

	private static Tile[] tiles = new Tile[16384];

	public static Tile black = new Tile((short) 0, Sprite.black);

	public static Tile getTileFromId(short id) {
		if (id >= tiles.length)
			return black;
		if (tiles[id] != null)
			return tiles[id];
		else
			return tiles[0];
	}

	public static void register(Tile tile) {
		tiles[tile.getId()] = tile;
	}

	public static void update() {
		for (Tile tile : tiles) {
			if (tile != null)
				tile.update();
		}
	}

	public static void init() {
		short index = 1;

		for (Sprite sprite : Sprite.sprites) {
			@SuppressWarnings("unused")
			Tile tile = new Tile(index, sprite);
			index++;
		}

		String solids = Utils.readFile("res/data/solid.til");
		for (String id : solids.split("\\s+")) {
			getTileFromId((short) Utils.parseInt(id)).setSolid(true);
		}
	}

}
