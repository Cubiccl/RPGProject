package main.game.terrain;

import main.game.terrain.tile.Tile;
import main.game.terrain.tile.TileObject;
import main.graphics.textures.Sprite;

public class Tiles {

	private static Tile[] tiles = new Tile[512];

	public static Tile black = new Tile((short) 0, Sprite.black, false);
	public static Tile grass = new Tile((short) 1, Sprite.grass, false);
	public static Tile grassRock = new TileObject((short) 100, Sprite.grass,
			Sprite.rock2, true);
	public static Tile cornerBL = new TileObject((short) 106, Sprite.grass,
			Sprite.cornerBL, false);
	public static Tile cornerBR = new TileObject((short) 104, Sprite.grass,
			Sprite.cornerBR, false);
	public static Tile cornerTL = new TileObject((short) 108, Sprite.grass,
			Sprite.cornerTL, false);
	public static Tile cornerTR = new TileObject((short) 102, Sprite.grass,
			Sprite.cornerTR, false);
	public static Tile edgeL = new TileObject((short) 107, Sprite.grass,
			Sprite.edgeL, false);
	public static Tile edgeR = new TileObject((short) 103, Sprite.grass,
			Sprite.edgeR, false);
	public static Tile edgeT = new TileObject((short) 101, Sprite.grass,
			Sprite.edgeT, false);
	public static Tile edgeB = new TileObject((short) 105, Sprite.grass,
			Sprite.edgeB, false);

	public static Tile getTileFromId(short id) {
		if (tiles[id] != null)
			return tiles[id];
		else
			return tiles[0];
	}

	public static void register(Tile tile) {
		tiles[tile.getId()] = tile;
	}

}
