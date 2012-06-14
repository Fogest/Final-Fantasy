package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//Nathan Pereira
public class DragoonGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/dragoonmenu.jpg");
  private BufferedImage dragoonactions = ImageHelper.loadImage("images/dragoonsprites.png");
  private BufferedImage dragoonactions2 = ImageHelper.makeColorTransparent(dragoonactions, new Color(255,0,255));
  private BufferedImage[] da = ImageHelper.splitImage(dragoonactions2, 10, 1);
  public DragoonGraphics()
  {
  }
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  public void setStand(Graphics g)
  {

    g.drawImage(da[3], 850,245, 50,75,null);   
  }
}