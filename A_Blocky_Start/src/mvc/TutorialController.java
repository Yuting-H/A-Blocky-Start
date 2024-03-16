package mvc;

/**
 * 
 */
public class TutorialController {

	private TutorialView view = new TutorialView();
	
	/**
	 * Called in Main.java
	 * 
	 */
	public TutorialController() {
		
		view.insertPanelToFrame();
	}
	
	/**
	 * 
	 */
	private void populateActionListener() {
		
	}
	
	/**
	 * 
	 */
	public void onEnter() {
		view.setVisibility(true);
	}
	
	/**
	 * 
	 */
	public void onExit() {
		view.setVisibility(false);
	}
	
}
