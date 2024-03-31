package mvc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class SettingsController implements Controller{
	
	private static SettingsView view = new SettingsView();
	
	private static SettingsData data = SettingsData.importData();
	
	/**
	 * 
	 */
	public SettingsController() {
		
		view.insertPanelToFrame(Main.gameFrame);
		
		populateActionListener();
	}
	
	/**
	 * 
	 */
	private void populateActionListener() {
		
		//when back button is pressed
		view.backButtonAddActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.settingsController.OnExit();
				Main.mainMenuController.OnEnter();
				updateSetting();
			}
		});
	}
	
	/**
	 * This function updates setting data 
	 * @author Simon
	 */
	private void updateSetting() {
		//TODO: get colourblind settings from view and store in data
		String colourblindStr = view.getColourBlindSetting();
		
		// TODO bad code style
		
		if (colourblindStr.equalsIgnoreCase("On")) {
			data.setColourblindMode(true);
			Main.setColorblindVisibility(true);
		} else {
			data.setColourblindMode(false);
			Main.setColorblindVisibility(false);
		}
		
		
	}
	public boolean isColourblindMode() {		
		return data.getColourblindMode();
	}
	
	/**
	 * 
	 */
	@Override
	public void OnEnter() {
		view.setVisibility(true);
	}

	/**
	 * 
	 */
	@Override
	public void OnExit() {
		view.setVisibility(false);
	}
	
	/**
	 * get the dimension from the data
	 */
	public Dimension getDimension() {
		return new Dimension(data.getScreenWidth(), data.getScreenHeight());
	}

}
