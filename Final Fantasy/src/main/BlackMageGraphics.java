package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//Nathan Pereira
public class BlackMageGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/blackmagemenu.jpg");
  private BufferedImage blackmageactions = ImageHelper.loadImage("images/blackmagesprites.png");
  private BufferedImage blackmageactions2 = ImageHelper.makeColorTransparent(blackmageactions, new Color(255,0,255));
  private BufferedImage[] bma = ImageHelper.splitImage(blackmageactions2, 12, 1);
  public BlackMageGraphics()
  {
  }
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  public void setStand(Graphics g)
  {
    g.drawImage(bma[5], 770,65, 50,75,null);
  }
}