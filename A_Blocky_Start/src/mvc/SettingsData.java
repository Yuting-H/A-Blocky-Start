package mvc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This model class stores and updates the game's settings. 
 * It loads/ saves data using the settings data file. 
 * All users share the same game settings.
 * @version 1.0
 * @since Mar 12, 2024
 * @author Simon McCabe
 */
public class SettingsData {
	/**
	 * Filename of the settings data file
	 */
	private static final String filename = "game_settingsdata.csv";
	/**
	 * Height of the screen
	 */
	private int screenHeight;
	/**
	 * Width of the screen
	 */
	private int screenWidth;
	/**
	 * Colourblind mode (true = enabled)
	 */
	private boolean colourblindMode;
	/**
	 * Volume of the game audio (percentage)
	 */
	private int volumeLevel;

	/**
	 * Initialize the settings data.
	 */
	public SettingsData() {
		screenHeight = 1280;
		screenWidth = 720;
		colourblindMode = false;
		volumeLevel = 0;
	}

	/**
	 * Decode the encoded data stored in the settings data file.
	 * @see exportData() for details.
	 * @param filename Filename of settings file
	 * @return SettingsData, or null if the file does not exist
	 */
	public static SettingsData importData() {
		// Call constructor
		SettingsData settings = new SettingsData();

		// Read from CSV file
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			// Read the entire line of settings
			String line = reader.readLine();
			
			// Split the line by commas
			String[] parts = line.split(",");

			// Ensure there are at least 4 components
			if (parts.length < 4) {
				throw new Exception("Too few arguments.");
			} else {
				settings.screenHeight = Integer.parseInt(parts[0]);
				settings.screenWidth = Integer.parseInt(parts[1]);
				settings.colourblindMode = Boolean.parseBoolean(parts[2]);
				settings.volumeLevel = Integer.parseInt(parts[3]);
				
			}
			
			// Close the reader
			reader.close();
		} catch (Exception e) {
			Main.errorLogController.addError(e);
			return null;
		}

		return settings; // Return the populated SettingsData instance
	}

	/**
	 * Export this user's data to the user data file.
	 * Format: (without spaces)<br>
	 * "screenHeight, screenWidth, colourblindMode, volumeLevel"<br>
	 */
	public void exportSettings() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			// Concatenate settings into a single line, separated by commas
			String settingsLine = screenHeight + "," + screenWidth + "," + colourblindMode + "," + volumeLevel;
			
			 // Write the encoded data string
			writer.write(settingsLine);
			
			// Close the file
			writer.close();
		} catch (Exception e) {
			Main.errorLogController.addError(e);
		}
	}

	/**
	 * Access the screen height.
	 * @return Screen height
	 */
	public int getScreenHeight() {
		return screenHeight;
	}

	/**
	 * Access the screen width.
	 * @return Screen width
	 */
	public int getScreenWidth() {
		return screenWidth;
	}

	/**
	 * Access the colourblind mode.
	 * @return Colourblind mode (true = enabled)
	 */
	public boolean getColourblindMode() {
		return colourblindMode;
	}
	
	/**
	 * Access the volume level.
	 * @return Volume level
	 */
	public int getVolumeLevel() {
		return volumeLevel;
	}

	/**
	 * Mutate the screen height.
	 * @param screenHeight Screen width
	 */
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	/**
	 * Mutate the screen width.
	 * @param screenWidth Screen width
	 */
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	
	/**
	 * Mutate the colourblind mode.
	 * @param colourblindMode Colourblind mode
	 */
	public void setColourblindMode(boolean colourblindMode) {
		this.colourblindMode = colourblindMode;
	}

	/**
	 * Mutate the volume level.
	 * @param volumeLevel Volume level
	 */
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
}
