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
                String[] parts = line.split(", ");
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
		return usernameList[index];
	}
	
	public int getHighScore(int index) {
		return highScoreList[index];
	}
	
	public boolean setNameScore(String username, int highScore) {
        for (int i = 0; i < count; i++) {
            if (usernameList[i].equals(username)) {
                if (highScoreList[i] < highScore) {
                    highScoreList[i] = highScore;
                    sortScores();
                    return true;
                }
                return false;
            }
        }

        // If list is not full, add directly
        if (count < 5) {
            usernameList[count] = username;
            highScoreList[count] = highScore;
            count++;
            sortScores();
            return true;
        } else {
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
        // Bubble sort by high score in descending order
        for (int i = 0; i < count; i++) {
            for (int j = 1; j < (count - i); j++) {
                if (highScoreList[j - 1] < highScoreList[j]) {
                    // Swap scores
                    int tempScore = highScoreList[j - 1];
                    highScoreList[j - 1] = highScoreList[j];
                    highScoreList[j] = tempScore;
                    // Swap usernames
                    String tempUsername = usernameList[j - 1];
                    usernameList[j - 1] = usernameList[j];
                    usernameList[j] = tempUsername;
                }
            }
        }
    }
	
}

