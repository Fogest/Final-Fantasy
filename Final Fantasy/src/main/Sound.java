package main;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	Clip background;

	public void init(String soundFile) {

		try {
			File file = new File("Sounds\\"+ soundFile +".mid");
			background = AudioSystem.getClip();
			background.open(AudioSystem.getAudioInputStream(file));
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void playBG() {
		background.start();
	}

	public void stopBG() {
		background.stop();
	}

	public static void main(String[] args) {
		Sound s = new Sound();
		s.init();
		while (true) {
			s.playBG();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
