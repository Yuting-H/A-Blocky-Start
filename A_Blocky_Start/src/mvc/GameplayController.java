package mvc;

/**
 * This controller class synchronizes the ActionChain, MazeData, and GameplayView. 
 * @version March 12, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 * @author Yuting Hou
 */
public class GameplayController implements Controller{
	
	/** the view*/
	private static GameplayView view = new GameplayView();

	/**
	 * 
	 */
	public GameplayController() {
		view.insertPanelToFrame();
		
		populateActionListener();
	}
	
	/**
	 * 
	 */
	private void populateActionListener() {
		//TODO implement
	}
	
	/**
	 * @return the view
	 */
	public static GameplayView getView() {
		return view;
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
