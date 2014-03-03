/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * @author Justin
 * 
 */
public class GridPanel extends JPanel implements KeyListener {
	Grid g;
	CharacterBoard c;
	private int speed = 1;
	private boolean D;
	private boolean R;
	private boolean L;
	private boolean U;
	private boolean battle = false;

	private int spriteTick = 0;

	/**
	 * Creates the new elements required to create a grid and character on that grid
	 * 
	 * @param s Passing in the map name so that the game knows which map file to load.
	 */
	public GridPanel(String s) {
		this.g = new Grid(s);
		this.c = new CharacterBoard();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		this.g.paintComponent(g);
		this.c.paintComponent(g);
	}

	/**
	 * Performs the main movement checks
	 */
	public void run() {
		setSpeed(getCurBlockSpeed());
		checkMove();
		if (U == true) {
			if (isBlocked(true, false, false, false) != true) {
				c.moveUp(getSpeed());
				c.setSpritePos(getCurSprite(true,false,false,false));
				repaint();
				checkEntity();
			}
		}
		if (D == true) {
			if (isBlocked(false, true, false, false) != true) {
				c.moveDown(getSpeed());
				c.setSpritePos(getCurSprite(false,true,false,false));
				repaint();
				checkEntity();
			}
		}

		if (R == true) {
			if (isBlocked(false, false, true, false) != true) {
				c.moveRight(getSpeed());
				c.setSpritePos(getCurSprite(false,false,true,false));
				repaint();
				checkEntity();
			}
		}
		if (L == true) {
			if (isBlocked(false, false, false, true) != true) {
				c.moveLeft(getSpeed());
				c.setSpritePos(getCurSprite(false,false,false,true));
				repaint();
				checkEntity();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			U = true;
			break;
		case KeyEvent.VK_W:
			U = true;
			break;
		case KeyEvent.VK_DOWN:
			D = true;
			break;
		case KeyEvent.VK_S:
			D = true;
			break;
		case KeyEvent.VK_LEFT:
			L = true;
			break;
		case KeyEvent.VK_A:
			L = true;
			break;
		case KeyEvent.VK_RIGHT:
			R = true;
			break;
		case KeyEvent.VK_D:
			R = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			U = false;
			break;
		case KeyEvent.VK_W:
			U = false;
			break;
		case KeyEvent.VK_DOWN:
			D = false;
			break;
		case KeyEvent.VK_S:
			D = false;
			break;
		case KeyEvent.VK_LEFT:
			L = false;
			break;
		case KeyEvent.VK_A:
			L = false;
			break;
		case KeyEvent.VK_RIGHT:
			R = false;
			break;
		case KeyEvent.VK_D:
			R = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * @return Current tile speed
	 */
	public int getCurBlockSpeed() {
		return g.getCurBlockSpeed(c.getCharSheetPosX(), c.getCharSheetPosY(),
				c.getCharHeight(), c.getCharWidth());
	}

	/**
	 * @return Current blocks type in the form of a character
	 */
	public char getCurBlockType() {
		return g.getCurBlockType(c.getCharSheetPosX(), c.getCharSheetPosY(),
				c.getCharHeight(), c.getCharWidth());
	}

	/**
	 * @param aa Are they going up?
	 * @param bb Are they going down?
	 * @param cc Are they going right?
	 * @param dd Are they going left?
	 * @return True if tile in front is blocked, false if is not.
	 */
	public boolean isBlocked(boolean aa, boolean bb, boolean cc, boolean dd) {
		return g.isBlockFree(c.getCharSheetPosX(), c.getCharSheetPosY(),
				c.getCharHeight(), c.getCharWidth(), aa, bb, cc, dd);
	}

	/**
	 * @return True if go to battle, false if not.
	 */
	public boolean isBattle() {
		return battle;
	}

	/**
	 * Checks if there is an enemy in current spot
	 */
	public void checkEntity() {
		c.checkForEntity();
		if (c.checkForEntity() == true) {
			setBattle(true);
		}
	}

	/**
	 * @param battle Set battle to be true or false based on checkEntity()
	 */
	public void setBattle(boolean battle) {
		this.battle = battle;
	}

	/**
	 * @return Gets the current sprite tick
	 */
	public int getSpriteTick() {
		return spriteTick;
	}

	/**
	 * @param spriteTick sets the current sprite tick
	 */
	public void setSpriteTick(int spriteTick) {
		if(spriteTick >= 31) {
			spriteTick = 0;
		}
		this.spriteTick = spriteTick;
	}

	/**
	 * Used to determine which sprite to show to animate the movement of the character
	 * 
	 * @param U is player going up?
	 * @param D is player going down?
	 * @param R is player going right?
	 * @param L is player going left?
	 * @return Current sprite position
	 */
	public int getCurSprite(boolean U, boolean D, boolean R, boolean L) {
		spriteTick  = spriteTick + getSpeed();
		if(spriteTick >= 75) {
			spriteTick = 0;
		}
		if (getSpriteTick() >= 0 && getSpriteTick() <= 25) {
			if (U == true) {
				return 1;
			}
			if (D == true) {
				return 0;
			}
			if (R == true) {
				return 3;
			}
			if (L == true) {
				return 2;
			}
		}
		else if (getSpriteTick() > 25 && getSpriteTick() <= 50) {
			if (U == true) {
				return 5;
			}
			if (D == true) {
				return 4;
			}
			if (R == true) {
				return 7;
			}
			if (L == true) {
				return 6;
			}
		}
		else if (getSpriteTick() > 50 && getSpriteTick() < 75) {
			if (U == true) {
				return 9;
			}
			if (D == true) {
				return 8;
			}
			if (R == true) {
				return 11;
			}
			if (L == true) {
				return 10;
			}
		}
		
		return 1;
	}

	/**
	 * @return Character speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed Sets the current characters speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * Checks if the character has hit the map edge. If they have then the map is shifted according to which way they are going.
	 */
	public void checkMove() {
		if(c.getCharSheetPosX() > 1000) {
			g.shiftRight();
			c.setCharSheetPosX(950);
			repaint();
		}
		else if(c.getCharSheetPosX() < 10) {
			g.shiftLeft();
			c.setCharSheetPosX(128);
			repaint();
		}
		else if(c.getCharSheetPosY() > 550) {
			g.shiftDown();
			c.setCharSheetPosY(500);
			repaint();
		}
		else if(c.getCharSheetPosY() < 10) {
			g.shiftUp();
			c.setCharSheetPosY(75);
			repaint();
		}
	}
	/**
	 * Resets the checkEntity method in CharacterBoard.
	 */
	public void resetRandom() {
		c.resetRandom();
	}

}
