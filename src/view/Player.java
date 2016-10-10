package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Player extends JPanel implements Observer {
	private Image img;
	private int x;
	private int y;
	private int width = 100;
	private int height = 100;
	
	public Player() {
		super();
		img = null;
		try {img = ImageIO.read(new File("./_Images/player.png"));} 
		catch (IOException e) {e.printStackTrace();	}
	}
	 
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, this.width, this.height, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		int [] recup = (int[]) arg;
		x = recup[0];
		y = recup[1];
	
		repaint();
		
	}

}
