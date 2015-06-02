package audio;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/** An object that constently plays a BGM in the url. */
public class BackgroundMusic implements Runnable {

	private String currenturl;
	private Player currentplayer;
	private boolean ischanging;

	/** Creates a BGM object. */
	public BackgroundMusic() {
		this.ischanging = false;
		this.currentplayer = null;
	}

	@Override
	public void run() {
		while (true) {
			// Tries 10 times a second
			main.Utils.wait(100);
			if (!this.ischanging) {
				try {
					if (this.currentplayer.isComplete()) {
						this.currentplayer.close();
						this.currentplayer = new Player(new FileInputStream(
								currenturl));
					}
				} catch (Exception e) {
				}
				try {
					this.currentplayer.play();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * Sets the music to be played in background. Use null to prevent the BGM to
	 * play.
	 */
	public void setmusic(String url) {
		this.ischanging = true;
		this.currenturl = url;
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
