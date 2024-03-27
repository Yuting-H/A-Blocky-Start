package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class TeacherProgressionController implements Controller{

	private TeacherProgressionView view = new TeacherProgressionView();
	
	/**
	 * 
	 */
	public TeacherProgressionController() {
		
		view.insertPanelToFrame();
		
		populateActionListener();
	}
	
	/**
	 * 
	 */
	private void populateActionListener() {
		view.backButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.teacherProgressionController.OnExit();
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
