package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//Nathan Pereira
public class NinjaGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/ninjamenu.jpg");
  private BufferedImage ninjaactions = ImageHelper.loadImage("images/ninjasprites.png");
  private BufferedImage ninjaactions2 = ImageHelper.makeColorTransparent(ninjaactions, new Color(255,0,255));
  private BufferedImage[] na = ImageHelper.splitImage(ninjaactions2, 10, 1);
  public NinjaGraphics()
  {
  }
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  public void setStand(Graphics g)
  {
    g.drawImage(na[2], 850,100, 50,75,null);
  }
}