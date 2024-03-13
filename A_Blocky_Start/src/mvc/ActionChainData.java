package mvc;

import java.util.ArrayList;

/**
 * This model class stores a user's saved action chain in a stage. It loads/ saves data by communicating with the ProgressionData object. Each ActionBlock is stored as a separate object.
 * @version March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
public class ActionChainData {
	
	/**
	 * List of action blocks
	 */
	private ArrayList<ActionBlockData> actionBlockList;
	
	/**
	 * Index of the "Start" action block
	 */
	private int startIndex;
	
	/**
	 * Index of the "End" action block
	 */
	private int endIndex;
	
	
	/**
	 * Construct a clean action chain, with padded "Start" and "End" blocks.<br>
	 * <br>
	 * Note: Index 0 is "Unknown" block as padding, since "Start" is at index 1.
	 */
	public ActionChainData() {
		this.actionBlockList = new ArrayList<ActionBlockData>();
		actionBlockList.add(new ActionBlockData(ActionEnum.Unknown, new ArrayList<Integer>()));
		actionBlockList.add(new ActionBlockData(ActionEnum.Start, new ArrayList<Integer>()));
		actionBlockList.add(new ActionBlockData(ActionEnum.End, new ArrayList<Integer>()));
		this.startIndex = 1;
		this.endIndex = 2;
	}
	
	public static ActionChainData importData(String data) {
		// Split the data
		String[] dataList = data.split(",");
		
		// Decode data
		ArrayList<ActionBlockData> blockList = new ArrayList<ActionBlockData>();
		for (int i = 0; i < dataList.length; i++) {
			blockList.add(ActionBlockData.importData(dataList[i]));
		}
		
		return ActionChainData;
	}
	
	/**
	 * Append an action block to the end of the action chain. Returns true if successful.
	 * @param actionBlock
	 */
	public boolean appendActionBlock(ActionBlockData actionBlock) {
		if (actionBlock.getType() == ActionEnum.Unknown) {
			return false; // cannot insert "Unknown" action block
		} else if (actionBlock.getType() == ActionEnum.Start) {
			return false; // cannot insert "Start" action block
		} else if (actionBlock.getType() == ActionEnum.End) {
			return false; // cannot insert "End" action block
		}
		
		// Append action block
		actionBlockList.add(actionBlock);
		
		// Update first index
		if (firstIndex == 0) {
			firstIndex = 1; // index 0 is padding
		}
		
		// Update last index
		if (lastIndex == 0) {
			lastIndex = 1; // index 0 is padding
		} else if (lastIndex > 0) {
			++lastIndex;
		}
		
		// Successful
		return true;
	}

}
