package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Justin
 * 
 */

public class Menu extends JPanel implements MouseListener, MouseMotionListener {

	private boolean credits;
	private boolean main;

	private boolean isMenu = true;

	private int posX = 750;
	private int posY = 450;

	private Font f1 = new Font("Arial", Font.PLAIN, 30);
	private Font f2 = new Font("Arial", Font.PLAIN, 30);
	private Font f3 = new Font("Arial", Font.PLAIN, 30);

	private Font creditFont = new Font("Arial", Font.PLAIN, 20);

	private int l1 = posX + 145;
	private int l2 = posX + 95;
	private int l3 = posX + 60;

	private int mousePosX = 0;
	private int mousePosY = 0;

	private boolean load = true;

	private BufferedImage splash;

	/**
	 * Loads in splash image when the menu is created
	 */
	public Menu() {
		try {
			splash = ImageIO.read(new File("images/splash.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCredits(false);
		setMain(true);
	}

	/**
	 * Mouse Checks
	 */
	public void run() {
		if ((getMousePosX() > posX) && (getMousePosX() < posX + 145)
				&& (getMousePosY() > posY) && (getMousePosY() < posY + 30)) {
			setF1(new Font("Arial", Font.BOLD, 30));
		} else {
			setF1(new Font("Arial", Font.PLAIN, 30));
		}

		if ((getMousePosX() > posX) && (getMousePosX() < posX + 95)
				&& (getMousePosY() > posY + 31) && (getMousePosY() < posY + 60)) {
			setF2(new Font("Arial", Font.BOLD, 30));
		} else {
			setF2(new Font("Arial", Font.PLAIN, 30));
		}
		if ((getMousePosX() > posX) && (getMousePosX() < posX + 60)
				&& (getMousePosY() > posY + 61) && (getMousePosY() < posY + 90)) {
			setF3(new Font("Arial", Font.BOLD, 30));
		} else {
			setF3(new Font("Arial", Font.PLAIN, 30));
		}
		repaint();
	}

	/**
	 * What to be done on menu load.
	 */
	public void load() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawRect(0, 0, 1024, 615);
		g.drawImage(splash, -10, 0, 1024, 615, null);

		if (isMain()) {
			g.setColor(Color.BLACK);

			g.drawLine(posX, posY, l1, posY);
			g.setFont(f1);
			g.drawString("Play Game", posX, posY);

			g.drawLine(posX, posY + 30, l2, posY + 30);
			g.setFont(f2);
			g.drawString("Credits", posX, posY + 30);

			g.drawLine(posX, posY + 60, l3, posY + 60);
			g.setFont(f3);
			g.drawString("Exit", posX, posY + 60);

		} else if (isCredits()) {
			g.setColor(Color.BLACK);

			g.setFont(creditFont);
			g.drawString("Programmer 1: Justin Visser", posX, posY);

			g.setFont(creditFont);
			g.drawString("Programmer 2: Nathan", posX, posY + 30);

			g.setFont(creditFont);
			g.drawString("Back", posX, posY + 60);
		}

	}

	/**
	 * @return true if in menu, false if not
	 */
	public boolean isMenu() {
		return isMenu;
	}

	/**
	 * @param menu
	 *            If in menu or not
	 */
	public void setMenu(boolean menu) {
		this.isMenu = menu;
	}

	/**
	 * Used to change the first set of texts font
	 * 
	 * @param f1
	 *            Set font
	 */
	public void setF1(Font f1) {
		this.f1 = f1;
	}

	/**
	 * Used to change the second set of texts font
	 * 
	 * @param f2
	 *            Set font
	 */
	public void setF2(Font f2) {
		this.f2 = f2;
	}

	/**
	 * Used to change the third set of texts font
	 * 
	 * @param f3
	 *            Set font
	 */
	public void setF3(Font f3) {
		this.f3 = f3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (isMain()) {
			if ((x > posX) && (x < posX + 145) && (y > posY) && (y < posY + 30)) {
				setMenu(false);
				setCredits(false);
				setMain(false);
			} else if ((x > posX) && (x < posX + 95) && (y > posY + 31)
					&& (y < posY + 60)) {
				setCredits(true);
				setMain(false);
			} else if ((x > posX) && (x < posX + 60) && (y > posY + 61)
					&& (y < posY + 90)) {
				System.exit(1);
			}
		}
		else if(isCredits()) {
		if ((x > posX) && (x < posX + 60) && (y > posY + 61)
				&& (y < posY + 90)) {
			setMain(true);
			setCredits(false);
		}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	public void mouseDragged(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		this.setMousePosX(x);
		this.setMousePosY(y);
	}

	/**
	 * @return X position of mouse
	 */
	public int getMousePosX() {
		return mousePosX;
	}

	/**
	 * @param mousePosX
	 *            Set X position of mouse
	 */
	public void setMousePosX(int mousePosX) {
		this.mousePosX = mousePosX;
	}

	/**
	 * @return Y position of mouse
	 */
	public int getMousePosY() {
		return mousePosY;
	}

	/**
	 * @param mousePosY
	 *            Set Y position of mouse
	 */
	public void setMousePosY(int mousePosY) {
		this.mousePosY = mousePosY;
	}

	/**
	 * @return true if loading, false if not
	 */
	public boolean isLoad() {
		return load;
	}

	/**
	 * @param load
	 *            Is loading or not?
	 */
	public void setLoad(boolean load) {
		this.load = load;
	}

	public boolean isCredits() {
		return credits;
	}

	public void setCredits(boolean credits) {
		this.credits = credits;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

}
