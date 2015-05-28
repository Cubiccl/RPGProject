package main.game.terrain;

public class Map {

	/** The tiles of the map */
	private short[][] tiles;

	/**The default size of the map*/
	private final short DEFAULT_SIZE = 255;

	/**The actual size of the map*/
	private short actual_size;
	
	/** Default constructor of an empty map */
	public Map() {
		this.tiles = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		this.actual_size = DEFAULT_SIZE;
	}

	/**
	 * Constructs a map with the specified tile
	 * 
	 * @param tile
	 *            the tile id you want on the map
	 */
	public Map(short tile) {
		this.tiles = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				this.tiles[i][j] = tile;
			}
		}
		this.actual_size = DEFAULT_SIZE;
	}
	
	/**Gets the tile id at the specified value*/
	public short getTileAt(short x, short y){
		return this.tiles[x][y];
	}
	
	/**Gets the size of the map (it's a square)*/
	public short getSize(){
		return this.actual_size;
	}
	

}
