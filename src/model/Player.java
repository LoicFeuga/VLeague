package model;

import java.util.Observable;

public class Player extends GameObject{
	private int goY= 0;
	
	public Player(){
		super();
		setXY(250, 250);

	}

	public void applyForce() {

		if(y < 600){
			goY = +1;
		}else if( y > 600){
			goY = 0;
		}

		addY(goY);
		
	}
	
}
