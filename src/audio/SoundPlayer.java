package audio;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/** An object that constently plays a BGM in the url. */
public class SoundPlayer implements Runnable {

	private Player currentplayer;
	private boolean ischanging;
	
	/** Creates a SoundPlayer object. */
	public SoundPlayer() {
		this.currentplayer = null;
		this.ischanging = false;
	}

	@Override
	public void run() {
		while (true) {
			// Tries 10 times a second
			main.Utils.wait(100);
			if (!this.ischanging) {
				try {
					this.currentplayer.play();
				} catch (Exception e) {
				}
			}
		}
	}

	/** Plays a sound in .mp3 format. */
	public void playSound(String url) {
		this.ischanging = true;
		try {
			this.currentplayer.close();
		} catch (Exception e) {
		}
		try {
			FileInputStream fis = new FileInputStream(url);
			this.currentplayer = new Player(fis);
		} catch (Exception e) {
			if (url != null) {
				System.err
						.println("Erreur lors de l'ouverture du fichier son.");
				e.printStackTrace();
			}
		} finally {
			this.ischanging = false;
		}
	}

}