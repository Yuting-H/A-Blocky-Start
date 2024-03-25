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
	
	public void setUserData(UserData userData)
	{
		
		
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
	@Override
	public void OnExit() {
		view.setVisibility(false);
	}

}
