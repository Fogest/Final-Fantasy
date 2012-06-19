package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//June 18 2012
/**
* @author Nathan Pereira
* 
* Class that handle the graphics for white mage
*/
public class WhiteMageGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/whitemagemenu.jpg");
  private BufferedImage whitemageactions = ImageHelper.loadImage("images/whitemagesprites.png");
  private BufferedImage whitemageactions2 = ImageHelper.makeColorTransparent(whitemageactions, new Color(255,0,255));
  private BufferedImage[] wma = ImageHelper.splitImage(whitemageactions2, 12, 1);
  public WhiteMageGraphics()
  {
  }
  /**
   * Draws the options menu that white mage can use
   * 
   * @param g Graphics variable required for drawing to screen
   */
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  /**
   * Draws the white mage standing
   * 
   * @param g Graphics variable required for drawing to screen
   */
  public void setStand(Graphics g)
  { 
    g.drawImage(wma[5], 770,310, 50,75,null);
  }
}