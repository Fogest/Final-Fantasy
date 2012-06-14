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

	public Tile(int s, char charType) {
		this.setSize(s);
		setCharType(charType);
		this.tileType = new TileType(charType);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TileType getTileType() {
		return tileType;
	}

	public void setTileType(TileType tileType) {
		this.tileType = tileType;
	}

	public static void main(String[] args) {

	}

	public char getCharType() {
		return charType;
	}

	public int getSpritePos() {
		return tileType.getSpritePos();
	}

	public void setCharType(char charType) {
		this.charType = charType;
	}
	public int getSpeed()
	{
		return tileType.getSpeed();
	}
	public boolean isBlocked()
	{
	return tileType.isBlocked();	
	}
	}
