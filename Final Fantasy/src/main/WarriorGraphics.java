package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;

//Nathan Pereira
public class WarriorGraphics
{
  private BufferedImage menu = ImageHelper.loadImage("images/warriormenu.jpg");
  private BufferedImage warrioractions = ImageHelper.loadImage("images/warriorsprites.png");
  private BufferedImage warrioractions2 = ImageHelper.makeColorTransparent(warrioractions, new Color(255,0,255));
  private BufferedImage[] wa = ImageHelper.splitImage(warrioractions2, 7, 1);
  private Boolean a= false;
  public WarriorGraphics()
  {
  }
  public void setMenu(Graphics g)
  { 
    g.drawImage(menu, 257, 420, 430,150,null);
  }
  public void setStand(Graphics g)
  {
    if(a==false)
    {
      g.drawImage(wa[3], 770,165, 50,75,null);
    }
  }
  public void drawAttack(Graphics g)
  {
    a=true;
    g.drawImage(wa[4], 5,165, 50,75,null);
  }
}