package mvc;

/**
 * This interface represents all controllers
 * @author Yuting
 *
 */
public interface Controller {
	
	/**
	 * Call this when entering a screen
	 */
	public void OnEnter();
	
	/**
	 * Call this when exiting a screen
	 */
	public void OnExit();
	
}
