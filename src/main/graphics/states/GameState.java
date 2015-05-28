package main.graphics.states;

import java.awt.Graphics;

import main.game.terrain.Map;

public class GameState extends State {

	private Map map;

	public GameState() {
		this.map = new Map();
		this.map.initFrom("res/maps/1-1.map");
	}

	@Override
	public void render(Graphics g) {
		this.map.render(g);
	}

	@Override
	public void update() {
		this.map.update();
	}

}
