/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author Justin
 * 
 */
public class Grid {
	private int gridX;
	private int gridY;
	private String mapName;
	private char[][] textGrid;
	private Tile[][] tiles;

	// Sprite Sheet for Tiles
	private BufferedImage tileSheetBig;
	final int tileWidth = 64;
	final int tileHeight = 64;
	final int tileRows = 1;
	final int tileCols = 11;
	BufferedImage[] tileSheet;

	private int halfX;
	private int halfY;
	
	private int movePosX;
	private int movePosY;

	/**
	 * Creates the new grid.
	 * 
	 * @param name The name of the text file which the grid will be read from.
	 */
	public Grid(String name) {
		this.mapName = name;
		String fileName = new File("").getAbsolutePath() + "\\readIn\\"
				+ this.mapName + ".txt";
		try {
			FileReader file = new FileReader(fileName);
			Scanner in = new Scanner(file);
			this.gridX = in.nextInt();
			this.gridY = in.nextInt();
			in.nextLine();
			textGrid = new char[gridX][gridY];
			tiles = new Tile[gridX][gridY];
			String temp = "";
			for (int a = 0; a < gridY && in.hasNext(); a++) {
				temp = in.next();
				for (int c = 0; c < gridX; c++) {
					textGrid[c][a] = temp.charAt(c);
				}
				temp = "";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMap();
		try {

			tileSheetBig = ImageIO.read(new File("sprites/tiles.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		tileSheet = new BufferedImage[tileRows * tileCols];

		for (int i = 0; i < tileCols; i++) {
			for (int j = 0; j < tileRows; j++) {
				tileSheet[i * tileRows + j] = tileSheetBig.getSubimage(i
						* tileWidth, j * tileHeight, tileWidth, tileHeight);
			}
		}
	}

	/**
	 * @return Gives the X size of the grid
	 */
	public int getGridX() {
		return gridX;
	}

	/**
	 * @return the y size of the grid
	 */
	public int getGridY() {
		return gridY;
	}

	/**
	 * @return the map name
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * Draws all the tiles for the board.
	 * 
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g) {

		g.clearRect(0, 0, 1024, 576);

		for (int a = 0 + movePosY; a < 9 + movePosY; a++) {
			for (int b = 0 + movePosX; b < (16 + movePosX); b++) {
				g.drawImage(tileSheet[tiles[b][a].getSpritePos()],
						((b - movePosX) * tiles[b][a].getSize()),
						((a - movePosY) * tiles[b][a].getSize()), 64, 64, null);
			}
		}

	}

	/**
	 * Creates the tiles array based on the textGrid that is created when grid is made.
	 */
	public void setMap() {
		for (int a = 0; a < gridY; a++) {
			for (int b = 0; b < gridX; b++) {
				tiles[b][a] = new Tile(64, textGrid[b][a]);
			}
		}
	}

	/**
	 * Gets the speed in which the character moves on a given tile.
	 * 
	 * @param posX Character position X
	 * @param posY Character position Y
	 * @param height Character's height
	 * @param width Character's width
	 * @return The current tiles speed
	 */
	public int getCurBlockSpeed(int posX, int posY, int height, int width) {
		halfX = posX + (width / 2);
		halfY = posY + height;
		int arrayPosX, arrayPosY;

		arrayPosX = (halfX / tileWidth) + movePosX;
		arrayPosY = (halfY / tileHeight) + movePosY;

		return tiles[arrayPosX][arrayPosY].getSpeed();
	}

	/**
	 * Method will be used when going into a battle scene to determine what type of envrioment to display the battle in.
	 * 
	 * @param posX Character position X
	 * @param posY Character position Y
	 * @param height Character's height
	 * @param width Character's width
	 * @return The current block type in the form of a character
	 */
	public char getCurBlockType(int posX, int posY, int height, int width) {
		int arrayPosX, arrayPosY;

		arrayPosX = ((posX + (width/2))/ tileWidth)  + movePosX;
		arrayPosY = ((posY+height)/ tileHeight)  + movePosY;

		return tiles[arrayPosX][arrayPosY].getCharType();
	}

	/**
	 * Tells if the current tile in front of the character is free or not.
	 * 
	 * @param posX Character position X
	 * @param posY Character position Y
	 * @param height Character's height
	 * @param width Character's width
	 * @param a Are they going up?
	 * @param b Are they going down?
	 * @param c Are they going right?
	 * @param d Are they going left?
	 * @return true if blocked, false if clear
	 */
	public boolean isBlockFree(int posX, int posY, int height, int width,
			boolean a, boolean b, boolean c, boolean d) {
		halfX = posX;
		halfY = posY;
		int arrayPosX, arrayPosY;

		if (a == true) {
			halfY = halfY - getCurBlockSpeed(posX,posY,height,width);
			for (halfX = posX; halfX < width + posX; halfX++) {
				arrayPosX = (halfX / tileWidth) +  + movePosX;
				arrayPosY = (halfY / tileHeight)  + movePosY;
				if (tiles[arrayPosX][arrayPosY].isBlocked() == true) {
					return true;
				}
			}
		} else if (b == true) {
			halfY = posY + height + getCurBlockSpeed(posX,posY,height,width); 
			for (halfX = posX; halfX < width + posX; halfX++) {
				arrayPosX = (halfX / tileWidth) + movePosX;
				arrayPosY = (halfY / tileHeight)  + movePosY;
				if (tiles[arrayPosX][arrayPosY].isBlocked() == true) {
					return true;
				}
			}
		} else if (c == true) {
			halfX = posX + width + getCurBlockSpeed(posX,posY,height,width);
			for (halfY = posY; halfY < height + posY; halfY++) {
				arrayPosX = (halfX / tileWidth)  + movePosX;
				arrayPosY =(halfY / tileHeight)  + movePosY;
				if (tiles[arrayPosX][arrayPosY].isBlocked() == true) {
					return true;
				}
			}
		} else if (d == true) {
			halfX = posX - getCurBlockSpeed(posX,posY,height,width);
			
			for (halfY = posY; halfY < height + posY; halfY++) {
				arrayPosX = (halfX / tileWidth) + movePosX;
				arrayPosY = (halfY / tileHeight)  + movePosY;
				if (tiles[arrayPosX][arrayPosY].isBlocked() == true) {
					return true;
				}
			}
		}

		// arrayPosX = halfX / tileWidth;
		// arrayPosY = halfY / tileHeight;

		// System.out.println(tiles[arrayPosX][arrayPosY].getCharType());
		// return tiles[arrayPosX][arrayPosY].isBlocked();
		return false;
	}
	/**
	 * Used when shifting the the game board to the right
	 */
	public void shiftRight() {
		movePosX = movePosX + 1;
	}
	/**
	 * Used when shifting the the game board to the left
	 */
	public void shiftLeft() {
		movePosX = movePosX - 1;
	}
	/**
	 * Used when shifting the the game board down
	 */
	public void shiftDown() {
		movePosY = movePosY + 1;
	}
	/**
	 * Used when shifting the the game board up
	 */
	public void shiftUp() {
		movePosY = movePosY - 1;
	}


}
