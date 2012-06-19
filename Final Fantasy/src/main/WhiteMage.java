package main;

//June 18 2012
/**
* @author Nathan Pereira
* 
* Class that is used for playing as a white mage
* 
*/
public class WhiteMage extends Character  {
  private String magicType;
  private int magicLevel;
  
	/**
	 * Constructor for white mage same as character but with a magic level(int)
	 * required
	 * 
	 * @param magicLevel
	 *            determines the strength of the strength of the magic attack
	 */
  public WhiteMage(int h,int s,int d,int w,int magicLevel)
  {
    super(h,s,d,w);
    this.magicLevel=magicLevel;
  }
  
  /**
   * method is used to buff allies, using magic type variable to determine buff type
   * 
 * @param bm used when player selects black mage to buff
 * @param wm used when player selects white mage to buff
 * @param d used when player selects dragoon to buff
 * @param n used when player selects ninja to buff
 * @param w used when player selects warrior to buff
 * @param t used to determine who is being buffed
 */
public void magicAttack(BlackMage bm,WhiteMage wm,Dragoon d,Ninja n,Character w,String t)
  {
    if(magicType.equals("cure"))
    {
      if(t.equals("warrior"))
      {
        int h= w.getHealth()+40;
        if(h<100)
        {
          w.setHealth(h);
        }else if(h>100)
        {
          w.setHealth(100);
        }
      }else if(t.equals("dragoon"))
      {
        int h= d.getHealth()+40;
        if(h<100)
        {
          d.setHealth(h);
        }else if(h>100)
        {
          d.setHealth(100);
        }
      }else if(t.equals("whitemage"))
      {
        int h= wm.getHealth()+40;
        if(h<100)
        {
          wm.setHealth(h);
        }else if(h>100)
        {
          wm.setHealth(100);
        }
      }else if(t.equals("blackmage"))
      {
        int h= bm.getHealth()+40;
        if(h<100)
        {
          bm.setHealth(h);
        }else if(h>100)
        {
          bm.setHealth(100);
        }
      }else if(t.equals("ninja"))
      {
        int h= w.getHealth()+40;
        if(h<100)
        {
          n.setHealth(h);
        }else if(h>100)
        {
          n.setHealth(100);
        }
      }
    }else if(magicType.equals("protect"))
    {
      if(t.equals("warrior"))
      {
        int h= w.getTotalDefence()+2;
        w.setTotalDefence(h);
      }else if(t.equals("dragoon"))
      {
        int h= d.getTotalDefence()+2;
        d.setTotalDefence(h);
      }else if(t.equals("whitemage"))
      {
        int h= wm.getTotalDefence()+2;
        wm.setTotalDefence(h);
      }else if(t.equals("blackmage"))
      {
        int h= bm.getTotalDefence()+2;
        bm.setTotalDefence(h);
      }else if(t.equals("ninja"))
      {
        int h= n.getTotalDefence()+2;
        n.setTotalDefence(h);
      }
    }else if(magicType.equals("reflect"))
    {
      if(t.equals("warrior"))
      {
        int h= w.getTotalDefence()+2;
        w.setTotalDefence(h);
      }else if(t.equals("dragoon"))
      {
        int h= d.getTotalDefence()+2;
        d.setTotalDefence(h);
      }else if(t.equals("whitemage"))
      {
        int h= wm.getTotalDefence()+2;
        wm.setTotalDefence(h);
      }else if(t.equals("blackmage"))
      {
        int h= bm.getTotalDefence()+2;
        bm.setTotalDefence(h);
      }else if(t.equals("ninja"))
      {
        int h= n.getTotalDefence()+2;
        n.setTotalDefence(h);
      }
    }else if(magicType.equals("berserk"))
    {
      if(t.equals("warrior"))
      {
        int h= w.getStrength()+5;
        w.setStrength(h);
      }else if(t.equals("dragoon"))
      {
        int h= d.getStrength()+5;
        d.setStrength(h);
      }else if(t.equals("whitemage"))
      {
        int h= wm.getStrength()+5;
        wm.setStrength(h);
      }else if(t.equals("blackmage"))
      {
        int h= bm.getStrength()+5;
        bm.setStrength(h);
      }else if(t.equals("ninja"))
      {
        int h= n.getStrength()+5;
        n.setStrength(h);
      }
    }else if(magicType.equals("rise"))
    {
      if(t.equals("warrior"))
      {
        w.setHealth(100);
        w.setIsAlive();
      }else if(t.equals("dragoon"))
      {
        d.setHealth(100);
        d.setIsAlive();
      }else if(t.equals("whitemage"))
      {
        wm.setHealth(100);
        wm.setIsAlive();
      }else if(t.equals("blackmage"))
      {
        bm.setHealth(100);
        bm.setIsAlive();
      }else if(t.equals("ninja"))
      {
        n.setHealth(100);
        n.setIsAlive();
      }
    }
  }
	/**
	 * @param x
	 *            the move number that was selected by player to be performed
	 * 
	 * @return a string that logic uses to get what move was performed
	 */
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
      y="cure";
    }else if(x==4)
    {
      y="protect";
    }else if(x==5)
    {
      y="reflect";
    }else if(x==6)
    {
      y="rise";
    }else if(x==7)
    {
      y="berserk";
    }else
    {
      y="";
    }
    return y;
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
  
}
