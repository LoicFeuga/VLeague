package model;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Model extends Thread {

	private Player player;
	private Balle balle;
	private Balle balle2;
	private boolean running;
	private Gravity gravity;
	
	public Model() {
		player = new Player();
		balle = new Balle();
	
		running = true;
		start();
	}
	
	@Override
	public void run() {
		long lastLoopTime = System.nanoTime();
		   final int TARGET_FPS = 60;
		   final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   

		   
		   while (running) {
		      long now = System.nanoTime();
		      long updateLength = now - lastLoopTime;
		      lastLoopTime = now;
		      double delta = updateLength / ((double)OPTIMAL_TIME);

		      balle.applyForce();
		      player.applyForce();
		 
		      try{Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );}
		      catch (InterruptedException e) {e.printStackTrace();			};
		   }
		
	}

	

	public Player getPlayer(){
		return player;
	}
	
	public Balle getBalle(){
		return balle;
	}
	
	/**
	 * Permet de récupérer la config du fichier de config
	 * @return
	 */
	public static Integer[] getConfig(){
		Integer [] result = new Integer[2];
		
		result[0] = getIntegerFromJSONConfig("width");
		result[1] = getIntegerFromJSONConfig("height");
		
		return result;
	}
	
	
	/**
	 * Permet de récupèrer une config dans le fichier JSON config.json à la racine du projet
	 * @param str paramètre json à récupérer dans le fichier
	 * @return la valeur
	 */
	private static String getStringFromJSONConfig(String str){
		JSONObject obj = null;
		try {obj = new JSONObject(readFile("./config.json", StandardCharsets.UTF_8));}
		catch (JSONException e) {e.printStackTrace();}

		String result = "";
		try {result = obj.getString(str);} 
		catch (JSONException e) {e.printStackTrace();}
		return result;
	}
	
	/**
	 * Permet de récupèrer une config dans le fichier JSON config.json à la racine du projet
	 * @param str paramètre json à récupérer dans le fichier
	 * @return la valeur
	 */
	private static Integer getIntegerFromJSONConfig(String str){
		JSONObject obj = null;
		try {obj = new JSONObject(readFile("./config.json", StandardCharsets.UTF_8));}
		catch (JSONException e) {e.printStackTrace();}

		Integer result = 0;
		try {result = obj.getInt(str);} 
		catch (JSONException e) {e.printStackTrace();}
		
		return result;
	}

	/**
	 * Permet de récupère le string d'un fichier 
	 * 
	 * @param path 
	 * @param encoding StandardCharsets.UTF_8
	 * @return
	 */
	private static String readFile(String path, Charset encoding) {
		byte[] encoded = null;
		try {encoded = Files.readAllBytes(Paths.get(path));}
		catch (IOException e) {e.printStackTrace();		}
		
		return new String(encoded, encoding);
	}
	
	public void stopRunning(){
		this.running = false;
	}
}
