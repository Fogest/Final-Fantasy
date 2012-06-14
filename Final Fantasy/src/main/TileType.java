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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpritePos() {
		return spritePos;
	}

	public void setSpritePos(int spritePos) {
		this.spritePos = spritePos;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public static void main(String[] args) {
		TileType t = new TileType('x');
		System.out.println(t.getSpritePos());
		System.out.println(t.getSpeed());
		System.out.println(t.getType());
	}

}
