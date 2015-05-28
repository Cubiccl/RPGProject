package main;

import main.game.Game;

public class RPGProject
{
	/** The main game */
	private static Game game;

	/** Called when starting the program. */
	public static void main(String[] args)
	{
		game = new Game();
		game.start();
	}

}
