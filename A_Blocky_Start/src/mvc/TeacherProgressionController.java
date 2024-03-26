package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

/**
 * 
 */
public class TeacherProgressionController implements Controller {

	private TeacherProgressionView view;

	private Controller previousController;

	private ArrayList<UserData> userData;

	private TeacherProgressionData teacherData;

	/**
	 * 
	 */
	public TeacherProgressionController() {

		view = new TeacherProgressionView();

		userData = new ArrayList<UserData>();

		teacherData = null;

		view.insertPanelToFrame();

		PopulateActionListener();
	}

	/**
	 * 
	 */

	public void setUserData() {
		teacherData = new TeacherProgressionData();

		for (int i = 0; i < 10; i++) {
			userData.add(teacherData.getUserData(i));
		}

	}

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
