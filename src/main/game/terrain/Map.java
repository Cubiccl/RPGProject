package main.game.terrain;

import java.awt.Dimension;

import exeptions.DimensinoNotSquarredException;

public class Map {

	/** The tiles of the map */
	private short[][] tiles;
	/** The default size of the map */
	private final int DEFAULT_SIZE = 255;
	/** The actual size of the map */
	private int actual_size;

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

	/** Gets the tile id at the specified value */
	public short getTileAt(int x, int y) {
		return this.tiles[x][y];
	}

	/** Gets the size of the map (it's a square) */
	public int getSize() {
		return this.actual_size;
	}

	/**
	 * resizes the map to the desired value. Use tile 0 as default for more
	 * optimized usage.
	 * 
	 * @param newsize
	 *            the new size
	 * @param tile
	 *            the id of the tile you want.
	 * 
	 * */
	public void resizeTo(int newsize, short tileId) {
		if (this.actual_size == newsize)
			return;
		this.actual_size = newsize;
		short[][] newgrid = new short[newsize][newsize];
		if (newsize > this.actual_size) {
			if (tileId != 0)
				for (int i = 0; i < newsize; i++) {
					for (int j = 0; j < newsize; j++) {
						newgrid[i][j] = tileId;
					}
				}
			for (int i = 0; i < this.actual_size; i++) {
				for (int j = 0; j < this.actual_size; j++) {
					newgrid[i][j] = this.tiles[i][j];
				}
			}
		} else {
			for (int i = 0; i < newsize; i++) {
				for (int j = 0; j < newsize; j++) {
					newgrid[i][j] = this.tiles[i][j];
				}
			}
		}
		this.tiles = newgrid;
	}

	/**
	 * Resizes the map to the desired dimension. Set default tiles to new ones.
	 * 
	 * @throws dimensionNotSquarredExeption
	 *             make sure your dimension object is a square, cause the map is
	 *             always a square.
	 * */
	public void resizeto(Dimension d) throws DimensinoNotSquarredException{
		if(d.height !=d.width)
			throw new DimensinoNotSquarredException(d);
		this.resizeTo((short) d.height,(short)0);
		
	}

	/**
	 * resizes the map to the desired value. Set 0 tiles to new ones.
	 * 
	 * @param newsize
	 *            the new size
	 * 
	 * */
	public void resizeto(short newsize) {
		this.resizeTo(newsize, (short) 0);
	}
}
