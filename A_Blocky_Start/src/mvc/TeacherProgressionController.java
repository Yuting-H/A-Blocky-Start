package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class TeacherProgressionController implements Controller {

	private TeacherProgressionView view;

	private Controller previousController;

	private TeacherProgressionData data;

	/**
	 * 
	 */
	public TeacherProgressionController() {
		view = new TeacherProgressionView();

		this.data = null;

		view.insertPanelToFrame();

		PopulateActionListener();
	}

	/**
	 * 
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

	public void setUserData(UserData userData) {
		this.data = new TeacherProgressionData();
		StudentProgressionData studentData = new StudentProgressionData(userData);
		ProgressionData progressionData;

		for (int i = 0; i < 10; i++) {
			progressionData = studentData.getProgression(i);

			if (progressionData == null) {
				break;
			}
			view.setEntry(i, progressionData.getStageID(), progressionData.getCompleted(),
					progressionData.getShortestSteps(), progressionData.getHighestScore(),
					progressionData.getTimeSpent(), progressionData.getAttempts());
		}
	}

	/**
	 * 
	 */
	@Override
	public void OnEnter() {
		view.setVisibility(true);
		this.previousController = Main.mainMenuController;
	}

	public void OnEnterSpecial(Controller previousController) {
		OnEnter();
		this.previousController = previousController;
	}

	/**
	 * 
	 */
	@Override
	public void OnExit() {
		view.setVisibility(false);
	}

}
