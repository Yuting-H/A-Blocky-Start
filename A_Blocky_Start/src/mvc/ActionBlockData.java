package mvc;

import java.util.ArrayList;

/**
 * This model class represents an action block. It loads/ saves data by communicating with the ActionChain object.
 * @version March 11, 2024
 * @author Chun Ho Chan (Edward)
 */
public class ActionBlockData {
	/**
	 * Type of action
	 */
	private ActionEnum type;
	/**
	 * List of arguments
	 */
	private ArrayList<Integer> args;
	/**
	 * Internal counter (in a loop)
	 */
	private int counter;
	
	/**
	 * Construct an action block.
	 * @param type Type of action
	 * @param args List of arguments
	 */
	public ActionBlockData(ActionEnum type, ArrayList<Integer> args) {
		this.type = type;
		this.args = args;
		this.counter = -1; // none value
		
		if (type == ActionEnum.Loop) {
			// loop (end - start) times
			this.counter = args.get(0) - args.get(1);
		}
	}
	
	/**
	 * Construct an action block, using encoded data string.
	 * @param data Encoded data string
	 */
	public ActionBlockData importData(String data) {
		// Split the data
		String[] dataList = data.split("_");
		
		// Decode type
		ActionEnum type = ActionEnum.fromString(dataList[0]);
		
		// Decode list of arguments
		ArrayList<Integer> args = new ArrayList<Integer>();
		
		// Convert each argument to integer
		for (int i = 1; i < dataList.length; i++) {
			try {
				args.add(Integer.parseInt(dataList[i]));
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// Call constructor
		return new ActionBlockData(type, args);
	}
	
	/**
	 * Export this object as an encoded data string.<br>
	 * The string always begins with its type, followed by its arguments separated with "_".<br><br>
	 * Examples:<br>
	 * "Left"<br>
	 * "Goto_X", X is the line number for jump.<br>
	 * "Loop_X_Y_Z", loop (X - Y) times, Z is the line number for jump.<br>
	 * @return Encoded data string
	 */
	public String exportData() {
		String result = type.toString();
		
		for (int i = 0; i < args.size(); i++) {
			result = result + "_" + args.get(i).toString(); 
		}
		
		return result;
	}
	
	/**
	 * Access type of action.
	 * @return Type of action.
	 */
	public ActionEnum getType() {
		return type;
	}
	
	/**
	 * Access list of arguments.
	 * @return List of arguments
	 */
	public ArrayList<Integer> getArgs() {
		return args;
	}
	
	/**
	 * Access end point of loop. Return -1 if none.
	 * @return End point
	 */
	public int getEndPoint() {
		if (type == ActionEnum.Loop) {
			return args.get(0);
		} else {
			return -1;
		}
	}
	
	/**
	 * Access start point of loop. Return -1 if none.
	 * @return Start point
	 */
	public int getStartPoint() {
		if (type == ActionEnum.Loop) {
			return args.get(1);
		} else {
			return -1;
		}
	}
	
	/**
	 * Access line number for jump. Return -1 if none.
	 * @return Line number for jump
	 */
	public int getLineForJump() {
		if (type == ActionEnum.Goto) {
			return args.get(0);
		} else if (type == ActionEnum.Loop) {
			return args.get(2);
		} else {
			return -1;
		}
	}
	
	/**
	 * Access internal counter. Return -1 if none.
	 * @return Internal counter
	 */
	public int getCounter() {
		if (type == ActionEnum.Loop) {
			return counter;
		} else {
			return -1;
		}
	}
	
	/**
	 * Reset internal counter.
	 */
	public void resetCounter() {
		if (type == ActionEnum.Loop) {
			// loop (end - start) times
			counter = args.get(0) - args.get(1);
		}
	}
	
	/**
	 * Decrement internal counter by 1.
	 */
	public void decCounter() {
		counter -= 1;
	}

}
