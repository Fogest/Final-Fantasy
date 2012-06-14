package main;

/**
 * @author Nathan Pereira
 *
 */
public class Ninja extends Character  {
  public Ninja(int h,int s,int d,int w)
  {
    super(h,s,d,w);
  }
  public void attack(Enemy e)
  {
    int attackPower = (super.getWeaponValue() + (super.getStrength() / 4) + (super.getLevel() / 4))*2; 
    e.damageTaken(attackPower);
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
    }else
    {
      y="";
    }
    return y;
  }
}
