package mvc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class SettingsController implements Controller{
	
	private static SettingsView view = new SettingsView();
	
	/**
	 * 
	 */
	public SettingsController() {
		
		view.insertPanelToFrame();
		
		populateActionListener();
	}
	
	private void populateActionListener() {
		view.backButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.settingsController.OnExit();
				Main.mainMenuController.OnEnter();
			}
		});
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
	

}
