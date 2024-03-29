package mvc;

/**
 * @deprecated
 */
public class ExampleMainMenuController implements Controller{
	
	//the view 
	private static ExampleMainMenuView view = new ExampleMainMenuView();
	
	/**
	 * This method inserts 
	 */
	public static void insertPanelToFrame() {
		view.insertPanelToFrame(Main.gameFrame);
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
