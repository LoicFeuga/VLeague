package model;

import java.util.Observable;

public class GameObject extends Observable{
	protected int x;
	protected int y;
	private int [] xy;
	
	public GameObject(){
		xy = new int[2];
		x = 0;
		y = 0;
		buildXY();		
	}
	
	public void buildXY(){
		xy[0] = x;
		xy[1] = y;
		setChanged();
		notifyObservers(xy);
	}
	
	public void addX(int x){
		this.x += x;
		buildXY();
	}

	public void addY(int y) {
		this.y += y;
		buildXY();		
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
		buildXY();
	}

	public int getY(){
		return y;
	}
	

}
