package main;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 *         Claas that is used for playing as a dragoon
 * 
 */
public class Dragoon extends Character {

	/**
	 * See Character for constructor information
	 */
	public Dragoon(int h, int s, int d, int w) {
		super(h, s, d, w);
	}

	/**
	 * A more powerful version of attack
	 * 
	 * @param e
	 *            Enemy that the player has selected
	 */
	public void Jump(Enemy e) {
		int attackPower = super.getWeaponValue() + super.getStrength()
				+ (super.getLevel() / 4);
		e.damageTaken(attackPower);
	}

	/**
	 * @param x
	 *            the move number that was selected by player to be performed
	 * 
	 * @return a string that logic uses to get what move was preformed
	 */
	public String getCommand(int x) {
		String y;
		if (x == 1) {
			y = "attack";
		} else if (x == 2) {
			y = "defend";
		} else if (x == 3) {
			y = "jump";
		} else {
			y = "";
		}
		return y;
	}

}
