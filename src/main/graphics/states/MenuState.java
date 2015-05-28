package main.graphics.states;

import java.awt.Color;
import java.awt.Graphics;

import main.graphics.Display;

public class MenuState extends State
{

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(0, 0, Display.WIDTH, Display.HEIGHT);
	}

	@Override
	public void update()
	{}

}
