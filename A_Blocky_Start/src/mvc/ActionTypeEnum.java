package mvc;

/**
 * Enumerator of all possible types of action.
 * @version March 12, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 */

public enum ActionTypeEnum {
	/**
	 * Enumerator of actions
	 */
	Unknown, Start, End, Forward, Back, Left, Right, Goto, Loop;
	
	/**
	 * Convert encoded string to an enumerator.
	 * @param data Encoded data string
	 * @return Enumerator of actions
	 */
	public static ActionTypeEnum fromString(String data) {
		// Remove whitespace
		data = data.strip().toLowerCase();
		
		// Check data of action
		if (data.equals("start")) {
			return Start;
		} else if (data.equals("end")) {
			return End;
		} else if (data.equals("forward")) {
			return Forward;
		} else if (data.equals("back")) {
			return Back;
		} else if (data.equals("left")) {
			return Left;
		} else if (data.equals("right")) {
			return Right;
		} else if (data.indexOf("goto") != -1) {
			return Goto;
		} else if (data.indexOf("loop") != -1) {
			return Loop;
		}
		
		// Invalid encoded string
		return Unknown;
	}
}
