package main;

import main.game.Game;
import main.graphics.Display;

public class RPGProject {
	/** The main game */
	private static Game game;

	/** Called when starting the program. */
	public static void main(String[] args) {
		game = new Game();
		game.start();
	}

	public static Display getWindow() {
		return getGame().getWindow();
	}

	public static Game getGame() {
		return game;
	}

}
