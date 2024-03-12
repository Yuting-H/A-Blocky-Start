package mvc;

import java.util.ArrayList;

/**
 * This model class represents an action block. It loads/ saves data by communicating with the ActionChain object.
 * @version March 12, 2024
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
	 * Decode the encoded data string and calls the constructor.
	 * @param data Encoded data string
	 * @return ActionBlockData
	 */
	public static ActionBlockData importData(String data) {
		// Split the data
		String[] dataList = data.split("_");
		
		// Decode type
		ActionEnum type = ActionEnum.fromString(dataList[0]);
		
		// Check type
		if (type == ActionEnum.Unknown) {
			return new ActionBlockData(ActionEnum.Unknown, new ArrayList<Integer>());
		}
		
		// Decode list of arguments
		ArrayList<Integer> args = new ArrayList<Integer>();
		for (int i = 1; i < dataList.length; i++) {
			try {
				args.add(Integer.parseInt(dataList[i]));
			} catch (NumberFormatException e) {
				// do nothing
			}
		}
		
		// Check number of arguments
		if ((type == ActionEnum.Goto) && (args.size() != 1)) {
			return new ActionBlockData(ActionEnum.Unknown, new ArrayList<Integer>());
		} else if ((type == ActionEnum.Loop) && (args.size() != 3)) {
			return new ActionBlockData(ActionEnum.Unknown, new ArrayList<Integer>());
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
		}
		
		return -1; // none value
	}
	
	/**
	 * Access start point of loop. Return -1 if none.
	 * @return Start point
	 */
	public int getStartPoint() {
		if (type == ActionEnum.Loop) {
			return args.get(1);
		}
		
		return -1; // none value
	}
	
	/**
	 * Access line number for jump. Return -1 if none.
	 * @return Line number for jump
	 */
	public int getJumpLine() {
		if (type == ActionEnum.Goto) {
			return args.get(0);
		} else if (type == ActionEnum.Loop) {
			return args.get(2);
		}
		
		return -1; // none value
	}
	
	/**
	 * Access internal counter. Return -1 if none.
	 * @return Internal counter
	 */
	public int getCounter() {
		if (type == ActionEnum.Loop) {
			return counter;
		}
		
		return -1; // none value
	}
	
	/**
	 * Decrement internal counter by 1.
	 */
	public void decCounter() {
		if (type == ActionEnum.Loop) {
			--counter;
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

}
