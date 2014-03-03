package main;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Justin
 * 
 */
public class Sound {
	Clip soundClip;

	/**
	 * Creates a loads a new sound clip
	 * 
	 * @param soundFile
	 * File name of the sound clip EXCLUDING the extension name
	 */
	public Sound(String soundFile) {
		try {
			File file = new File("Sounds\\" + soundFile + ".mid");
			soundClip = AudioSystem.getClip();
			soundClip.open(AudioSystem.getAudioInputStream(file));
		}
		catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Starts playback of a soundtrack and loops 3 times. 3 times should be
	 * enough in this case!
	 */
	public void play() {
		soundClip.loop(3);
	}

	/**
	 * Stops (pauses) the sound clip
	 */
	public void stop() {
		soundClip.stop();
	}
}
