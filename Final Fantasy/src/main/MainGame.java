/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Justin
 * 
 *         MainGame
 * 
 */
public class MainGame {

	public MainGame() {
		run();
	}

	private boolean menu = true;
	private Sound background;
	private long reportedFramerate;
	private boolean isLoad = true;
	private boolean isMenu = true;

	/**
	 * Main Class
	 * 
	 * Handles the core game aspects
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MainGame m = new MainGame();
	}

	public void run() {
		boolean BattleScene = false;
		boolean hasWon = true;
		boolean showWin = false;
		boolean load = true;
		JFrame frame = new JFrame("Final Fantasy");
		GridPanel grid = new GridPanel("overworld");
		BattlePanel Battle = null;
		Menu menu = new Menu();
		frame.setSize(1024, 615);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(menu);
		frame.addKeyListener(grid);
		frame.addMouseListener(menu);
		frame.addMouseMotionListener(menu);

		long framerate = 1000 / 60;
		// time the frame began
		long frameStart;
		// number of frames counted this second
		long frameCount = 0;
		// time elapsed during one frame
		long elapsedTime;
		// accumulates elapsed time over multiple frames
		long totalElapsedTime = 0;
		// the actual calculated framerate reported
		
		
		while (true) {
			while(isMenu == true && isLoad == true) {
				menu.run();
				this.isMenu = menu.isMenu();
				this.isLoad = menu.isLoad();
			}
			if(isMenu == false && isLoad == true) {
				menu.load();
				menu.setLoad(false);
			    background = new Sound("bg");
			    background.playBG();
			    this.isMenu = menu.isMenu();
				this.isLoad = menu.isLoad();
			    frame.getContentPane().remove(menu);
			    menu = null;
			    frame.getContentPane().add(grid);
			    frame.repaint();
			    frame.setVisible(true);
			    grid.repaint();
			    System.out.println("sup");
			}
			while (isMenu == false && isLoad == false) {
				// save the start time
				frameStart = System.currentTimeMillis();
				// System.out.println(hasWon);
				if (BattleScene == false && hasWon == true && showWin == false) {
					if (grid.isBattle() == false) {
						grid.run();
					} else if (grid.isBattle() == true) {

						Battle = new BattlePanel(grid.getCurBlockType());
						frame.getContentPane().remove(grid);
						BattleScene = true;
						System.out.println("BattleScene it's your turn!");
						frame.add(Battle);
						frame.repaint();
						frame.pack();
						frame.setVisible(true);
						Battle.repaint();
					}
				} else if (BattleScene == true && hasWon == true
						&& showWin == false) {
					Battle.run();
					showWin = Battle.isBattleWon();
					if (showWin == true) {
						BattleScene = false;
					}

					if (Battle.isGameOver() == true) {
						hasWon = Battle.isBattleWon();
						BattleScene = false;
						Battle = null;
						frame.getContentPane().remove(Battle);
					}
				} else if (BattleScene == false && hasWon == false
						&& showWin == false) {
					Battle = null;
				} else if (BattleScene == false && hasWon == true
						&& showWin == true) {
					frame.getContentPane().remove(Battle);
					Battle = null;
					Sound sound = new Sound("win");
					background.stopBG();
					sound.playVictory();
					frame.getContentPane().add(grid);
					frame.repaint();
					grid.repaint();
					BattleScene = false;
					showWin = false;
					grid.resetRandom();
					grid.setBattle(false);
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						break;
					}
					sound.stopVictory();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						break;
					}
					background.playBG();
				}
				// calculate the time it took to render the frame
				elapsedTime = System.currentTimeMillis() - frameStart;
				// sync the framerate
				try {
					// make sure framerate milliseconds have passed this frame
					if (elapsedTime < framerate) {
						Thread.sleep(framerate - elapsedTime);
					} else {
						// don't starve the garbage collector
						Thread.sleep(5);
					}
				} catch (InterruptedException e) {
					break;
				}
				++frameCount;
				totalElapsedTime += (System.currentTimeMillis() - frameStart);
				if (totalElapsedTime > 1000) {
					reportedFramerate = (long) ((double) frameCount
							/ (double) totalElapsedTime * 1000.0);
					// show the framerate in the applet status window
					System.out.println("fps: " + reportedFramerate);
					// repaint();
					frameCount = 0;
					totalElapsedTime = 0;
				}
			}
		}
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}
}
