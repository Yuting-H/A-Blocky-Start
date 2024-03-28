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
		
		//add functionalty to selector
		view.selectorAddChangeListener(new ChangeListener() {
			
			//when state change
			@Override
			public void stateChanged(ChangeEvent e) {
				
				refreshView();
			}
		});
	}
	
	private void refreshView() {
		
		//set data
		data.setPage(view.getPage());
		data.updateEntries();
		
		//add 10 entries to view
		for (int i = 0; i < 10; i++) {
			
			
			
			UserData currData = data.getUserData(i);
			if (currData != null) {
				view.setEntry(
						i, 
						currData.getUsername(), 
						currData.getTotalTimeSpent(), 
						currData.getTotalAttempts(), 
						currData.getTotalScore(), 
						-1
						);
			}else {
				view.setEntry(i, "Empty", i, i, i, i);
			}
			
			view.repaint();
			view.revalidate();
		}
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
