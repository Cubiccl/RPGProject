package main.game.terrain;

import main.game.terrain.tile.Tile;
import main.game.terrain.tile.TileObject;
import main.graphics.textures.Sprite;

public class Tiles {
	
	private static Tile[] tiles = new Tile[512];

	public static Tile black = new Tile((short) 0, Sprite.black, false);
	public static Tile grass = new Tile((short) 1, Sprite.grass, false);
	public static Tile grassRock = new TileObject((short) 100, Sprite.grass, Sprite.rock2, true);
	
	public static Tile getTileFromId(short id) {
		System.out.println(id);
		return tiles[id];
	}

	public static void register(Tile tile) {
		tiles[tile.getId()] = tile;
	}

}
