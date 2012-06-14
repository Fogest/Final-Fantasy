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

	public void paintComponent(Graphics g) {
		g.drawImage(charSheet[spritePos], charSheetPosX, charSheetPosY, size1,
				size2, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the current sprite position
	 * 
	 * Used hhjfjftj
	 * 
	 * @return spritePos
	 */
	public int getSpritePos() {
		return spritePos;
	}

	/**
	 * Sets sprite postion for character on the board
	 * 
	 * @param spritePos Sets the sprite position
	 */
	public void setSpritePos(int spritePos) {
		this.spritePos = spritePos;
	}

	public int getCharSheetPosX() {
		return charSheetPosX;
	}

	public void setCharSheetPosX(int charSheetPosX) {
		this.charSheetPosX = charSheetPosX;
	}

	public int getCharSheetPosY() {
		return charSheetPosY;
	}

	public void setCharSheetPosY(int charSheetPosY) {
		this.charSheetPosY = charSheetPosY;
	}

	public int getCharWidth() {
		return size1;
	}

	public int getCharHeight() {
		return size2;
	}

	public void moveRight(int amount) {
		this.charSheetPosX = this.charSheetPosX + amount;
	}

	public void moveLeft(int amount) {
		this.charSheetPosX = this.charSheetPosX - amount;
	}

	public void moveUp(int amount) {
		this.charSheetPosY = this.charSheetPosY - amount;
	}

	public void moveDown(int amount) {
		this.charSheetPosY = this.charSheetPosY + amount;
	}

	public boolean checkForEntity() {
		Random gen = new Random();
		int generated = gen.nextInt(50);
		if (generated == 1) {
			entity = true;
		} else {
			entity = false;
		}
		return entity;
	}
}
