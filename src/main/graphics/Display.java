package main.graphics;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display extends JFrame {
  private static final long serialVersionUID = 1L;
  /** Default size for the frame */
  public static final int WIDTH = 800, HEIGHT = 600;

  private Canvas canvas;
  private GameCamera camera;

  public Display() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(WIDTH, HEIGHT);
    this.setLocationRelativeTo(null);
    this.setTitle("RPG Project");
    this.setResizable(false);

    this.canvas = new Canvas();
    this.canvas.setPreferredSize(this.getSize());
    this.canvas.setMaximumSize(this.getSize());
    this.canvas.setMinimumSize(this.getSize());
    this.canvas.setFocusable(false);

    this.add(this.canvas);
    this.pack();

    this.camera = new GameCamera();
  }

  public Canvas getCanvas() {
    return this.canvas;
  }

  public GameCamera getCamera() {
    return this.camera;
  }

}
