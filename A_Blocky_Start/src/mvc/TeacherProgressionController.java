package mvc;

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
