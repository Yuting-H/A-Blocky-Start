package mvc;

import java.util.ArrayList;

/**
 * This model class stores a user's progress in the game. 
 * It loads/saves data using the user's data file. 
 * The user's ProgressionData (per stage) is stored as separate objects. 
 * @version March 14, 2024
 * @since ???
 * @author Eunhak Kim
 * @author Chun Ho Chan (Edward)
 */
public class UserData {
	
	/**
	 * Filename suffix of user data files
	 */
	public static final String filenameSuffix = "_userdata.csv";
	/**
	 * Type of user
	 */
	private UserTypeEnum userType;
	/**
	 * Account name of user
	 */
	private String username;
	/**
	 * Account password of user (filename = username + filenameSuffix)
	 */
	private String password;
	/**
	 * Total score from all stages
	 */
	private int totalScore;
	/**
	 * Total time spent from all stages (in minutes)
	 */
	private int totalTimeSpent;
	/**
	 * Total number of attempts from all stages
	 */
	private int totalAttempts;
	/**
	 * List of stage progression data
	 */
	private ArrayList<ProgressionData> progressionList;
	
	/**
	 * Construct a user data entry.
	 * @param userType Type of user
	 * @param username Account name of user
	 * @param password Account password of user
	 */
	public UserData(UserTypeEnum userType, String username, String password) {
		this.userType = userType;
		this.username = username;
		this.password = password;
		this.totalScore = 0;
		this.totalTimeSpent = 0;
		this.totalAttempts = 0;
		this.progressionList = new ArrayList<ProgressionData>();
	}
	
	/**
	 * Decode the encoded data stored in a user data file. 
	 * See exportData() for details. 
	 * Return null if the file does not exist.
	 * @param username Account name of user<br>
	 */
	public static UserData importData(String username) {
		// TODO: Try opening the file
		// ...create a file variable
		// Note: the filename = username + filenameSuffix.
		
		// TODO: If file does not exist, return null
		// if (...) {return null;}
		
		// TODO: Decode the first line of the user data file
		// ...store them in temporary variables
		
		// Call constructor
		UserData userData = new UserData(null, null, null); // TODO: replace null with temporary variables
		
		// Add the rest of the attributes
		userData.totalScore = -1; // TODO: replace -1 with temporary variables
		userData.totalTimeSpent = -1; // TODO: replace -1 with temporary variables
		userData.totalAttempts = -1; // TODO: replace -1 with temporary variables
		
		// Add each stage separately
		// while (!endOfFile(File)) {
		//   // read each line and feed it to the ProgressionData.importData() method
		//   userData.addProgressionData(ProgressionData.importData(File.readline()))
		// }
		
		return userData;
	}
	
	/**
	 * Export this user's data to the user data file.
	 * The first line contains user information and total statistics. 
	 * The lines after each contain detailed per-stage statistics. <br><br>
	 * Format: (without spaces)<br>
	 * "userType, username, password, totalScore, totalTimeSpent, totalAttempts"<br>
	 * "progressionData1"<br>
	 * "progressionData2"<br>
	 * "..."<br>
	 */
	public void exportUserData() {
		// Wipe the existing user data file, or create a new user data file if file not found
		// Note: filename = username + filenameSuffix
		// ...
		
		// Re-calculate all 4 overall statistics
		// i.e. totalTimeSpent = progressionData1.getTimeSpent() + progressionData2.getTimeSpent() + ...
		// ...
	}

	/**
	 * Access the filename of this user's data file
	 * @return Filename of user data file
	 */
	public String getFilename() {
		return username + filenameSuffix;
	}

	/**
	 * ...
	 * @return the userType
	 */
	public UserTypeEnum getUserType() {
		return userType;
	}

	/**
	 * ...
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ...
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ...
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * ...
	 * @return the totalTimeSpent
	 */
	public int getTotalTimeSpent() {
		return totalTimeSpent;
	}

	/**
	 * ...
	 * @return the totalAttempts
	 */
	public int getTotalAttempts() {
		return totalAttempts;
	}

	/**
	 * ...
	 * @return the progressionDataList
	 */
	public ArrayList<ProgressionData> getProgressionList() {
		return progressionList;
	}
	
	/**
	 * ...
	 * @return the progressionDataList
	 */
	public ProgressionData getProgressionAtIndex(int index) {
		// TODO: Check if index is out of bound
		// ...
		// return null;
		
		// Stage found
		return progressionList.get(index);
	}
	
	/**
	 * Recalculate the total statistics by summing all per-stage statistics.
	 */
	public void updateTotalStats() {
		// Reset all total statistics
		totalScore = 0;
		totalTimeSpent = 0;
		totalAttempts = 0;
		
		// Sum all detailed statistics
		ProgressionData temp = null;
		for (int i = 0; i < progressionList.size(); ++i) {
			temp = progressionList.get(i);
			totalScore += temp.getHighestScore();
			totalTimeSpent += temp.getTimeSpent();
			totalAttempts += temp.getAttempts();
		}
	}
	
	/**
	 * Check whether the user is a student.
	 * @return Boolean value
	 */
	public boolean isStudent() {
		return userType == UserTypeEnum.STUDENT;
	}
	
	/**
	 * Check whether the user is a teacher.
	 * @return Boolean value
	 */
	public boolean isTeacher() {
		return userType == UserTypeEnum.TEACHER;
	}
	
	/**
	 * Check whether the user is a developer.
	 * @return Boolean value
	 */
	public boolean isDeveloper() {
		return userType == UserTypeEnum.DEVELOPER;
	}
	
}
