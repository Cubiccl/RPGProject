package main.graphics.states;

import java.awt.Graphics;

public class StateManager {
	public static final byte MENU = 0, GAME = 1, KEYS = 2;

	private byte selectedState;
	private MainMenuState stateMenu;
	private GameState stateGame;
	private KeysState stateKeys;
	private State[] states;

	public StateManager(byte state) {
		this.selectedState = state;

		this.stateMenu = new MainMenuState();
		this.stateGame = new GameState();
		this.stateKeys = new KeysState();

		this.states = new State[3];
		this.states[MENU] = this.stateMenu;
		this.states[GAME] = this.stateGame;
		this.states[KEYS] = this.stateKeys;
	}

	public void setState(byte state) {
		this.selectedState = state;
	}

	public void render(Graphics g) {
		this.states[this.selectedState].render(g);
	}

	public void update() {
		this.states[this.selectedState].update();
	}

}
