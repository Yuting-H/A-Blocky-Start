package mvc;

/**
 * This model class stores a user's progress in the game. 
 * It loads/saves data using the user's data file. 
 * The user's ProgressionData (per stage) is stored as separate objects. 
 * @author Eunhak Kim
 */

public class UserData {
	

	private String filename;
	private UserType userType;
	private String username;
	private String password;
	private int totalTimeSpent;
	private int totalAttempts;
	private int totalScore;
	private ProgressionData progressionDataList[];
	
	/**
	 * 
	 * @param filename
	 * @param userType
	 * @param username
	 * @param password
	 */
	UserData(String filename, UserType userType, String username, String password){
		this.filename = filename;
		this.userType = userType;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * 
	 * @param filename
	 */
	UserData(String filename){
		this.filename = filename;

	}
	/**
	 * 
	 * @param filename
	 */
	void exportUserData(String filename){
		
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the userType
	 */
	public Enum getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(Enum userType) {
		this.userType = userType;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the totalTimeSpent
	 */
	public int getTotalTimeSpent() {
		return totalTimeSpent;
	}

	/**
	 * @param totalTimeSpent the totalTimeSpent to set
	 */
	public void setTotalTimeSpent(int totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

	/**
	 * @return the totalAttempts
	 */
	public int getTotalAttempts() {
		return totalAttempts;
	}

	/**
	 * @param totalAttempts the totalAttempts to set
	 */
	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}

	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * @return the progressionDataList
	 */
	public ProgressionData[] getProgressionDataList() {
		return progressionDataList;
	}

	/**
	 * @param progressionDataList the progressionDataList to set
	 */
	public void setProgressionDataList(ProgressionData progressionDataList[]) {
		this.progressionDataList = progressionDataList;
	}
	
	/**
	 * 
	 * @return whether the user is a student
	 */
	public boolean isStudent() {
		return userType == UserType.STUDENT;
	}
	
	/**
	 * 
	 * @return whether the user is a teacher
	 */
	public boolean isTeacher() {
		return userType == UserType.TEACHER;
	}
	
	/**
	 * 
	 * @return whether the user is a developer
	 */
	public boolean isDeveloper() {
		return userType == UserType.DEVELOPER;
	}
	
}
