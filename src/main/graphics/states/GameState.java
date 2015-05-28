package main.graphics.states;

import java.awt.Graphics;

import main.game.terrain.Tiles;

public class GameState extends State {

	@Override
	public void render(Graphics g) {
		Tiles.black.renderAt(g, 0, 0);
		Tiles.grass.renderAt(g, 32, 0);
		Tiles.grassRock.renderAt(g, 0, 32);
	}

	@Override
	public void update() {
	}

}
