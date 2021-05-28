package rpg.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;

public class Display {
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		creatDisplay();
	}

	public void creatDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		frame.add(canvas);
		frame.pack();
	}

	public void renderEndGame(Graphics g){
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
    	g.setColor(Color.white);
    	g.drawString("Game Over!", 240, 270);
    	g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    	g.drawString("Press space to continue", 290, 310);
    	System.out.println("Stop");
	}

	public Canvas getCanvas() {
		return this.canvas;
	}

	public JFrame getFrame() {
		return this.frame;
	}
}