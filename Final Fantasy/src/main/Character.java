package main;



public class Character {
  private int health;
  private int level;
  private int strength ;
  private int totalDefence;
  private int weaponValue;
  private boolean isAlive=true;
  public Character(int h,int s,int d,int w)
  {
    this.health = h;
    this.level = 5;
    this.strength=s;
    this.totalDefence=d;
    this.weaponValue=w;
  }
  public void attack(Enemy e)
  {
    int attackPower = weaponValue + (strength / 4) + (level / 4); 
    e.damageTaken(attackPower);
  }
  public void defend()
  {
    totalDefence=totalDefence+5;
  }
  public void damageTaken(int attackPower)
  {
    int damage = attackPower-totalDefence;
    if(damage>0)
    {
    health=health-damage;
    }
    if(health<=0)
    {
      isAlive=false;
    }
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
  /**
   * @return the level
   */
  public int getLevel() {
    return level;
  }
  /**
   * This is a desciption
   * 
   * This is a bigger description of what this method does
   * 
   * @param level the level to set
   */
  public void setLevel(int level) {
    this.level = level;
  }
  /**
   * @return the strength
   */
  public int getStrength() {
    return strength;
  }
  /**
   * @param strength the strength to set
   */
  public void setStrength(int strength) {
    this.strength = strength;
  }
  /**
   * @return the totalDefence
   */
  public int getTotalDefence() {
    return totalDefence;
  }
  /**
   * @param totalDefence the totalDefence to set
   */
  public void setTotalDefence(int totalDefence) {
    this.totalDefence = totalDefence;
  }
  /**
   * @return the weaponValue
   */
  public int getWeaponValue() {
    return weaponValue;
  }
  /**
   * @param weaponValue the weaponValue to set
   */
  public void setWeaponValue(int weaponValue) {
    this.weaponValue = weaponValue;
  }
  /**
   * @return the health
   */
  public int getHealth() {
    return health;
  }
  /**
   * @param health the health to set
   */
  public void setHealth(int health) {
    this.health = health;
  }
  public void setIsAlive(Boolean b)
  {
    isAlive=true;
  }
  //Testing
  public static void main(String[] args) {
  }
}
