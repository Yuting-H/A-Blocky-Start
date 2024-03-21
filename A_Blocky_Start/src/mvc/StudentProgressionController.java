package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class StudentProgressionController implements Controller{
	
	/** The view*/
	private StudentProgressionView view;
	
	private Controller previousController;
	
	private StudentProgressionData data;
	
	/**
	 * 
	 */
	public StudentProgressionController() {
		
		view = new StudentProgressionView();
		
		this.data = null;
		
		view.insertPanelToFrame();
		
		PopulateActionListener();
	}
	
	/**
	 * Adds action listener to UI elements
	 */
	private void PopulateActionListener() {
		
		view.backButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.studentProgressionController.OnExit();
				previousController.OnEnter();
			}
		});
		
	}
	
	/**
	 * 
	 * @param userData
	 */
	public void setUserData(UserData userData) {
		this.data = new StudentProgressionData(userData);
		ProgressionData progressionData;
		for (int i = 0; i < 10; i++) {
			
			progressionData = data.getProgression(i);
			
			
			view.setEntry(
					i,
					progressionData.getStageID(),
					progressionData.getCompleted(),
					progressionData.getShortestSteps(),
					progressionData.getHighestScore(), 
					progressionData.getTimeSpent(), 
					progressionData.getAttempts()
				);
		}
	}
	
	/**
	 * 
	 */
	public void OnExit() {
		view.setVisibility(false);
	}

	/**
	 * 
	 */
	@Override
	public void OnEnter() {
		view.setVisibility(true);
		this.previousController = Main.mainMenuController;
	}
	
	/**
	 * 
	 */
	public void OnEnterSpecial(Controller previousController) {
		OnEnter();
		this.previousController = previousController; // Override default back button behavior
		
	}

}
