package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameObject  implements Observer {
	private Image img;
	private int x;
	private int y;
	private int width = 100;
	private int height = 100;
	private World world;
	
	public GameObject(String imagePath) {
		super();
		img = null;
		try {img = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();	}
	}
	

	public Image getImg(){
		return img;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void setWorld(World world){
		this.world= world;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int [] recup = (int[]) arg;
		x = recup[0];
		y = recup[1];
		
		world.repaint();
	
		
	}

}
