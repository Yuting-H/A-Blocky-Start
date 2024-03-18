package mvc;

import java.io.*;
import java.util.*;

public class HighScoreData {
	private String[] usernameList = new String[5];
	private int[] highScoreList = new int[5];
	private int count = 0;
	
	public HighScoreData(String fileName) {
		// read the file
		for (int i = 0; i < 5; i++) {
            usernameList[i] = ""; // Use an empty string to indicate no username
            highScoreList[i] = 0; // Use -1 to indicate no score
        }
 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    setNameScore(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void exportHighScore(String fileName) {
		// write to the file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 5; i++) {
                writer.write(usernameList[i] + ", " + highScoreList[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String getUsername(int index) {
		if (0 <= index  && index <= 4) {
			return usernameList[index];
		}
		
		return "";
	}
	
	public int getHighScore(int index) {
		if (0 <= index  && index <= 4) {
			return highScoreList[index];
		}
		return 0;
	}
	
	public boolean setNameScore(String username, int highScore) {

        // If list is not full, add directly
        if (count < 5) {
            usernameList[count] = username;
            highScoreList[count] = highScore;
            count++;
            sortScores();
            return true;
        } 
        else {
            // If the new score is higher than the lowest score in the list
            if (highScore > highScoreList[4]) {
                usernameList[4] = username;
                highScoreList[4] = highScore;
                sortScores();
                return true;
            }
        }
        return false;
    }

    private void sortScores() {
        for (int i = 4; i >= 0; i--) {
            if (highScoreList[i] > highScoreList[i-1]) {
            	int tempHS = highScoreList[i];
            	highScoreList[i] = highScoreList[i-1];
            	highScoreList[i-1] = tempHS;
            }
            else {
            	break;
            }
        }
    }
	
}

