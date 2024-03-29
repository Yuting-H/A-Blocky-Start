package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class HighScoreController implements Controller{
	
	private static HighScoreView view = new HighScoreView();
	private static HighScoreData data;
	/**
	 * 
	 */
	public HighScoreController() {
		
		view.insertPanelToFrame(Main.gameFrame);
		
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
	 * Is called when showing high score view
	 */
	@Override
	public void OnEnter() {
		view.setVisibility(true);
		updateHighScore();
	}
	
	private void updateHighScore() {
		data = HighScoreData.importData();
		//data.importData();
		for(int i = 0; i < 5; i++) {
			view.addHighscore(i, data.getUsername(i), data.getHighScore(i));
		}
		data.exportHighScore();

	}

	/**
	 * Is called when exiting high score view
	 */
	@Override
	public void OnExit() {
		
		view.setVisibility(false);
	}
}
