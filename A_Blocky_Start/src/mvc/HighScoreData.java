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
		
	}
	
}

