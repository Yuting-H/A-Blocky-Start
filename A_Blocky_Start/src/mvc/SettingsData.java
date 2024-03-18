package mvc;
import java.io.*;

/**
 * This model class is used to alter and store game settings
 * like the height of the screen, width of the screen, if the 
 * game is in colourblind mode, and the volume level.
 * @version 1.0
 * @since Mar 12, 2024
 * @author Simon McCabe
 */

public class SettingsData {
	
	// Create private integer instance variable that represents the height of the screen
	private int screenHeight;
	// Create private integer instance variable that represents the width of the screen
	private int screenWidth;
	/*
	 *  Create private boolean instance variable that shows if the game is in colourblind 
	 *  mode (true) or not (false)
	 */
	private boolean colourblindMode;
	// Create private integer integer instance variable that represents the volume of the game.
	private int volumeLevel;
	
	public SettingsData() {
		screenHeight = 0;
		screenWidth = 0;
		colourblindMode = false;
		volumeLevel = 0;
	}
	
	public static SettingsData importData(String filename) {
		// read file
		 SettingsData settings = new SettingsData();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            settings.screenHeight = Integer.parseInt(reader.readLine());
	            settings.screenWidth = Integer.parseInt(reader.readLine());
	            settings.colourblindMode = Boolean.parseBoolean(reader.readLine());
	            settings.volumeLevel = Integer.parseInt(reader.readLine());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return settings;
		
	}
	
	public void exportSettings(String filename) {
		// write to file
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	            writer.write(Integer.toString(screenHeight));
	            writer.newLine();
	            writer.write(Integer.toString(screenWidth));
	            writer.newLine();
	            writer.write(Boolean.toString(colourblindMode));
	            writer.newLine();
	            writer.write(Integer.toString(volumeLevel));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public int getScreenWidth(){
		return screenWidth;
	}
	
	public double getVolumeLevel() {
		return volumeLevel;
	}
	
	public boolean getColourblindMode() {
		return colourblindMode;
	}
	
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	public void setColourblindMode(int screenHeight) {
		this.screenHeight = screenHeight;
	}

}
