package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Class that handel the graphics for black mage
 */
public class DragoonGraphics {
	private BufferedImage menu = ImageHelper
			.loadImage("images/dragoonmenu.jpg");
	private BufferedImage dragoonactions = ImageHelper
			.loadImage("images/dragoonsprites.png");
	private BufferedImage dragoonactions2 = ImageHelper.makeColorTransparent(
			dragoonactions, new Color(255, 0, 255));
	private BufferedImage[] da = ImageHelper.splitImage(dragoonactions2, 10, 1);

	public DragoonGraphics() {
	}

	/**
	 * Draws the options menu that dragoon can use
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void setMenu(Graphics g) {
		g.drawImage(menu, 257, 420, 430, 150, null);
	}

	/**
	 * Draws the dragoon standing
	 * 
	 * @param g
	 * Graphics variable required for drawing to screen
	 */
	public void setStand(Graphics g) {

		g.drawImage(da[3], 850, 245, 50, 75, null);
	}
}