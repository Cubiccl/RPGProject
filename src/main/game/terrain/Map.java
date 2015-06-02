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

	public static final byte BACKGROUND = 0, MIDGROUND = 1, FOREGROUND = 2;

	/** The tiles of the map */
	private short[][] background, midground, foreground;
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
		this.background = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		this.midground = new short[DEFAULT_SIZE][DEFAULT_SIZE];
		this.foreground = new short[DEFAULT_SIZE][DEFAULT_SIZE];

		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				this.background[i][j] = tile;
				this.midground[i][j] = tile;
				this.foreground[i][j] = tile;
			}
		}

		this.actual_size = DEFAULT_SIZE;
		this.spawnX = 0;
		this.spawnY = 0;
	}

	public void initFrom(String filePath) {
		String[] data = Utils.convertMapData(Utils.readFile(filePath));
		this.resizeTo((short) Utils.parseInt(data[0].split(" ")[0]));
		this.spawnX = Utils.parseInt(data[0].split(" ")[1]);
		this.spawnY = Utils.parseInt(data[0].split(" ")[2]);

		String[] back = data[1].split("\\s+");
		String[] mid = data[2].split("\\s+");
		String[] fore = data[3].split("\\s+");
		for (int x = 0; x < this.actual_size; x++) {
			for (int y = 0; y < this.actual_size; y++) {
				this.background[x][y] = (short) Utils
						.parseInt(back[this.actual_size * y + x]);

				this.midground[x][y] = (short) Utils
						.parseInt(mid[this.actual_size * y + x]);

				this.foreground[x][y] = (short) Utils
						.parseInt(fore[this.actual_size * y + x]);
			}
		}

		this.registerEntity(new Player(this.spawnX, this.spawnY));
	}

	/** Gets the tile id at the specified value */
	public short getTileAt(byte layer, int x, int y) {

		if (x < 0 || x > this.actual_size || y < 0 || y > this.actual_size)
			return 0;

		switch (layer) {
		case BACKGROUND:
			return this.background[x][y];

		case MIDGROUND:
			return this.midground[x][y];

		case FOREGROUND:
			return this.foreground[x][y];

		default:
			return 0;
		}
	}

	/** Gets the size of the map (it's a square) */
	public int getSize() {
		return this.actual_size;
	}

	public void setTileAt(Tile tile, byte layer, int x, int y) {
		if (x < 0 || y < 0 || x >= this.background.length
				|| y >= this.background.length) {
			System.out.println("Could not set tile : index out of bounds");
			return;
		}
		switch (layer) {
		case BACKGROUND:
			this.background[x][y] = tile.getId();
			break;

		case MIDGROUND:
			this.midground[x][y] = tile.getId();
			break;

		case FOREGROUND:
			this.foreground[x][y] = tile.getId();
			break;

		default:
			break;
		}
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
					newgrid[i][j] = this.background[i][j];
				}
			}
		} else {
			for (int i = 0; i < newsize; i++) {
				for (int j = 0; j < newsize; j++) {
					newgrid[i][j] = this.background[i][j];
				}
			}
		}
		this.background = newgrid;
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
				Tiles.getTileFromId(this.background[x][y]).renderAt(g,
						x * Tile.WIDTH - (int) startX,
						y * Tile.HEIGHT - (int) startY);

				if (this.midground[x][y] != 0)
					Tiles.getTileFromId(this.midground[x][y]).renderAt(g,
							x * Tile.WIDTH - (int) startX,
							y * Tile.HEIGHT - (int) startY);
			}
		}

		for (int i = 0; i < this.entities.size(); i++) {
			this.entities.get(i).render(g);
		}

		for (int x = (int) Math.floor(startX / Tile.WIDTH); x < endX; x++) {
			for (int y = (int) Math.floor(startY / Tile.HEIGHT); y < endY; y++) {
				if (this.foreground[x][y] != 0)
					Tiles.getTileFromId(this.foreground[x][y]).renderAt(g,
							x * Tile.WIDTH - (int) startX,
							y * Tile.HEIGHT - (int) startY);
			}
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

		return Tiles.getTileFromId(this.getTileAt(BACKGROUND, xFloor, yFloor))
				.isSolid()
				|| Tiles.getTileFromId(
						this.getTileAt(MIDGROUND, xFloor, yFloor)).isSolid()
				|| Tiles.getTileFromId(
						this.getTileAt(FOREGROUND, xFloor, yFloor)).isSolid();
	}

}
