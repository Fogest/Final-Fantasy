package main;

/**
 * @author Nathan Pereira
 *
 */
public class Dragoon extends Character {


 public Dragoon(int h, int s, int d, int w) {
  super(h, s, d, w);
 }
 public void Jump(Enemy e)
 {
  int attackPower = super.getWeaponValue() + super.getStrength() + (super.getLevel()/ 4); 
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
    }else if(x==3)
    {
      y="jump";
    }else
    {
      y="";
    }
    return y;
  }
   
}
