package mvc;

/**
 * This model class stores a user's progression in a stage. It loads/ saves data by communicating with the UserData object. The ActionChain is stored as a separate object.
 * @version March 11, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 */
public class ProgressionData {
	
	/**
	 * ID of this stage
	 */
	private int stageID;
	/**
	 * Completion status
	 */
	private boolean completed;
	/**
	 * Shortest number of steps
	 */
	private int shortestSteps;
	/**
	 * Highest score achieved
	 */
	private int highestScore;
	/**
	 * Time spent (in minutes)
	 */
	private int timeSpent;
	/**
	 * Number of attempts
	 */
	private int attempts;
	/**
	 * Stored action chain
	 */
	private ActionChainData actionChain;
	
	/**
	 * Construct a stage progression entry.
	 * @param stageID ID of this stage
	 * @param completed Completion status
	 */
	public ProgressionData(int stageID, boolean completed) {
		this.stageID = stageID;
		this.completed = completed;
		this.shortestSteps = 0;
		this.highestScore = 0;
		this.timeSpent = 0;
		this.attempts = 0;
		// TODO
	}
	
	/**
	 * Decode the encoded data string and call the constructor. See exportData() for details.
	 * @param data Encoded data string
	 * @return ProgressionData
	 */
	public static ProgressionData importData(String data) {
		String[] dataList = data.split(",");
		
		// TODO
		return new ProgressionData(-1, false);
	}
	
	/**
	 * Export this stage's progression data as an encoded data string.<br>
	 * The string always begins with "Start" and ends with "End", with each action block separated with ",".<br><br>
	 * Format: (without whitespace)<br>
	 * "stageID, completed, shortestSteps, highestScore, timeSpent, attempts, actionChain"<br>
	 * @return Encoded data string
	 */
	public String exportData() {
		// TODO
		return "";
	}
	
	/**
	 * Access the ID of this stage.
	 * @return
	 */
	public int getStageID() {
		return stageID;
	}

	/**
	 * Access the completion status of this stage.
	 * @return
	 */
	public boolean getCompleted() {
		return completed;
	}

	/**
	 * Access the shortest number of steps.
	 * @return
	 */
	public int getShortestSteps() {
		return shortestSteps;
	}

	/**
	 * Access the highest score.
	 * @return
	 */
	public int getHighestScore() {
		return highestScore;
	}

	/**
	 * Access the time spent (in minutes).
	 * @return
	 */
	public int getTimeSpent() {
		return timeSpent;
	}

	/**
	 * Access the number of attempts.
	 * @return
	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * Access the stored action chain.
	 * @return
	 */
	public ActionChainData getActionChain() {
		return actionChain;
	}

	/**
	 * Mark this stage as completed.
	 */
	public void markAsCompleted() {
		this.completed = true;
	}

	/**
	 * Update the shortest number of steps. Return false if steps are greater than/ equal to shortest steps.
	 * @param steps Number of steps
	 * @return Boolean state
	 */
	public boolean updateShortestSteps(int steps) {
		if (steps >= shortestSteps) {
			return false;
		}
		
		// Successful
		shortestSteps = steps;
		return true;
	}

	/**
	 * Update the highest score achieved. Return false if score smaller than/ equal to highest score.
	 * @param score Score
	 * @return Boolean state
	 */
	public boolean updateHighestScore(int score) {
		if (score <= highestScore) {
			return false;
		}
		
		// Successful
		highestScore = score;
		return true;
	}

	/**
	 * Add to the time spent.
	 * @param time Additional time spent
	 */
	public void addTimeSpent(int timeSpent) {
		this.timeSpent += timeSpent;
	}

	/**
	 * Add to the number of attempts.
	 * @param attempts
	 */
	public void addAttempts(int attempts) {
		this.attempts += attempts;
	}

	/**
	 * Mutate the stored action chain.
	 * @param actionChain
	 */
	public void setActionChain(ActionChainData actionChain) {
		this.actionChain = actionChain;
	}
}
