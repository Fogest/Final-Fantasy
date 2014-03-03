package main;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Claas that is used for representing enemies in battle
 * 
 */
public class Enemy {

	private int health;
	private int totalDefence;
	private int attackPower;
	private boolean isAlive = true;

	/**
	 * @param h
	 * used to set health value
	 * @param d
	 * used to set defence value
	 * @param ap
	 * used to set attack power
	 */
	public Enemy(int h, int d, int ap) {
		health = h;
		totalDefence = d;
		attackPower = ap;
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param c
	 * the warrior selected to be attacked
	 */
	public void attackc(Character c) {
		c.damageTaken(attackPower);
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param bm
	 * the dragoon selected to be attacked
	 */
	public void attackd(Dragoon d) {
		d.damageTaken(attackPower);
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param bm
	 * the white mage selected to be attacked
	 */
	public void attackwm(WhiteMage wm) {
		wm.damageTaken(attackPower);
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param bm
	 * the black mage selected to be attacked
	 */
	public void attackbm(BlackMage bm) {
		bm.damageTaken(attackPower);
	}

	/**
	 * Calculates attack power based on weapon value,strength and, level and use
	 * that number to deal damage to enemy selected
	 * 
	 * @param bm
	 * the ninja selected to be attacked
	 */
	public void attackn(Ninja n) {
		n.damageTaken(attackPower);
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
			this.health = this.health - damage;
		}
		if (health <= 0) {
			isAlive = false;
		}
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
	 * @return heath value
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return the totalDefence value
	 */
	public int getTotalDefence() {
		return totalDefence;
	}
}
