package main;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * Class that is used for playing as a ninja
 * 
 */
public class Ninja extends Character {
	/**
	 * See Character for constructor information
	 */
	public Ninja(int h, int s, int d, int w) {
		super(h, s, d, w);
	}

	/**
	 * Calculates attack power(Times two due to duel wielding) based on weapon
	 * value,strength and, level and use that number to deal damage to enemy
	 * selected
	 * 
	 * @param e
	 * Enemy that the player has select to hit
	 */
	public void attack(Enemy e) {
		int attackPower = (super.getWeaponValue() + (super.getStrength() / 4) + (super
				.getLevel() / 4)) * 2;
		e.damageTaken(attackPower);
	}
}
