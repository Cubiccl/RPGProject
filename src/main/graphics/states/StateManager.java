package main.graphics.states;

import java.awt.Graphics;

public class StateManager
{
	public static final byte MENU = 0, GAME = 1;

	private byte state;
	private MenuState stateMenu;
	private GameState stateGame;

	public StateManager(byte state)
	{
		this.state = state;

		this.stateMenu = new MenuState();
		this.stateGame = new GameState();
	}

	public void setState(byte state)
	{
		this.state = state;
	}

	public void render(Graphics g)
	{
		switch (this.state)
		{
			case MENU:
				this.stateMenu.render(g);
				break;

			case GAME:
				this.stateGame.render(g);

			default:
				break;
		}
	}

	public void update()
	{
		switch (this.state)
		{
			case MENU:
				this.stateMenu.update();
				break;

			case GAME:
				this.stateGame.update();

			default:
				break;
		}
	}

}
