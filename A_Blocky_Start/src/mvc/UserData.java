package mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This model class stores a user's progress in the game. 
 * It loads/saves data using the user's data file. 
 * The user's ProgressionData (per stage) is stored as separate objects. 
 * @version 1.0
 * @since Mar 14, 2024
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
	 * Account password of user 
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
	 * @see exportData() for details. 
	 * @param username Account name of user<br>
	 * @return UserData, or null if the file does not exist.
	 */
	public static UserData importData(String username) {

		String filename = username + filenameSuffix;
		
		try {
			
			FileReader fileIn = new FileReader(filename);
			Scanner scnr = new Scanner(fileIn);
			scnr.useDelimiter(","); // since this is a CSV file
			
			// Decode the first line and store them in temporary variables
			String usertype = scnr.next();
			scnr.next(); // skip username, which we know
			String password = scnr.next();
			int totalScore = scnr.nextInt();
			int totalTimeSpent = scnr.nextInt();
			int totalAttempts = scnr.nextInt();
			
			// Call constructor
			UserData userData = new UserData(UserTypeEnum.valueOf(usertype), username, password);
			
			// Add the rest of the attributes
			userData.addTotalScore(totalScore);
			userData.addTotalTimeSpent(totalTimeSpent);
			userData.addTotalAttempts(totalAttempts);
			
			// Add each stage separately
			while (scnr.hasNextLine()) {
			    // Read each line and feed it to the ProgressionData.importData() method
				ProgressionData importData = ProgressionData.importData(scnr.nextLine());
				// Then add the newly created ProgressionData object to the list
			    userData.addProgressionData(importData);
			}
			scnr.close();

 			return userData;
			
		} catch (FileNotFoundException e) {
			Main.errorLogController.addWarning(e);
			return null;
		}
	}
	
	/**
	 * Adds a single progression data to the list
	 * @param importData the ProgressionData to add
	 */
	private void addProgressionData(ProgressionData importData) {
		progressionList.add(importData);
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
		
		try {
			String filename = getFilename();
			
			File fileOut = new File(filename);
			fileOut.createNewFile(); // create a new file if not found
			
			// Wipe the user data file
			FileWriter writer = new FileWriter(fileOut);
			writer.write(""); 
			
			// Recalculate all statistics
			updateTotalStats();
			
			// Write the first line to the file
			String firstLine = "";
			firstLine += userType.toString();
			firstLine += ',';
			firstLine += username;
			firstLine += ',';
			firstLine += password;
			firstLine += ',';
			firstLine += totalScore;
			firstLine += ',';
			firstLine += totalTimeSpent;
			firstLine += ',';
			firstLine += totalAttempts;
			firstLine += '\n';
			
			writer.write(firstLine);
			
			// Write each per-stage progression data in its own line
			for (int i = 0; i < progressionList.size(); ++i) {
				ProgressionData pd = getProgressionAtIndex(i);
				// Use the ProgressionData.exportData() method to generate encoded data string
				writer.write(pd.exportData());
			}
			
			writer.close();

		} catch (IOException e) {
			e.printStackTrace(); // TODO: remove this later
			Main.errorLogController.addError(e);
		} 
	}

	/**
	 * Access the filename of this user's data file
	 * @return Filename of user data file
	 */
	public String getFilename() {
		return username + filenameSuffix;
	}

	/**
	 * Access the user type
	 * @return the userType
	 */
	public UserTypeEnum getUserType() {
		return userType;
	}

	/**
	 * Access the username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Access the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Access the total score for this user
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * Access the total time spent for this user
	 * @return the totalTimeSpent
	 */
	public int getTotalTimeSpent() {
		return totalTimeSpent;
	}

	/**
	 * Access the total number of attempts for this user
	 * @return the totalAttempts
	 */
	public int getTotalAttempts() {
		return totalAttempts;
	}

	/**
	 * Access the list containing the per-stage data
	 * @return the progressionDataList
	 */
	public ArrayList<ProgressionData> getProgressionList() {
		return progressionList;
	}
	
	/**
	 * Access the data for a stage from the list
	 * @param index Index of the stage
	 * @return ProgressionData, or null if not found
	 */
	public ProgressionData getProgressionAtIndex(int index) {
		// Check if index is out of bound
		if (index < 0 || index >= progressionList.size())
			return null;
		
		// Stage found
		return progressionList.get(index);
	}
	
	/**
	 * Add to the total score.
	 * @param score Score
	 */
	public void addTotalScore(int score) {
		totalScore += score;
	}
	
	/**
	 * Add to the total time spent (in minutes).
	 * @param timeSpent Time spent 
	 */
	public void addTotalTimeSpent(int timeSpent) {
		totalTimeSpent += timeSpent;
	}
	
	/**
	 * Add to the total number of attempts.
	 * @param attempts Number of attempts
	 */
	public void addTotalAttempts(int attempts) {
		totalAttempts += attempts;
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
			addTotalScore(temp.getHighestScore());
			addTotalTimeSpent(temp.getTimeSpent());
			addTotalAttempts(temp.getAttempts());
		}
	}
	
	/**
	 * Check whether the user is a student.
	 * @return True if user is a student, false otherwise
	 */
	public boolean isStudent() {
		return userType == UserTypeEnum.Student;
	}
	
	/**
	 * Check whether the user is a teacher.
	 * @return True if user is a teacher, false otherwise
	 */
	public boolean isTeacher() {
		return userType == UserTypeEnum.Teacher;
	}
	
	/**
	 * Check whether the user is a developer.
	 * @return True if user is a developer, false otherwise
	 */
	public boolean isDeveloper() {
		return userType == UserTypeEnum.Developer;
	}
	
}
