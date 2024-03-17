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
	 * Return null if the file does not exist.
	 * @param username Account name of user<br>
	 */
	public static UserData importData(String username) {

		String filename = username + filenameSuffix;
		
		try {
			
			FileReader fileIn = new FileReader(filename);
			Scanner scnr = new Scanner(fileIn);
			scnr.useDelimiter(","); // since this is a csv file
			
			// Decode the first line and store them in temporary variables
			String usertype = scnr.next();
			scnr.next(); // skips username, which we know
			String password = scnr.next();
			int totalScore = scnr.nextInt();
			int totalTimeSpent = scnr.nextInt();
			int totalAttempts = scnr.nextInt();
			
			// Call constructor
			UserData userData = new UserData(UserTypeEnum.valueOf(usertype), username, password);
			
			// Add the rest of the attributes
			userData.totalScore = totalScore;
			userData.totalTimeSpent = totalTimeSpent;
			userData.totalAttempts = totalAttempts;
			
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
			File file = new File(filename);
			file.createNewFile(); // creates file if it does not exist
			
			FileWriter writer = new FileWriter(filename);
			writer.write(""); // Wipe the user data file
			
			// Recalculate all statistics
			updateTotalStats();
			// Write the first line to the file
			String firstLine = userType + "," + username + "," + password + "," 
					+ totalScore + "," + totalTimeSpent + "," + totalAttempts + "\n";
			writer.write(firstLine);
			
			// Write the progression data, each stage in its own line
			for (int i = 0; i < progressionList.size(); i++) {
				ProgressionData pd = getProgressionAtIndex(i);
				// Use the ProgressionData.exportData() method to generate string
				String str = pd.exportData();
				writer.write(str);
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
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
	 * Get the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Get the total score for this user
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * Get the total time spent for this user
	 * @return the totalTimeSpent
	 */
	public int getTotalTimeSpent() {
		return totalTimeSpent;
	}

	/**
	 * Get the total number of attempts for this user
	 * @return the totalAttempts
	 */
	public int getTotalAttempts() {
		return totalAttempts;
	}

	/**
	 * Get the list containing the per-stage data
	 * @return the progressionDataList
	 */
	public ArrayList<ProgressionData> getProgressionList() {
		return progressionList;
	}
	
	/**
	 * Get the data for a stage from the list
	 * @param index the index of the stage
	 * @return the ProgressionData at the index
	 */
	public ProgressionData getProgressionAtIndex(int index) {
		// Check if index is out of bound
		if (index < 0 || index >= progressionList.size())
			return null;
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
		for (int i = 0; i < progressionList.size(); i++) {
			temp = progressionList.get(i);
			totalScore += temp.getHighestScore();
			totalTimeSpent += temp.getTimeSpent();
			totalAttempts += temp.getAttempts();
		}
	}
	
	/**
	 * Check whether the user is a student.
	 * @return true if user is a student, false otherwise
	 */
	public boolean isStudent() {
		return userType == UserTypeEnum.STUDENT;
	}
	
	/**
	 * Check whether the user is a teacher.
	 * @return true if user is a teacher, false otherwise
	 */
	public boolean isTeacher() {
		return userType == UserTypeEnum.TEACHER;
	}
	
	/**
	 * Check whether the user is a developer.
	 * @return true if user is a developer, false otherwise
	 */
	public boolean isDeveloper() {
		return userType == UserTypeEnum.DEVELOPER;
	}
	
}
