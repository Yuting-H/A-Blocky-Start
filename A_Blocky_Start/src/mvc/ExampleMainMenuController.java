package mvc;

/**
 * 
 */
public class ExampleMainMenuController implements Controller{
	
	//the view 
	private static ExampleMainMenuView view = new ExampleMainMenuView();
	
	/**
	 * This method inserts 
	 */
	public static void insertPanel() {
		view.insertPanel();
	}

	/**
	 * 
	 */
	public void OnEnter() {
		view.setVisible(true);
	}

	/**
	 * 
	 */
	
	public void OnExit() {
		view.setVisible(false);
	}

}
