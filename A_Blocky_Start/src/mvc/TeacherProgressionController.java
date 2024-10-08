package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TeacherProgressionController implements Controller {

	private static Controller previous;
	private TeacherProgressionView view = new TeacherProgressionView();
	private TeacherProgressionData data = new TeacherProgressionData();

	/**
	 * Constructor.
	 */
	public TeacherProgressionController() {
		view.insertPanelToFrame(Main.gameFrame);
		populateActionListener();
	}

	@Override
	public void onEnter(Controller previous) {
		TeacherProgressionController.previous = previous;
		view.setVisibility(true);
		refreshView();
		Main.refreshColorblindOverlay();
	}

	@Override
	public void onExit() {
		view.setVisibility(false);
	}

	/**
	 * Help to insert action listeners to UI elements.
	 */
	private void populateActionListener() {
		
		view.backButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.teacherProgressionController.onExit();
				TeacherProgressionController.previous.onEnter(Main.teacherProgressionController);
				Main.soundController.playSound(SoundController.buttonClick);
			}
		});
		
		view.pageSelector(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				refreshView();
			}
			
		});
	}
	
	/**
	 * This function loads user data into and refreshes teacher progression view
	 */
	private void refreshView() {
		
		// update page, update entries
		data.setPage(view.getPage());
		data.updateEntries();
		
		// add the entries on the page to view
		// some entries may not exist
		for (int i = 0; i < 10; i++) {
			
			UserData currData = data.getUserData(i);
			
			//if this entry exist, update
			if (currData != null) {
				view.setEntry(
						i, 
						currData.getUsername(), 
						currData.getTotalTimeSpent(), 
						currData.getTotalAttempts(), 
						currData.getTotalScore(), 
						currData.getProgressionList().size() - 1
						);
			} else {
				// if this entry does not exist, update with a blank
				view.setEntry(i, "Empty", 0, 0, 0, 0);
			}
			
			view.refreshPanel();
		}
	}

}
