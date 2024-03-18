package mvc;

/**
 * This controller class handles error logging. 
 * @version 1.0
 * @since Mar 17, 2024
 * @author Chun Ho Chan (Edward)
 */
public class ErrorLogController implements Controller {

	private static final String filename = "game_errorlog.txt";
	
	/**
	 * Called in Main
	 */
	public ErrorLogController() {
		// do nothing
	}
	
	@Override
	public void OnEnter() {
		// do nothing
		
	}

	@Override
	public void OnExit() {
		// do nothing
		
	}
	
	/**
	 * Append an error message to the error log file.
	 * @param e Error message
	 */
	public void addWarning(Exception e) {
		// TODO: append warning to an error log
		
		System.out.println(">> Warning << " + e.toString());
	}
	
	/**
	 * Append an error message to the error log file.
	 * @param e Error message
	 */
	public void addError(Exception e) {
		// TODO: append error to an error log
		
		System.out.println(">> Error << " + e.toString());
	}
	
	/**
	 * Clear the error log file.
	 */
	public void clearErrorLog() {
		// TODO: wipe the error log file
		
		System.out.println("Error log cleared.");
	}

}
