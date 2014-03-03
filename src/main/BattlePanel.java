package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//June 18 2012
/**
 * @author Nathan Pereira
 * 
 * is the main class that handels user input and graphics for the actions
 * performed
 */
public class BattlePanel extends JPanel implements MouseListener, KeyListener {
	private BufferedImage battlelayout = ImageHelper
			.loadImage("images/Battlemenu.png");
	private BufferedImage background2 = ImageHelper
			.loadImage("images/backgroundsprite.png");
	private BufferedImage[] background = ImageHelper.splitImage(background2, 9,
			1);
	private char x;
	private int currentc = 1;
	private String currenth = "warrior";
	private int currente = 1;
	private BlackMageGraphics bm = new BlackMageGraphics();
	private WarriorGraphics w = new WarriorGraphics();
	private WhiteMageGraphics wm = new WhiteMageGraphics();
	private DragoonGraphics d = new DragoonGraphics();
	private NinjaGraphics n = new NinjaGraphics();
	private EnemyGraphics e = new EnemyGraphics();
	private Logic logic = new Logic(100, 5, 10);
	Dimension screenSize = new Dimension(1024, 580);

	/**
	 * Sets mouse listener and key listener, also set panel size
	 * 
	 * @param x
	 * character that tells the constructor what background to display
	 */
	public BattlePanel(char x) {
		this.x = x;
		this.addMouseListener(this);
		this.addKeyListener(this);
		setPreferredSize(screenSize);
	}

	/**
	 * Checks if enemy is alive
	 * 
	 * Checks if enemy is alive and changes the enemy that the user has selected
	 * to an enemy that is currently alive
	 */
	public void run() {
		if (logic.getEnemyState(0) == false && currente == 1) {
			currente = 2;
		}
		if (logic.getEnemyState(1) == false && currente == 2) {
			currente = 3;
		}
		if (logic.getEnemyState(2) == false && currente == 3) {
			currente = 1;
		}
		repaint();
	}

	/*
	 * (non-Javadoc) Main battle screen paint method
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 1024, 576);
		g.drawImage(battlelayout, 0, 0, 1024, 580, null);
		Font big = new Font("SansSerif", Font.BOLD, 20);
		g.setFont(big);
		g.setColor(Color.white);
		if (x == 'g') {
			g.drawImage(background[0], 0, 0, 1024, 390, null);
		}
		else if (x == 'r') {
			g.drawImage(background[1], 0, 0, 1024, 390, null);
		}
		else if (x == 'd') {
			g.drawImage(background[2], 0, 0, 1024, 390, null);
		}
		else if (x == 'm') {
			g.drawImage(background[3], 0, 0, 1024, 390, null);
		}
		else if (x == 'c') {
			g.drawImage(background[4], 0, 0, 1024, 390, null);
		}
		else if (x == 'w') {
			g.drawImage(background[5], 0, 0, 1024, 390, null);
		}
		else if (x == 'x') {
			g.drawImage(background[6], 0, 0, 1024, 390, null);
		}
		else if (x == 'b') {
			g.drawImage(background[7], 0, 0, 1024, 390, null);
		}
		else if (x == 's') {
			g.drawImage(background[8], 0, 0, 1024, 390, null);
		}

		if (logic.getPartyState(1)) {
			bm.setStand(g);
			g.drawString("Black Mage  " + logic.getPartyHealth(1) + " HP", 715,
					430);
			if (currentc == 1) {
				bm.setMenu(g);
				repaint();
			}
		}
		if (logic.getPartyState(2)) {
			n.setStand(g);
			g.drawString("Ninja  " + logic.getPartyHealth(2) + " HP", 715, 460);
			if (currentc == 2) {
				n.setMenu(g);
				repaint();
			}
		}
		if (logic.getPartyState(3)) {
			w.setStand(g);
			g.drawString("Warrior " + logic.getPartyHealth(3) + " HP", 715, 490);
			if (currentc == 3) {
				w.setMenu(g);
				repaint();
			}
		}
		if (logic.getPartyState(4)) {
			d.setStand(g);
			g.drawString("Dragoon  " + logic.getPartyHealth(4) + " HP", 715,
					520);
			if (currentc == 4) {
				d.setMenu(g);
				repaint();
			}
		}
		if (logic.getPartyState(5)) {
			wm.setStand(g);
			g.drawString("White Mage  " + logic.getPartyHealth(5) + " HP", 715,
					550);
			if (currentc == 5) {
				wm.setMenu(g);
				repaint();
			}
		}

		if (logic.getEnemyState(0)) {
			e.drawHead(g);
			g.drawString("Head  " + logic.getEnemyHealth(0) + " HP", 50, 430);
		}
		if (logic.getEnemyState(1)) {
			e.drawTroll(g);
			g.drawString("Troll  " + logic.getEnemyHealth(1) + " HP", 50, 480);
		}
		if (logic.getEnemyState(2)) {
			e.drawCaptain(g);
			g.drawString("Captain  " + logic.getEnemyHealth(2) + " HP", 50, 530);
		}
	}

	/*
	 * (non-Javadoc) Handles the mouse actions and performs the action that the
	 * user has selected
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		// column 1
		if ((x < 520) && (x > 390)) {
			// row one
			if ((y < 450) && (y > 425)) {
				logic.performAction(currentc, 1, currente, currenth);
				repaint();
			}
			else
			// row two
			if ((y < 490) && (y > 460)) {
				logic.performAction(currentc, 3, currente, currenth);
				repaint();
			}
			else
			// row three
			if ((y < 525) && (y > 495)) {
				logic.performAction(currentc, 5, currente, currenth);
				repaint();
			}
			else
			// row four
			if ((y < 560) && (y > 530)) {
				logic.performAction(currentc, 7, currente, currenth);
				repaint();
			}
		}
		else
		// column 2
		if ((x > 535) && (x < 650)) {
			// row one
			if ((y < 450) && (y > 425)) {
				if (logic.getPartyState(currentc)) {
					logic.performAction(currentc, 2, currente, currenth);
				}
				repaint();
			}
			else
			// row two
			if ((y < 490) && (y > 460)) {
				logic.performAction(currentc, 4, currente, currenth);
				repaint();
			}
			else
			// row three
			if ((y < 525) && (y > 495)) {
				logic.performAction(currentc, 6, currente, currenth);
				repaint();
			}
		}
		else if (x > 210 && x < 345) {
			if (y > 75 && y < 215) {
				currente = 0;
			}
			else if (y > 215 && y < 350) {
				currente = 1;
			}
		}
		else if (x > 50 && x < 185) {
			if (y > 130 && y < 275) {
				currente = 2;
			}
		}
		else if (x > 770 && x < 815) {
			if (y > 65 && y < 135) {
				currentc = 1;
			}
			else if (y > 165 && y < 240) {
				currentc = 3;
			}
			else if (y > 310 && y < 385) {
				currentc = 5;
			}
		}
		else if (x > 845 && x < 895) {
			if (y > 95 && y < 175) {
				currentc = 2;
			}
			else if (y > 240 && y < 317) {
				currentc = 4;
			}
		}
		repaint();
	}

	/**
	 * Checks if battle is over
	 * 
	 * @return true if user has won, False if game is still going on
	 */
	public boolean isGameOver() {
		return logic.isGameOver();
	}

	/**
	 * Checks if battle is won
	 * 
	 * @return true if user has won, False if game is still going on
	 */
	public boolean isBattleWon() {
		return logic.isBattleWon();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent paramMouseEvent) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent paramMouseEvent) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent paramMouseEvent) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent paramMouseEvent) {
	}

	/*
	 * (non-Javadoc) changes who the white mage buffs based on key pressed
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent paramKeyEvent) {
		int id = paramKeyEvent.getKeyCode();
		if (id == KeyEvent.VK_Q) {
			currenth = "blackmage";
		}
		else if (id == KeyEvent.VK_W) {
			currenth = "ninja";
		}
		else if (id == KeyEvent.VK_E) {
			currenth = "warrior";
		}
		else if (id == KeyEvent.VK_R) {
			currenth = "dragoon";
		}
		else if (id == KeyEvent.VK_T) {
			currenth = "whitemage";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent paramKeyEvent) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent paramKeyEvent) {

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Final Fantasy");
		BattlePanel p = new BattlePanel('x');
		p.run();
		frame.add(p);
		frame.setSize(1024, 615);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(p);
	}

}
