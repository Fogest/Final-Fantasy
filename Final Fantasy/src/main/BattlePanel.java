package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;

//Nathan Pereira
public class BattlePanel extends JPanel implements MouseListener,KeyListener
{
  
  private BufferedImage battlelayout = ImageHelper.loadImage("images/Battlemenu.png");
  private BufferedImage background2 = ImageHelper.loadImage("images/backgroundsprite.png");
  private BufferedImage[] background = ImageHelper.splitImage(background2, 9, 1);
  private char x;
  private int currentc=1;
  private String currenth="warrior";
  private int currente=1;
  private BlackMageGraphics bm=new BlackMageGraphics();
  private WarriorGraphics w=new WarriorGraphics();
  private WhiteMageGraphics wm=new WhiteMageGraphics();
  private DragoonGraphics d=new DragoonGraphics();
  private NinjaGraphics n=new NinjaGraphics();
  private EnemyGraphics e= new EnemyGraphics();
  private Logic logic =new Logic(100,5,10);
  
  Dimension screenSize = new Dimension(1024,580);
  
//  private int wp=770;
//  private int wmp=770;
//  private int bmp=770;
//  private int dp=850;
//  private int np=850;
  public BattlePanel(char x)
  {
    this.x=x;
    this.addMouseListener(this);
    this.addKeyListener(this);
    setPreferredSize(screenSize);
  }
  public void run()
  {
    if(logic.getPartyState(1)==false&&currente==1)
    {
      currente=2;
    }
    if(logic.getPartyState(2)==false&&currente==2)
    {
      currente=3;
    }
    if(logic.getPartyState(3)==false&&currente==3)
    {
      currente=1;
    }
    repaint();
  }
  public void paintComponent(Graphics g)
  {
    g.clearRect(0,0,1024,576);
    g.drawImage(battlelayout, 0, 0, 1024,580,null);
    Font big = new Font("SansSerif", Font.BOLD, 20);
    g.setFont(big);
    g.setColor(Color.white);
    if(x=='g')
    {
      g.drawImage(background[0], 0, 0, 1024,390,null);
    }else if(x=='r')
    {
      g.drawImage(background[1], 0, 0, 1024,390,null);
    }else if(x=='d')
    {
      g.drawImage(background[2], 0, 0, 1024,390,null);
    }else if(x=='m')
    {
      g.drawImage(background[3], 0, 0, 1024,390,null);
    }else if(x=='c')
    {
      g.drawImage(background[4], 0, 0, 1024,390,null);
    }else if(x=='w')
    {
      g.drawImage(background[5], 0, 0, 1024,390,null);
    }else if(x=='x')
    {
      g.drawImage(background[6], 0, 0, 1024,390,null);
    }else if(x=='b')
    {
      g.drawImage(background[7], 0, 0, 1024,390,null);
    }else if(x=='s')
    {
      g.drawImage(background[8], 0, 0, 1024,390,null);
    }
    
    
    if(logic.getPartyState(1))
    {
      bm.setStand(g);
      g.drawString("Black Mage  "+logic.getPartyHealth(1)+" HP",715,430);
       if(currentc==1)
      {
        bm.setMenu(g);
        repaint();
      }
    }
    if(logic.getPartyState(2))
    {
      n.setStand(g);
      g.drawString("Ninja  "+logic.getPartyHealth(2)+" HP",715,460);
         if(currentc==2)
      {
        n.setMenu(g);
        repaint();
      }
    }
    if(logic.getPartyState(3))
    {
      w.setStand(g);
      g.drawString("Warrior "+logic.getPartyHealth(3)+" HP",715,490);
         if(currentc==3)
      {
        w.setMenu(g);
        repaint();
      }
    }
    if(logic.getPartyState(4))
    {
      d.setStand(g);
      g.drawString("Dragoon  "+logic.getPartyHealth(4)+" HP",715,520);
   if(currentc==4)
      {
        d.setMenu(g);
        repaint();
      }
    }
    if(logic.getPartyState(5))
    {
      wm.setStand(g);
      g.drawString("White Mage  "+logic.getPartyHealth(5)+" HP",715,550);
       if(currentc==5)
      {
        wm.setMenu(g);
        repaint();
      }
    }
    
    
    if(logic.getEnemyState(0))
    {
      e.drawHead(g);
      g.drawString("Head  "+logic.getEnemyHealth(0)+" HP",50,430);
    }
    if(logic.getEnemyState(1))
    {
      e.drawTroll(g);
      g.drawString("Troll  "+logic.getEnemyHealth(1)+" HP",50,480);
    }
    if(logic.getEnemyState(2))
    {
      e.drawCaptain(g);
      g.drawString("Captain  "+logic.getEnemyHealth(2)+" HP",50,530);
    }
  }
  
  public void mouseClicked(MouseEvent e)
  {
    int x= e.getX();
    int y= e.getY();
    // column 1
    if((x<520)&&(x>390))
    {
      //row one
      if((y<450)&&(y>425))
      {
        logic.performAction(currentc,1,currente,currenth);
        repaint();
      }else
        //row two
        if((y<490)&&(y>460))
      {
        logic.performAction(currentc,3,currente,currenth);
        repaint();
      }else 
        //row three
        if((y<525)&&(y>495))
      {
        logic.performAction(currentc,5,currente,currenth);
        repaint();
      }else
        //row four
        if((y<560)&&(y>530))
      {
        logic.performAction(currentc,7,currente,currenth);
        repaint();
      }
    }else
      //column 2
      if((x>535)&&(x<650))
    {
      //row one
      if((y<450)&&(y>425))
      {
      if(logic.getPartyState(currentc))
      {
        logic.performAction(currentc,2,currente,currenth);
      }
        repaint();
      }else
        //row two
        if((y<490)&&(y>460))
      {
        logic.performAction(currentc,4,currente,currenth);
        repaint();
      }else
        //row three
        if((y<525)&&(y>495))
      {
        logic.performAction(currentc,6,currente,currenth);
        repaint();
      }
    }else if(x>210&&x<345)
    {
      if(y>75&&y<215)
      {
        currente=0;
      }else if(y>215&&y<350)
      {
        currente=1;
      }
    }else if(x>50&&x<185)
    {
      if(y>130&&y<275)
      {
        currente=2;
      }
    }else if(x>770&&x<815)
    {
      if(y>65&&y<135)
      {
        currentc=1;
      }else if(y>165&&y<240)
      {
        currentc=3;
      }else if(y>310&&y<385)
      {
        currentc=5;
      }
    }else if(x>845&&x<895)
    {
      if(y>95&&y<175)
      {
        currentc=2;
      }else if(y>240&&y<317)
      {
        currentc=4;
      }
    }
    repaint();
  }
  public boolean isGameOver()
  {
    return logic.isGameOver();
  }
  public boolean isBattleWon()
  {
    return logic.isBattleWon();
  }
  public void mouseEntered(MouseEvent paramMouseEvent){}
  public void mouseExited(MouseEvent paramMouseEvent) {}
  public void mouseReleased(MouseEvent paramMouseEvent) {}
  public void mousePressed(MouseEvent paramMouseEvent){}
  
  public void keyPressed(KeyEvent paramKeyEvent)
  {
    int id = paramKeyEvent.getKeyCode();
    if(id == KeyEvent.VK_Q)
    {
      currenth="blackmage";
      System.out.println("bm");
    }else if(id == KeyEvent.VK_W)
    {
      currenth="ninja";
      System.out.println("n");
    }else if(id == KeyEvent.VK_E)
    {
      currenth="warrior";
      System.out.println("w");
    }else if(id == KeyEvent.VK_R)
    {
      currenth="dragoon";
      System.out.println("d");
    }else if(id == KeyEvent.VK_T)
    {
      currenth="whitemage";
      System.out.println("wm");
    }
  }  
  public void keyReleased(KeyEvent paramKeyEvent){}
// A key has been pressed down and released (Typed)
  public void keyTyped(KeyEvent paramKeyEvent){

  }
  
  
  
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Final Fantasy");
    BattlePanel p=new BattlePanel('x');
    p.run();
    frame.add(p);
    frame.setSize(1024,615);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.addKeyListener(p);
  }
  
}
