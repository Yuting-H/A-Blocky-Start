package mvc;

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
	public static void appendErrorLog(Exception e) {
		// TODO: append error to an error log
		
		System.out.println(e.getMessage());
	}
	
	/**
	 * Clear the error log file.
	 */
	public static void clearErrorLog() {
		// TODO: wipe the error log file
		
		System.out.println("Error log cleared.");
	}

}
