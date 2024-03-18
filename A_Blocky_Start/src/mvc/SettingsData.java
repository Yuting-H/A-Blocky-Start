package mvc;


public class SettingsData {
	
	private int screenHeight;
	private int screenWidth;
	private double volumeLevel;
	private boolean colourblindMode;
	
	public SettingsData(String filename) {
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
	
	public void setVolumeLevel(double volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	public void setColourblindMode(int screenHeight) {
		this.screenHeight = screenHeight;
	}

}
