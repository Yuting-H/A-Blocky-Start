package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */
public class TeacherProgressionController implements Controller{

	private TeacherProgressionView view = new TeacherProgressionView();
	
	private TeacherProgressionData data = new TeacherProgressionData();
	
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
		
		view.selectorAddChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				data.setPage(view.getPage());
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
