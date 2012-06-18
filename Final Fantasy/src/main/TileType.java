/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

/**
 * @author Justin
 * 
 */
public class TileType {
	private int speed;
	private int spritePos;
	private boolean blocked;
	private char type;

	/**
	 * Defines the type of tile based on the character given
	 * 
	 * @param t The character of the tile type. 
	 */
	public TileType(char t) {
		this.setType(t);
		if (t == 'g') {
			setSpeed(3);
			setSpritePos(0);
			setBlocked(false);
		} else if (t == 'r') {
			setSpeed(4);
			setSpritePos(1);
			setBlocked(false);
		} else if (t == 'd') {
			setSpeed(3);
			setSpritePos(2);
			setBlocked(false);
		} else if (t == 'm') {
			setSpeed(2);
			setSpritePos(4);
			setBlocked(false);
		} else if (t == 'c') {
			setSpeed(3);
			setSpritePos(5);
			setBlocked(false);
		} else if (t == 's') {
			setSpeed(2);
			setSpritePos(10);
			setBlocked(false);
		} else if (t == 'w') {
			setSpeed(1);
			setSpritePos(6);
			setBlocked(false);
		} else if (t == 'l') {
			setSpeed(0);
			setSpritePos(7);
			setBlocked(true);
		} else if (t == 'x') {
			setSpeed(1);
			setSpritePos(8);
			setBlocked(false);
		} else if (t == 'b') {
			setSpeed(5);
			setSpritePos(9);
			setBlocked(false);
		} else if (t == 'p') {
			setSpeed(3);
			setSpritePos(3);
			setBlocked(false);
		}
	}

	/**
	 * @return Returns specific speed of tile
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed Sets the speed of the tile
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return Returns the sprite position relating to the type of tile
	 */
	public int getSpritePos() {
		return spritePos;
	}

	/**
	 * @param spritePos Sets the sprite position of the tile
	 */
	public void setSpritePos(int spritePos) {
		this.spritePos = spritePos;
	}

	/**
	 * @return True if blocked, false if clear.
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked Sets if the tile is blocked or not.
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	/**
	 * @return Returns the type of tile
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type TileType
	 */
	public void setType(char type) {
		this.type = type;
	}

}
