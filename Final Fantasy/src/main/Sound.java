package main;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	Clip soundClip;

	public Sound(String soundFile) {

		try {
			File file = new File("Sounds\\" + soundFile + ".mid");
			soundClip = AudioSystem.getClip();
			soundClip.open(AudioSystem.getAudioInputStream(file));
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
		soundClip.start();
	}

	public void stopBG() {
		soundClip.stop();
	}

	public void playBattleMusic() {
		soundClip.start();
	}

	public void stopBattleMusic() {
		soundClip.stop();
	}

	public void playVictory() {
		soundClip.start();
	}

	public void stopVictory() {
		soundClip.stop();
	}
}
