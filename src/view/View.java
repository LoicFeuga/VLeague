package view;

import java.awt.Color;

import javax.swing.JFrame;

import model.Model;

public class View {
	private JFrame frame;
	private int WIDTH;
	private int HEIGHT;
	private Player player;
	
	public View() {
		frame = new JFrame();
		init();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player = new Player();
		frame.add(player);
		
		frame.setVisible(true);
	}
	
	/**
	 * Permet d'initialiser les variables grace au fichier de config
	 */
	private void init(){
		Integer [] conf = { (Integer) null, (Integer) null};		
		conf = Model.getConfig();
		
		WIDTH = conf[0];
		HEIGHT = conf[1];
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
