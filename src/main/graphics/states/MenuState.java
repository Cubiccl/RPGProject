package main.graphics.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import main.game.input.KeyCustom;
import main.graphics.textures.FontBuilder;
import main.RPGProject;

public class MenuState extends State {

	private static final Color DEFAULT = Color.WHITE, SELECTED = Color.RED,
			BACKGROUND = Color.BLACK;
	private static final String START = "Start this awesome game !",
			QUIT = "Quit";
	private static final Font FONT = new Font("Impact", Font.PLAIN, 30);
	private int selected;

	public MenuState() {
		this.selected = 0;
	}

	@Override
	public void render(Graphics g) {

		int width = RPGProject.getWindow().getWidth();
		int height = RPGProject.getWindow().getHeight();

		g.setFont(FONT);
		
		
		try {
			g.setFont(main.graphics.textures.FontBuilder.createfont("res/Ruritania.ttf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FontMetrics metrics = g.getFontMetrics();

		g.setColor(BACKGROUND);
		g.fillRect(0, 0, width, height);

		g.setColor(DEFAULT);
		if (this.selected == 0)
			g.setColor(SELECTED);
		g.drawString(START, width / 2 - metrics.stringWidth(START) / 2,
				height / 3);

		g.setColor(DEFAULT);
		if (this.selected == 1)
			g.setColor(SELECTED);
		g.drawString(QUIT, width / 2 - metrics.stringWidth(QUIT) / 2,
				height * 2 / 3);
	}

	@Override
	public void update() {

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.up.getKeyCode()))
			this.selected--;
		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.down.getKeyCode()))
			this.selected++;

		if (this.selected > 1)
			this.selected = 1;
		if (this.selected < 0)
			this.selected = 0;

		if (RPGProject.getGame().getKeyManager()
				.isKeyPressedInstant(KeyCustom.enter.getKeyCode())) {
			switch (this.selected) {
			case 0:
				RPGProject.getGame().setState(StateManager.GAME);
				break;

			case 1:
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}

}
