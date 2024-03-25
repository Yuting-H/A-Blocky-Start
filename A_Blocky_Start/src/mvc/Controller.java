package mvc;

/**
 * This interface represents all controllers.
 * @version 1.0
 * @since March 14, 2024
 * @author Yuting Hou
 *
 */
public interface Controller {
	
	/**
	 * Call this when entering a screen.
	 */
	public void OnEnter();
	
	/**
	 * Call this when exiting a screen.
	 */
	public void OnExit();
	
}
