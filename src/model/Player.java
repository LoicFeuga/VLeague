package model;

import java.util.Observable;

public class Player extends Observable{

	private int x;
	private int y;
	private int [] xy;
	
	public Player(){
		xy = new int[2];
		x = 0;
		y = 0;
		buildXY();
		
		
		
	}
	
	private void buildXY(){
		xy[0] = x;
		xy[1] = y;
		setChanged();
		notifyObservers(xy);
	}
	
	public void setX(int x){
		this.x += x;
		buildXY();
	}

	public void setY(int y) {
		this.y += y;
		buildXY();
		
	}
	
}
