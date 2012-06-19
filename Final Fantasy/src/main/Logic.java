package main;

import java.util.*;

public class Logic {
	private BlackMage bm = new BlackMage(100, 5, 5, 5, 5);
	private WhiteMage wm = new WhiteMage(100, 5, 5, 5, 5);
	private Character w = new Character(100, 5, 5, 5);
	private Ninja n = new Ninja(100, 5, 5, 5);
	private Dragoon d = new Dragoon(100, 5, 5, 5);
	private Enemy[] enemy = new Enemy[3];

	public Logic(int h, int d, int ap) {
		for (int x = 0; x < 3; x++) {
			enemy[x] = new Enemy(h, d, ap);
		}
	}

	// will preform action then return what action happend to battle panel for graphics and deals with the enemy attacks
	public String performAction(int c, int t, int e, String hc) {
		for (int x = 0; x < 3; x++) {
			Random gen = new Random();
			int r = gen.nextInt(5);
			if (getEnemyState(x)) {
				if (r == 0 && getPartyState(1) != false) {
					enemy[x].attackbm(bm);
				} else if (r == 1 && getPartyState(2) != false) {
					enemy[x].attackn(n);
				} else if (r == 2 && getPartyState(3) != false) {
					enemy[x].attackc(w);
				} else if (r == 3 && getPartyState(4) != false) {
					enemy[x].attackd(d);
				} else if (r == 4 && getPartyState(5) != false) {
					enemy[x].attackwm(wm);
				}else if(getPartyState(1) != false){
					enemy[x].attackbm(bm);	
				}else if(getPartyState(2) != false){
					enemy[x].attackn(n);
				}else if(getPartyState(3) != false){
					enemy[x].attackc(w);
				}else if(getPartyState(4) != false){
					enemy[x].attackn(n);
				}else if(getPartyState(5) != false){
					enemy[x].attackwm(wm);
				}
			}
		}
		String s;
		if (c == 5) {
			s = wm.getCommand(t);
			if (s.equals("attack")) {
				wm.attack(enemy[e]);
			} else if (s.equals("defend")) {
				wm.defend();
			} else if (s.equals("cure")) {
				wm.setMagicType("cure");
				wm.magicAttack(bm, wm, d, n, w, hc);
			} else if (s.equals("protect")) {
				wm.setMagicType("protect");
				wm.magicAttack(bm, wm, d, n, w, hc);
			} else if (s.equals("reflect")) {
				wm.setMagicType("reflect");
				wm.magicAttack(bm, wm, d, n, w, hc);
			} else if (s.equals("rise")) {
				wm.setMagicType("rise");
				wm.magicAttack(bm, wm, d, n, w, hc);
			} else if (s.equals("berserk")) {
				wm.setMagicType("berserk");
				wm.magicAttack(bm, wm, d, n, w, hc);
			}
			return s;
		} else if (c == 1) {
			s = bm.getCommand(t);

			if (s.equals("attack")) {
				bm.attack(enemy[e]);
			} else if (s.equals("defend")) {
				bm.defend();
			} else if (s.equals("fire")) {
				bm.setMagicType("fire");
				bm.magicAttack(enemy, e);
			} else if (s.equals("blizzard")) {
				bm.setMagicType("blizzard");
				bm.magicAttack(enemy, e);
			} else if (s.equals("thunder")) {
				bm.setMagicType("thunder");
				bm.magicAttack(enemy, e);
			} else if (s.equals("quake")) {
				bm.setMagicType("quake");
				bm.magicAttack(enemy, e);
			} else if (s.equals("flood")) {
				bm.setMagicType("flood");
				bm.magicAttack(enemy, e);
			}
			return s;
		} else if (c == 3) {
			s = w.getCommand(t);
			if (s.equals("attack")) {
				w.attack(enemy[e]);
			} else if (s.equals("defend")) {
				w.defend();
			}
			return s;
		} else if (c == 2) {
			s = n.getCommand(t);
			if (s.equals("attack")) {
				n.attack(enemy[e]);
			} else if (s.equals("defend")) {
				n.defend();
			}
			return s;
		} else if (c == 4) {
			s = d.getCommand(t);
			if (s.equals("attack")) {
				d.attack(enemy[e]);
			} else if (s.equals("defend")) {
				d.defend();
			} else if (s.equals("jump")) {
				d.Jump(enemy[e]);
			}
			return s;
		} else {
			s = "";
			return s;
		}
	}

	public boolean getEnemyState(int i) {
		return enemy[i].isAlive();
	}

	public boolean getPartyState(int i) {
		if (i == 1) {
			bm.setIsAlive();
			return bm.isAlive();
		} else if (i == 2) {
			n.setIsAlive();
			return n.isAlive();
		} else if (i == 3) {
			w.setIsAlive();
			return w.isAlive();
		} else if (i == 4) {
			d.setIsAlive();
			return d.isAlive();
		} else if (i == 5) {
			wm.setIsAlive();
			return wm.isAlive();
		} else {
			return false;
		}
	}

	public int getEnemyHealth(int i) {
		return enemy[i].getHealth();
	}

	public int getPartyHealth(int i) {
		if (i == 1) {
			return bm.getHealth();
		} else if (i == 2) {
			return n.getHealth();
		} else if (i == 3) {
			return w.getHealth();
		} else if (i == 4) {
			return d.getHealth();
		} else if (i == 5) {
			return wm.getHealth();
		} else {
			return 50;
		}
	}

	public boolean isGameOver() {
		if (bm.isAlive() == false && n.isAlive() == false
				&& w.isAlive() == false && d.isAlive() == false
				&& wm.isAlive() == false) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBattleWon() {
		if (enemy[0].isAlive() == false && enemy[1].isAlive() == false
				&& enemy[2].isAlive() == false) {
			return true;
		} else {
			return false;
		}
	}
}