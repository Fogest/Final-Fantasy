/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @author Justin
 * 
 */
public class CharacterBoard {
	// Sprite Sheet for Character
	private BufferedImage charSheetBig;
	final int charWidth = 16;
	final int charHeight = 23;
	final int charRows = 4;
	final int charCols = 3;
	public static int size1 = 60;
	public static int size2 = 60;
	private int spritePos = 0;
	BufferedImage[] charSheet;

	private int charSheetPosX = 228;
	private int charSheetPosY = 228;

	private boolean entity = false;

	private int generated;
	/**
	 * When a new character is created, the new sprite array is read in.
	 */
	public CharacterBoard() {
		try {
			charSheetBig = ImageIO.read(new File("sprites/player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		charSheet = new BufferedImage[charRows * charCols];

		for (int i = 0; i < charCols; i++) {
			for (int j = 0; j < charRows; j++) {
				charSheet[i * charRows + j] = charSheetBig.getSubimage(i
						* charWidth, j * charHeight, charWidth, charHeight);
			}
		}
	}

	/**
	 * 
	 */
	public void run() {
	}

	/**
	 * Draws to screen the current character sprite
	 * 
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(charSheet[spritePos], charSheetPosX, charSheetPosY, size1,
				size2, null);
	}


	/**
	 * Gets the current sprite position
	 * 
	 * @return spritePos Gives current position in sprite
	 */
	public int getSpritePos() {
		return spritePos;
	}

	/**
	 * Sets sprite position for character on the board
	 * 
	 * @param spritePos Sets the sprite position
	 */
	public void setSpritePos(int spritePos) {
		this.spritePos = spritePos;
	}

	/**
	 * Used to obtain current x positon of character
	 * 
	 * @return Current X coordinate of the character
	 */
	public int getCharSheetPosX() {
		return charSheetPosX;
	}

	/**
	 * @param charSheetPosX Integer to set characters x position
	 */
	public void setCharSheetPosX(int charSheetPosX) {
		this.charSheetPosX = charSheetPosX;
	}

	/**
	 * @return Current characters Y position
	 */
	public int getCharSheetPosY() {
		return charSheetPosY;
	}

	/**
	 * @param charSheetPosY Interger to set characters Y position
	 */
	public void setCharSheetPosY(int charSheetPosY) {
		this.charSheetPosY = charSheetPosY;
	}

	/**
	 * @return Gives the characters width
	 */
	public int getCharWidth() {
		return size1;
	}

	/**
	 * @return Gives the characters height
	 */
	public int getCharHeight() {
		return size2;
	}

	/**
	 * Shifts the character right by the given amount
	 * 
	 * @param amount The amount which to move the character
	 */
	public void moveRight(int amount) {
		this.charSheetPosX = this.charSheetPosX + amount;
	}
	
	/**
	 * Shifts the character left by the given amount
	 * 
	 * @param amount The amount which to move the character
	 */
	public void moveLeft(int amount) {
		this.charSheetPosX = this.charSheetPosX - amount;
	}

	/**
	 * Shifts the character up by the given amount
	 * 
	 * @param amount The amount which to move the character
	 */
	public void moveUp(int amount) {
		this.charSheetPosY = this.charSheetPosY - amount;
	}

	/**
	 * Shifts the character down by the given amount
	 * 
	 * @param amount The amount which to move the character
	 */
	public void moveDown(int amount) {
		this.charSheetPosY = this.charSheetPosY + amount;
	}

	/**
	 * Used to determien when to enter a battle based on a random integer
	 * 
	 * @return True if there is an enemy, false if is none
	 */
	public boolean checkForEntity() {
		Random gen = new Random();
		generated = gen.nextInt(1000);
		if (generated == 1) {
			entity = true;
		} else {
			entity = false;
		}
		return entity;
	}
	/**
	 * Simply used to reset the checkForEntity value when exiting a battle.
	 */
	public void resetRandom() {
		generated = 0;
	}
}
