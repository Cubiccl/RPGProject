package main.game.terrain;

public class Map {

	/** The tiles of the map */
	private short[][] tiles;

	private final short DEFAULT_SIZE = 255;

	/** Default constructor of an empty map */
	public Map() {
		this.tiles = new short[DEFAULT_SIZE][DEFAULT_SIZE];
	}

	/**
	 * Constructs a map with the specified tile
	 * 
	 * @param tile
	 *            the tile id you want on the map
	 * */
	public Map(short tile) {
		this.tiles = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				this.tiles[i][j] = tile;
			}
		}

	}

}
