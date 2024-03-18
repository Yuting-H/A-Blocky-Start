package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class StudentProgressionController {
	
	/** The view*/
	private StudentProgressionView view = new StudentProgressionView();
	
	private StudentProgressionData[] studentProgressionDatas = new StudentProgressionData[10];
	
	
	
	/**
	 * 
	 */
	public StudentProgressionController() {
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
				Main.mainMenuController.OnEnter();
			}
		});
		
	}
	
	/**
	 * 
	 */
	public void OnEnter() {
		view.setVisibility(true);
	}
	
	/**
	 * 
	 */
	public void OnExit() {
		view.setVisibility(false);
	}

}
