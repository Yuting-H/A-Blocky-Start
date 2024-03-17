package mvc;

import java.io.File;
import java.util.ArrayList;

public class TeacherProgressionData {
	private ArrayList<StudentProgressionData> arrayList;

	TeacherProgressionData() {
		ArrayList<String> results = new ArrayList<String>();

		File folder = new File("Path");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				results.add(listOfFiles[i].getName());
			}
		}
		
		
	}

	public ArrayList<StudentProgressionData> getProgressionData() {
		return arrayList;
	}

	public void setProgressionData(ArrayList<StudentProgressionData> arrayList) {
		this.arrayList = arrayList;
	}

}
