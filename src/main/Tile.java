/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

/**
 * @author Justin
 * 
 */
public class Tile {
	private int size;
	private char charType;
	private TileType tileType;

	/**
	 * Creates a new TileType
	 * 
	 * @param s
	 * Size of tile
	 * @param charType
	 * Tile Type
	 */
	public Tile(int s, char charType) {
		this.setSize(s);
		setCharType(charType);
		this.tileType = new TileType(charType);
	}

	/**
	 * @return size of tile
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 * Size of tile
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return The tiletype
	 */
	public TileType getTileType() {
		return tileType;
	}

	/**
	 * @param tileType
	 * Sets the TileType
	 */
	public void setTileType(TileType tileType) {
		this.tileType = tileType;
	}

	/**
	 * @return Returns the character version of the tileType
	 */
	public char getCharType() {
		return charType;
	}

	/**
	 * @return Returns the sprite position of the current tile to be used in
	 * drawing
	 */
	public int getSpritePos() {
		return tileType.getSpritePos();
	}

	/**
	 * @param charType
	 * Sets the charType
	 */
	public void setCharType(char charType) {
		this.charType = charType;
	}

	/**
	 * @return the speed of the tile
	 */
	public int getSpeed() {
		return tileType.getSpeed();
	}

	/**
	 * @return true if blocked, false if clear.
	 */
	public boolean isBlocked() {
		return tileType.isBlocked();
	}
}
