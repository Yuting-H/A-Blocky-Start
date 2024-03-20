package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class StudentProgressionController implements Controller{
	
	/** The view*/
	private StudentProgressionView view = new StudentProgressionView();
	
	private Controller previousController;
	
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
				previousController.OnEnter();
			}
		});
		
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
