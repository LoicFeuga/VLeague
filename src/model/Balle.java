package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Balle extends GameObject {
	private boolean go = true;
	private int goX = 15;
	private int goY = 5;
	private int maxX = 0;
	private int maxY = 0;
	
	public Balle(){
		super();

	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    maxX = (int) screen.getWidth();
	    maxY = (int) screen.getHeight();
		setXY(250, 250);
		applyForce();
	}
	
	
	public void applyForce(){
		if(x > 1150){
			goX = -15;
		}else if( x < 0){
			goX = 15;
		}
		
		if(y > 600){
			goY = -15;
		}else if( y < 0){
			goY = 15;
		}

		addX(goX);
		addY(goY);
			
	}
}
