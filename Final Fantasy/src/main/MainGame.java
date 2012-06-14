/**
 * @Documentation : https://trello.com/b/X6XHMpJl
 */
package main;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Justin
 * 
 * MainGame
 * 
 */
public class MainGame {

	/**
	 * Main Class
	 * 
	 * Handles the core game aspects
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean BattleScene = false;
		boolean hasWon = true;
		JFrame frame = new JFrame("Final Fantasy");
		GridPanel grid = new GridPanel("overworld");
		BattlePanel Battle = null;
		frame.setSize(1024, 615);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(grid);
		frame.addKeyListener(grid);

		Sound s = new Sound();
		s.init();
		
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
		long reportedFramerate;
		while (true) {
			// save the start time
			frameStart = System.currentTimeMillis();
			if (BattleScene == false && hasWon == true) {
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
			} else if (BattleScene == true && hasWon == true) {
				Battle.run();
				if (Battle.isGameOver() == true) {
					// hasWon = Battle.isBattleWon();
					BattleScene = false;
					Battle = null;
					frame.getContentPane().remove(Battle);
				}
			} else if (BattleScene == false && hasWon == false) {
				Battle = null;
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
				//repaint();
				frameCount = 0;
				totalElapsedTime = 0;
			}
		}
	}
	public void paintComponent(Graphics g) {
		
	}
}
