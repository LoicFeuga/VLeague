package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Model;

public class View {
	private JFrame frame;
	private int WIDTH;
	private int HEIGHT;
	private Player player;
	private Balle balle;
	private World world;


	public View() {
		frame = new JFrame();
		init();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player = new Player("./_Images/player.png");
		balle = new Balle("./_Images/balle.png");
		
		ArrayList<GameObject> l = new ArrayList<>();
		l.add(player);	l.add(balle);
		
		world = new World(l);
		frame.add(world);
		
		player.setWorld(world);
		balle.setWorld(world);
		
//		frame.add(player);
//		frame.add(balle);
		
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

	public Balle getBalle() {
		return balle;
	}

}
