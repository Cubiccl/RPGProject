package main.game.terrain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import main.RPGProject;
import main.Utils;
import main.game.entity.Entity;
import main.game.entity.mob.player.Player;
import main.game.terrain.tile.Tile;
import main.graphics.Display;
import exeptions.DimensinoNotSquarredException;

public class Map {

	/** The tiles of the map */
	private short[][] tiles;
	/** The default size of the map */
	private final int DEFAULT_SIZE = 255;
	/** The actual size of the map */
	private int actual_size;
	/** The spawning Coordinates for this map */
	private int spawnX, spawnY;
	/** The Entities on this map */
	private ArrayList<Entity> entities;

	/** Default constructor of an empty map */
	public Map() {
		this(Tiles.black.getId());
	}

	/**
	 * Constructs a map with the specified tile
	 * 
	 * @param tile
	 *            the tile id you want on the map
	 */
	public Map(short tile) {
		this.entities = new ArrayList<Entity>();
		this.tiles = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				this.tiles[i][j] = tile;
			}
		}
		this.actual_size = DEFAULT_SIZE;
		this.spawnX = 0;
		this.spawnY = 0;
	}

	public void initFrom(String filePath) {
		String data = Utils.readFile(filePath);
		String[] elements = data.split("\\s+");
		this.resizeTo((short) Utils.parseInt(elements[0]));
		this.spawnX = Utils.parseInt(elements[1]);
		this.spawnY = Utils.parseInt(elements[2]);
		for (int x = 0; x < this.actual_size; x++) {
			for (int y = 0; y < this.actual_size; y++) {
				this.tiles[x][y] = (short) Utils.parseInt(elements[3
						+ this.actual_size * y + x]);
			}
		}

		this.registerEntity(new Player(this.spawnX, this.spawnY));
	}

	/** Gets the tile id at the specified value */
	public short getTileAt(int x, int y) {
		return this.tiles[x][y];
	}

	/** Gets the size of the map (it's a square) */
	public int getSize() {
		return this.actual_size;
	}

	public void setTileAt(Tile tile, int x, int y) {
		if (x < 0 || y < 0 || x >= this.tiles.length || y >= this.tiles.length) {
			System.out.println("Could not set tile : index out of bounds");
			return;
		}
		this.tiles[x][y] = tile.getId();
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
	public void resizeTo(Dimension d) throws DimensinoNotSquarredException {
		if (d.height != d.width)
			throw new DimensinoNotSquarredException(d);
		this.resizeTo((short) d.height, (short) 0);

	}

	/**
	 * resizes the map to the desired value. Set 0 tiles to new ones.
	 * 
	 * @param newsize
	 *            the new size
	 * 
	 * */
	public void resizeTo(short newsize) {
		this.resizeTo(newsize, (short) 0);
	}

	public void update() {
		for (Entity entity : this.entities) {
			entity.update(this);
		}
	}

	public void render(Graphics g) {

		float startX = RPGProject.getWindow().getCamera().getXOffset();
		float startY = RPGProject.getWindow().getCamera().getYOffset();

		float endX = (startX + Display.WIDTH) / Tile.WIDTH;
		float endY = (startY + Display.HEIGHT) / Tile.HEIGHT;

		if (endX > this.actual_size)
			endX = this.actual_size;
		if (endY > this.actual_size)
			endY = this.actual_size;

		for (int x = (int) Math.floor(startX / Tile.WIDTH); x < endX; x++) {
			for (int y = (int) Math.floor(startY / Tile.HEIGHT); y < endY; y++) {
				Tiles.getTileFromId(tiles[x][y]).renderAt(g,
						x * Tile.WIDTH - (int) startX,
						y * Tile.HEIGHT - (int) startY);
			}
		}

		for (int i = 0; i < this.entities.size(); i++) {
			this.entities.get(i).render(g);
		}
	}

	public void registerEntity(Entity entity) {
		if (!this.entities.contains(entity))
			this.entities.add(entity);
	}

	public void removeEntity(Entity entity) {
		if (this.entities.contains(entity))
			this.entities.remove(entity);
	}

	public boolean isSolid(float x, float y) {
		int xFloor = Utils.floor(x), yFloor = Utils.floor(y);
		if (xFloor < 0 || xFloor >= this.actual_size || yFloor < 0
				|| yFloor >= this.actual_size)
			return false;
		
		return Tiles.getTileFromId(this.getTileAt(xFloor, yFloor)).isSolid();
	}

}
