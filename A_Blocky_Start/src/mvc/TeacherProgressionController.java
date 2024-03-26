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

		this.data = Main.loginController.getActiveUser();

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
