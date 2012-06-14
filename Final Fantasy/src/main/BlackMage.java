package main;



//Nathan Pereira
import java.util.*;
public class BlackMage extends Character  {
  private String magicType;
  private int magicLevel;
  private Random gen = new Random();
  
  public BlackMage(int h,int s,int d,int w,int magicLevel)
  {
    super(h,s,d,w);
    this.magicLevel=magicLevel;
  }
  public void magicAttack(Enemy[] e,int c)
  {
    if(magicType.equals("fire"))
    {
      int damage=(super.getLevel()/4)+magicLevel+gen.nextInt(5)+1;
      e[c].damageTaken(damage);
    }else if(magicType.equals("blizzard"))
    {
      int damage=(super.getLevel()/4)+magicLevel+gen.nextInt(5)+1;
      e[c].damageTaken(damage);
    }else if(magicType.equals("thunder"))
    {
      int damage=(super.getLevel()/4)+magicLevel+gen.nextInt(5)+1;
      e[c].damageTaken(damage);
    }else if(magicType.equals("flood"))
    {
      for(int x=0;x<3;x++)
      {
        int damage=(super.getLevel()/4)+magicLevel+gen.nextInt(5)+1;
        e[x].damageTaken(damage);
      }
    }else if(magicType.equals("quake"))
    {
      int damage=(super.getLevel()/4)+magicLevel+e[c].getTotalDefence()+3;
      e[c].damageTaken(damage);
    }
  }
  /**
   * @return the magicType
   */
  public String getMagicType() {
    return magicType;
  }
  /**
   * @param magicType the magicType to set
   */
  public void setMagicType(String magicType) {
    this.magicType = magicType;
  }
  /**
   * @return the magicLevel
   */
  public int getMagicLevel() {
    return magicLevel;
  }
  /**
   * @param magicLevel the magicLevel to set
   */
  public void setMagicLevel(int magicLevel) {
    this.magicLevel = magicLevel;
  }
  public String getCommand(int x)
  {
    String y;
    if(x==1)
    {
      y="attack";
    }else if(x==2)
    {
      y="defend";
    }else if(x==3)
    {
      y="fire";
    }else if(x==4)
    {
      y="blizzard";
    }else if(x==5)
    {
      y="thunder";
    }else if(x==6)
    {
      y="flood";
    }else if(x==7)
    {
      y="quake";
    }else
    {
      y="";
    }
    return y;
  }
}