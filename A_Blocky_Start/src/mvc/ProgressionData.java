package mvc;

/**
 * This model class stores a user's progress in a stage. It loads/ saves data by communicating with the UserData object. The ActionChain is stored as a separate object.
 * @version March 11, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 */
public class ProgressionData {
	
	private int stageID;
	private boolean completed;
	private int shortestSteps;
	private int highestScore;
	private int timeSpent;
	private int attempts;
	private ActionChainData actionChain;
	
	public ProgressionData(int stageID, boolean completed) {
		this.stageID = stageID;
		this.completed = completed;
	}
	
	public ProgressionData(String dataCSV) {
		String[] dataList = dataCSV.split(",");
	}
}
