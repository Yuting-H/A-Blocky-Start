package mvc;

/**
 * 
 */
public class MainMenuController implements Controller{
	
	private static MainMenuView view = new MainMenuView();
	
	
	
	/**
	 * 
	 */
	public void insertPanel() {
		view.insertPanel();
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
