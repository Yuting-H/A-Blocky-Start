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
		 SettingsData settings = new SettingsData(); // Create a new instance of SettingsData
		    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
		        String line = reader.readLine(); // Read the entire line of settings
		        if (line != null) {
		            String[] parts = line.split(","); // Split the line by commas
		            if (parts.length == 4) { // Ensure there are exactly 4 components
		                settings.screenHeight = Integer.parseInt(parts[0].trim()); // Parse screen height
		                settings.screenWidth = Integer.parseInt(parts[1].trim()); // Parse screen width
		                settings.colourblindMode = Boolean.parseBoolean(parts[2].trim()); // Parse colourblind mode
		                settings.volumeLevel = Integer.parseInt(parts[3].trim()); // Parse volume level
		            }
		        }
		    } catch (IOException e) {
		        e.printStackTrace(); // Print the stack trace in case of an IOException
		    }
		    return settings; // Return the populated SettingsData instance
		}
	
	public void exportSettings(String filename) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	        // Concatenate settings into a single line, separated by commas
	        String settingsLine = screenHeight + "," + screenWidth + "," + colourblindMode + "," + volumeLevel;
	        writer.write(settingsLine); // Write the concatenated settings string
	    } catch (IOException e) {
	        e.printStackTrace(); // Print the stack trace in case of an IOException
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
