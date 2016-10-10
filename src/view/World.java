package view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class World extends JPanel {
	
	private ArrayList<GameObject> list;
	
	public World(ArrayList<GameObject> list) {
		super();
		this.list = list;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	

}
