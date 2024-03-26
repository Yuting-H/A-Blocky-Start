package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class HighScoreController implements Controller{
	
	private static HighScoreView view = new HighScoreView();
	
	/**
	 * 
	 */
	public HighScoreController() {
		
		view.insertPanelToFrame();
		
		populateActionListener();
		
	
	}
	
	/**
	 * Adds functionality to UI elements
	 */
	private void populateActionListener() {
		
		//back button
		view.backButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.highScoreController.OnExit();
				Main.mainMenuController.OnEnter();
			}
		});
	}
	
	/**
	 * Is called when showing Highscore view
	 */
	@Override
	public void OnEnter() {
		view.setVisibility(true);
		
	}

	/**
	 * Is called when exiting Highscore view
	 */
	@Override
	public void OnExit() {
		view.setVisibility(false);
	}
}
