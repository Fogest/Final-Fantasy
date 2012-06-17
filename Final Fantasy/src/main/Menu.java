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

public class Menu extends JPanel implements MouseListener,MouseMotionListener {

	private boolean isMenu = true;

	private int posX = 750;
	private int posY = 450;

	private Font f1 = new Font("Arial", Font.PLAIN, 30);
	private Font f2 = new Font("Arial", Font.PLAIN, 30);
	private Font f3 = new Font("Arial", Font.PLAIN, 30);

	private int l1 = posX + 145;
	private int l2 = posX + 95;
	private int l3 = posX + 60;
	
	private int mousePosX = 0;
	private int mousePosY = 0;
	
	private boolean load = true;

	private BufferedImage splash;

	public Menu() {
		try {
			splash = ImageIO.read(new File("images/splash.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
			if ((getMousePosX() > posX) && (getMousePosX() < posX + 145) && (getMousePosY() > posY) && (getMousePosY() < posY + 30)) {
				setF1(new Font("Arial",Font.BOLD,30));
			}
			else {
				setF1(new Font("Arial",Font.PLAIN,30));
			}
				
			if ((getMousePosX() > posX) && (getMousePosX() < posX + 95) && (getMousePosY() > posY + 31) && (getMousePosY() < posY + 60)) {
				setF2(new Font("Arial",Font.BOLD,30));
			}
			else {
				setF2(new Font("Arial",Font.PLAIN,30));
			}
			if ((getMousePosX() > posX) && (getMousePosX() < posX + 60) && (getMousePosY() > posY + 61) && (getMousePosY() < posY + 90)) {
				setF3(new Font("Arial",Font.BOLD,30));
			}
			else {
				setF3(new Font("Arial",Font.PLAIN,30));
			}
		repaint();
	}

	public void load() {

	}

	public void paintComponent(Graphics g) {

		// setF3(new Font("Arial",Font.PLAIN,20));

		g.setColor(Color.WHITE);
		g.drawRect(0, 0, 1024, 615);
		g.drawImage(splash, -10, 0, 1024, 615, null);

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

		
		//Output mouse coords.
		//g.drawString("X: " + getMousePosX() + "        Y: " + getMousePosY(), 50, 50);

	}

	public boolean isMenu() {
		return isMenu;
	}
	public void setMenu(boolean menu) {
		this.isMenu = menu;
	}

	public void setF1(Font f1) {
		this.f1 = f1;
	}

	public void setF2(Font f2) {
		this.f2 = f2;
	}

	public void setF3(Font f3) {
		this.f3 = f3;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if ((x > posX) && (x < posX + 145) && (y > posY) && (y < posY + 30)) {
			setMenu(false);
		}
		else if ((x > posX) && (x < posX + 95) && (y > posY + 31) && (y < posY + 60)) {
			
		}
		else if ((x > posX) && (x < posX + 60) && (y > posY + 61) && (y < posY + 90)) {
			System.exit(1);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		this.setMousePosX(x);
		this.setMousePosY(y);
	}

	public int getMousePosX() {
		return mousePosX;
	}

	public void setMousePosX(int mousePosX) {
		this.mousePosX = mousePosX;
	}

	public int getMousePosY() {
		return mousePosY;
	}

	public void setMousePosY(int mousePosY) {
		this.mousePosY = mousePosY;
	}

	public boolean isLoad() {
		return load;
	}

	public void setLoad(boolean load) {
		this.load = load;
	}


}
