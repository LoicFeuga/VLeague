package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Player;

public class VKeyListener implements KeyListener {
	Player player;
	
	public VKeyListener(Player player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.setX(20);
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player.setX(-20);
		}

		if(e.getKeyCode() == KeyEvent.VK_UP){
			player.setY(-20);
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player.setY(20);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
