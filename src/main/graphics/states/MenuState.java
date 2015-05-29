package main.graphics.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import main.RPGProject;
import main.game.input.KeyCustom;
import main.graphics.textures.FontBuilder;

public abstract class MenuState extends State {

	private static final Color DEFAULT = Color.WHITE, SELECTED = Color.RED,
			BACKGROUND = Color.BLACK;
	private static final Font FONT = new Font("Impact", Font.PLAIN, 30);

	private int selected;
	private Font font;
	private ArrayList<MSButton> buttons;

	public MenuState() {
		this.selected = 0;
		this.buttons = new ArrayList<MSButton>();
		try {
			this.font = FontBuilder.createfont("res/font/akbaal.ttf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addButton(MSButton button) {
		if (!this.buttons.contains(button))
			this.buttons.add(button);
	}

	@Override
	public void render(Graphics g) {

		int width = RPGProject.getWindow().getWidth();
		int height = RPGProject.getWindow().getHeight();
		int size = this.buttons.size() + 1;

		g.setFont(FONT);

		try {
			g.setFont(this.font);
		} catch (Exception e) {
			e.printStackTrace();
		}

		FontMetrics metrics = g.getFontMetrics();

		g.setColor(BACKGROUND);
		g.fillRect(0, 0, width, height);

		for (int i = 0; i < size - 1; i++) {
			g.setColor(DEFAULT);
			if (this.selected == i)
				g.setColor(SELECTED);
			g.drawString(
					this.buttons.get(i).getText(),
					width
							/ 2
							- metrics
									.stringWidth(this.buttons.get(i).getText())
							/ 2, height * (i + 1) / size);
		}

	}

	@Override
	public void update() {

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.up.getKeyCode()))
			this.selected--;
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.down.getKeyCode()))
			this.selected++;

		if (this.selected >= this.buttons.size())
			this.selected = this.buttons.size() - 1;
		if (this.selected < 0)
			this.selected = 0;

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.enter.getKeyCode())) 
			this.buttons.get(this.selected).onClick();

	}

}
