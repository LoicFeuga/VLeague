package model;

import java.util.ArrayList;

public class Gravity {
	
	private ArrayList<GameObject> list;
	private boolean gravity;
	
	public Gravity(ArrayList<GameObject> list) {
		this.list = list;
		gravity = true;
	}

	public void applyGravity(){
		
		for (GameObject gameObject : list) {
			
			if(gameObject.getY() > 600){
				gameObject.addY(-5);
				gameObject.buildXY();
			}else{
				gameObject.addY(9);
				gameObject.buildXY();
			}
		}
	}

	public void stopGravity(){
		gravity = false;
	}
	
}
