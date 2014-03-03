package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Class that handel the graphics for ninja
 */
public class NinjaGraphics {
	private BufferedImage menu = ImageHelper.loadImage("images/ninjamenu.jpg");
	private BufferedImage ninjaactions = ImageHelper
			.loadImage("images/ninjasprites.png");
	private BufferedImage ninjaactions2 = ImageHelper.makeColorTransparent(
			ninjaactions, new Color(255, 0, 255));
	private BufferedImage[] na = ImageHelper.splitImage(ninjaactions2, 10, 1);

	public NinjaGraphics() {
	}

	/**
	 * Draws the options menu that ninja can use
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void setMenu(Graphics g) {
		g.drawImage(menu, 257, 420, 430, 150, null);
	}

	/**
	 * Draws the ninja standing
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void setStand(Graphics g) {
		g.drawImage(na[2], 850, 100, 50, 75, null);
	}
}