package main.game;

import main.game.input.KeyInput;
import main.graphics.Display;

public class Game implements Runnable
{
	/** The JFrame to display the game */
	private Display frame;
	public int currentFPS;
	private KeyInput keyManager;

	/** The thread running the game itself. */
	private Thread thread;
	/** True if the game is running. */
	private boolean isRunning;

	public Game()
	{
		this.isRunning = false;
	}

	/** Called to run the game */
	@Override
	public void run()
	{
		this.init();

		int fps = 10, ticks = 0;
		double timePerTick = 1000000000 / fps, delta = 0;
		long now, lastTime = System.nanoTime(), timer = 0;

		while (this.isRunning)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1)
			{
				this.update();
				this.render();
				delta--;
				ticks++;
			}

			if (timer >= 1000000000)
			{
				System.out.println("FPS : " + ticks);
				this.currentFPS = ticks;
				ticks = 0;
				timer = 0;
			}
		}

		this.stop();
	}

	/** Called to draw the game onto the screen */
	private void render()
	{}

	/** Called to update the game */
	private void update()
	{}

	/** Initializes the game */
	private void init()
	{
		this.frame = new Display();
		this.frame.setVisible(true);

		this.keyManager = new KeyInput();
		this.frame.addKeyListener(this.keyManager);
	}

	/** Called to start the game */
	public void start()
	{
		if (this.isRunning) return;

		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}

	/** Called to stop the game */
	public void stop()
	{
		if (!this.isRunning) return;
		this.isRunning = false;
		try
		{
			this.thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
