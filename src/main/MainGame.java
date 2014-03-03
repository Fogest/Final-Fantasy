/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import javax.swing.JFrame;

/**
 * @author Justin
 */
public class MainGame {

	/**
	 * Calls run when a new maingame is created
	 */
	public MainGame() {
		run();
	}

	private boolean menu = true;
	private Sound background;
	private Sound battle;
	private Sound victory;
	private long reportedFramerate;
	private boolean isLoad = true;
	private boolean isMenu = true;

	private int width = 615;
	private int height = 1024;

	/**
	 * Creates a new main game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainGame();
	}

	/**
	 * Runs the whole game and handles the logic of switching panels
	 */
	public void run() {
		boolean BattleScene = false;
		boolean hasWon = true;
		boolean showWin = false;
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
			while (isMenu == true && isLoad == true) {
				menu.run();
				this.isMenu = menu.isMenu();
				this.isLoad = menu.isLoad();
			}
			if (isMenu == false && isLoad == true) {
				menu.load();
				menu.setLoad(false);
				background = new Sound("bg");
				background.play();
				this.isMenu = menu.isMenu();
				this.isLoad = menu.isLoad();
				frame.getContentPane().remove(menu);
				menu = null;
				frame.getContentPane().add(grid);
				frame.repaint();
				frame.setVisible(true);
				grid.repaint();
				victory = new Sound("win");
				battle = new Sound("battle");
			}
			while (isMenu == false && isLoad == false) {
				// save the start time
				frameStart = System.currentTimeMillis();
				// System.out.println(hasWon);
				if (BattleScene == false && hasWon == true && showWin == false) {
					if (grid.isBattle() == false) {
						grid.run();
					}
					else if (grid.isBattle() == true) {

						Battle = new BattlePanel(grid.getCurBlockType());
						frame.getContentPane().remove(grid);
						BattleScene = true;
						frame.add(Battle);
						frame.repaint();
						frame.pack();
						frame.setVisible(true);
						Battle.repaint();
						background.stop();
						battle.play();
					}
				}
				else if (BattleScene == true && hasWon == true
						&& showWin == false) {
					Battle.run();
					showWin = Battle.isBattleWon();
					if (showWin == true) {
						BattleScene = false;
					}

					if (Battle.isGameOver() == true) {
						battle.stop();
						hasWon = Battle.isBattleWon();
						BattleScene = false;
						frame.getContentPane().remove(Battle);
						System.exit(1);
					}
				}
				else if (BattleScene == false && hasWon == false
						&& showWin == false) {
					battle.stop();
					System.exit(1);

				}
				else if (BattleScene == false && hasWon == true
						&& showWin == true) {
					frame.getContentPane().remove(Battle);
					Battle = null;
					background.stop();
					victory.play();
					frame.getContentPane().add(grid);
					frame.repaint();
					grid.repaint();
					BattleScene = false;
					showWin = false;
					grid.resetRandom();
					grid.setBattle(false);
					battle.stop();
					try {
						Thread.sleep(4000);
					}
					catch (InterruptedException e) {
						break;
					}
					victory.stop();
					try {
						Thread.sleep(2000);
					}
					catch (InterruptedException e) {
						break;
					}
					background.play();
				}
				// calculate the time it took to render the frame
				elapsedTime = System.currentTimeMillis() - frameStart;
				// sync the framerate
				try {
					// make sure framerate milliseconds have passed this frame
					if (elapsedTime < framerate) {
						Thread.sleep(framerate - elapsedTime);
					}
					else {
						// don't starve the garbage collector
						Thread.sleep(5);
					}
				}
				catch (InterruptedException e) {
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

	/**
	 * @return if is currently in menu or not.
	 */
	public boolean isMenu() {
		return menu;
	}

	/**
	 * @param menu
	 * In menu or not?
	 */
	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
