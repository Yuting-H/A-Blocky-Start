package mvc;


public class SettingsData {
	
	private int screenHeight;
	private int screenWidth;
	private boolean colourblindMode;
	private int volumeLevel;
	
	public SettingsData() {
		screenHeight = 0;
		screenWidth = 0;
		colourblindMode = false;
		volumeLevel = 0;
	}
	
	public static SettingsData importData(String filename) {
		// read file
	}
	
	public exportSettings(String filename) {
		// write to file
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
