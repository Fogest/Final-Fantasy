package main;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Claas that is used for the base of the more specialized characters,
 * also used to represent a warrior in battle
 * 
 */
public class Character {
	private int health;
	private int level;
	private int strength;
	private int totalDefence;
	private int weaponValue;
	private boolean isAlive = true;

	/**
	 * @param h
	 * used to set initial health value
	 * @param s
	 * used to set initial strength value
	 * @param d
	 * used to set initial defence value
	 * @param w
	 * used to set weapon value
	 */
	public Character(int h, int s, int d, int w) {
		this.health = h;
		this.level = 5;
		this.strength = s;
		this.totalDefence = d;
		this.weaponValue = w;
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param e
	 * Enemy that the player has select to hit
	 */
	public void attack(Enemy e) {
		int attackPower = weaponValue + (strength / 4) + (level / 4);
		e.damageTaken(attackPower);
	}

	public void defend() {
		totalDefence = totalDefence + 5;
	}

	/**
	 * lowers characters health based on attack power and defence and checks if
	 * character is dead
	 * 
	 * @param attackPower
	 * the amount of damage that would be taken if player had no
	 * defense
	 */
	public void damageTaken(int attackPower) {
		int damage = attackPower - totalDefence;
		if (damage > 0) {
			health = health - damage;
		}
		if (health <= 0) {
			isAlive = false;
		}
	}

	/**
	 * @param x
	 * the move number that was selected by player to be performed
	 * 
	 * @return a string that logic uses to get what move was preformed
	 */
	public String getCommand(int x) {
		String y;
		if (x == 1) {
			y = "attack";
		}
		else if (x == 2) {
			y = "defend";
		}
		else {
			y = "";
		}
		return y;
	}

	/**
	 * @return a boolean true if alive, false if not
	 */
	public boolean isAlive() {
		if (isAlive == true) {
			return true;
		}
		else if (isAlive == false) {
			return false;
		}
		else {
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
	 * @param level
	 * the level to set
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
	 * @param strength
	 * the strength to set
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
	 * @param totalDefence
	 * the totalDefence to set
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
	 * @param weaponValue
	 * the weaponValue to set
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
	 * @param health
	 * the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Sets the isAlive boolean if health is above 0 it sets it to true else it
	 * turns false
	 */
	public void setIsAlive() {
		if (getHealth() <= 0) {
			isAlive = false;
		}
		else {
			isAlive = true;
		}
	}

	// Testing
	public static void main(String[] args) {
	}
}
