package main.game;

public class Game implements Runnable
{

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
		while (this.isRunning)
			System.out.println("The game is running :D");

		this.stop();
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
