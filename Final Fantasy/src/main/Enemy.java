package main;


/**
 * @author Nathan Pereira
 *
 */
public class Enemy {
  
  private int health;
  private int totalDefence;
  private int attackPower;
  private boolean isAlive=true;
  public Enemy(int h, int d, int ap)
  {
    health=h;
    totalDefence=d;
    attackPower=ap;
  }
  
  public void attackc(Character c){
    c.damageTaken(attackPower);
  }
  public void attackd(Dragoon d){
    d.damageTaken(attackPower);
  }
  public void attackwm(WhiteMage wm){
    wm.damageTaken(attackPower);
  }
  public void attackbm(BlackMage bm){
    bm.damageTaken(attackPower);
  }
  public void attackn(Ninja n){
    n.damageTaken(attackPower);
  }
  
  
  public void damageTaken(int attackPower) { 
    
    int damage = attackPower-totalDefence;
    if(damage>0)
    {
    this.health=this.health-damage;
    }
    if(health<=0)
    {
      isAlive=false;
    }
  }
  public boolean isAlive()
  {
   if(isAlive==true)
   {
    return true;
   }else if(isAlive==false)
   {
     return false;
   }else
   {
     return false;
   }
  }
 public int getHealth()
 {
   return health;
 }
   /**
   * @return the totalDefence
   */
  public int getTotalDefence() {
    return totalDefence;
  }
}
