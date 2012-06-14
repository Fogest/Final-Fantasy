package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//Nathan Pereira
public class WhiteMageGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/whitemagemenu.jpg");
  private BufferedImage whitemageactions = ImageHelper.loadImage("images/whitemagesprites.png");
  private BufferedImage whitemageactions2 = ImageHelper.makeColorTransparent(whitemageactions, new Color(255,0,255));
  private BufferedImage[] wma = ImageHelper.splitImage(whitemageactions2, 12, 1);
  public WhiteMageGraphics()
  {
  }
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  public void setStand(Graphics g)
  { 
    g.drawImage(wma[5], 770,310, 50,75,null);
  }
}