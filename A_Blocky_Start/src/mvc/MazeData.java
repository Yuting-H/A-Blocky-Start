package mvc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This model class represents a maze layout. Each cell is represented by a MazeItem. The maze and inventory are updated in real time by the GameplayScreen. 
 * @version 1.0
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 */
public class MazeData {

	/**
	 * Filename prefix of user data files/ Directory name
	 */
	public static final String filenamePrefix = "./mazedata/";
	/**
	 * Filename infix of user data files
	 */
	public static final String filenameInfix = "stage";
	/**
	 * Filename suffix of user data files
	 */
	public static final String filenameSuffix = "_mazedata.csv";
	/**
	 * Maximum number of rows of tiles
	 */
	public static final int MAX_ROWS = 9;
	/**
	 * Maximum number of columns of tiles
	 */
	public static final int MAX_COLUMNS = 9;
	/**
	 * Stage ID
	 */
	int stageID;
	/**
	 * 2D grid of maze items
	 */
	MazeTypeEnum[][] mazeItemGrid;
	/**
	 * Row number of robot's current position
	 */
	int mazeRobotRow;
	/**
	 * Column number of robot's current position
	 */
	int mazeRobotColumn;
	/**
	 * Row offset of robot's next forward position<br>
	 * -1 = up, 1 = down
	 */
	int mazeRobotRowOffset;
	/**
	 * Column offset of robot's next forward position<br>
	 * -1 = left, 1 = right
	 */
	int mazeRobotColumnOffset;
	/**
	 * Current player score
	 */
	int score;
	/**
	 * Objectives text
	 */
	String objectives;
	/**
	 * Hints text
	 */
	String hints;
	
	/**
	 * Construct a maze data object.
	 * @param stageID Stage ID
	 * @param mazeItemGrid 2D grid of maze items
	 * @param mazeRobotRow Row number of robot's current position
	 * @param mazeRobotColumn Column number of robot's current position
	 */
	public MazeData(int stageID, MazeTypeEnum[][] mazeItemGrid, int mazeRobotRow, int mazeRobotColumn) {
		this.mazeItemGrid = mazeItemGrid;
		this.mazeRobotRow = mazeRobotRow;
		this.mazeRobotColumn = mazeRobotColumn;
		this.mazeRobotRowOffset = 0;
		this.mazeRobotColumnOffset = 1;
		this.score = 0;
	}
	
	/**
	 * Decode the encoded data stored in a stage data file.<br>
	 * @see exportData() for details. 
	 * @param filename Filename of the stage data (prefix + infix + username + suffix)<br>
	 * @return MazeData, or null if the file does not exist.
	 * Format: (without spaces)<br>
	 * "row1"<br>
	 * "row2"<br>
	 * "..."<br>
	 * "Objectives"<br>
	 * "Hints"<br>
	 */
	public static MazeData importData(String filename) {
		
		MazeTypeEnum[][] maze = new MazeTypeEnum[MAX_ROWS][MAX_COLUMNS];
		
		try {
			FileReader fileIn = new FileReader(filename);
			Scanner scnr = new Scanner(fileIn);
			scnr.useDelimiter(","); // since this is a CSV file
			
			// Decode the maze
			int robotRow = 0;
			int robotColumn = 0;
			for (int i = 0; i < MAX_ROWS; i++) {
				
				for (int j = 0; j < MAX_COLUMNS; j++) {
					maze[i][j] = MazeTypeEnum.fromString(scnr.next());
					
					if (maze[i][j] == MazeTypeEnum.SPAWN) {
						robotRow = i;
						robotColumn = j;
					}
				}
				
				scnr.nextLine();
			}
			
			// Read objectives
			String objectives = scnr.nextLine();
			String hints = scnr.nextLine();
			
			// Extract stage ID from filename
			String stageID = filename.substring(filenamePrefix.length() + filenameInfix.length(), filename.length() - filenameSuffix.length());
			System.out.println(filename + "," + stageID); // TODO
			
			// Call constructor
			MazeData mazeData = new MazeData(Integer.parseInt(stageID), maze, robotRow, robotColumn);
			
			// Add the rest of the attributes
			mazeData.setObjectives(objectives);
			mazeData.setHints(hints);
			
			scnr.close();

 			return mazeData;
			
		} catch (FileNotFoundException e) {
			Main.errorLogController.addWarning(e);
			return null;
		}
	}
	
	
	/*
	// Maze data cannot be exported to file since it is read-only.
	public void exportData() {
	}
	*/
	
	
	public void setObjectives(String text) {
		objectives = text;
	}
	
	public void setHints(String text) {
		hints = text;
	}
	
	/**
	 * Convert username to the filename of this maze's data file. 
	 * @param stageID Stage ID
	 * @return Filename of that stage data (prefix + infix + stageID + suffix)
	 */
	public static String toFilename(int stageID) {
		return filenamePrefix + filenameInfix + stageID + filenameSuffix;
	}
	
	/**
	 * Help to check if the indices are out-of-bound, i.e. 0 <= row < MAX_ROWS and 0 <= column < MAX_COLUMNS.
	 * @param row Row number
	 * @param column Column number
	 * @return True if index is out-of-bound, false otherwise
	 */
	public static boolean isIndexOutOfBound(int row, int column) {
		if ((row < 0) || (row >= MAX_ROWS) || (column < 0) || (column >= MAX_COLUMNS)) {
			return true; // index out of bound
		}
		
		return false; // index within bound
	}
	
}
