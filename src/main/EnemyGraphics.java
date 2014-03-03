package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Class that handel the graphics for the enemies
 */
public class EnemyGraphics {
	private BufferedImage head2 = ImageHelper.loadImage("images/head.png");
	private BufferedImage head = ImageHelper.makeColorTransparent(head2,
			new Color(0, 0, 0));
	private BufferedImage troll2 = ImageHelper.loadImage("images/troll.png");
	private BufferedImage troll = ImageHelper.makeColorTransparent(troll2,
			new Color(0, 0, 0));
	private BufferedImage captain2 = ImageHelper
			.loadImage("images/captain.png");
	private BufferedImage captain = ImageHelper.makeColorTransparent(captain2,
			new Color(0, 0, 0));

	public EnemyGraphics() {
	}

	/**
	 * Draws the head
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void drawHead(Graphics g) {
		g.drawImage(head, 200, 75, 150, 150, null);
	}

	/**
	 * Draws the troll
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void drawTroll(Graphics g) {
		g.drawImage(troll, 200, 200, 150, 150, null);
	}

	/**
	 * Draws the captain
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void drawCaptain(Graphics g) {
		g.drawImage(captain, 40, 125, 150, 150, null);
	}
}