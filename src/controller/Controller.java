package controller;

import model.Model;
import view.View;

public class Controller {
	private Model model;
	private View view;
	
	public Controller() {
		this.model = new Model();
		this.view = new View();
		
		VKeyListener vk = new VKeyListener(model.getPlayer(),model);
		
		view.getFrame().addKeyListener(vk);

		this.model.getPlayer().addObserver(view.getPlayer());
		this.model.getBalle().addObserver(view.getBalle());
	}

}
