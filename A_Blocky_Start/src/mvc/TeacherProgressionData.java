package mvc;

import java.io.File;
import java.util.ArrayList;

public class TeacherProgressionData {
	private ArrayList<String> allFilenameList;
	private ArrayList<String> filenameList;
	private ArrayList<UserData> userDataList;
	private int page;

	TeacherProgressionData() {
		page = 0;
		filenameList = new ArrayList<String>();
		allFilenameList = new ArrayList<String>();
		userDataList = new ArrayList<UserData>();
		
		File folder = new File("./userdata");
		File[] fileList = folder.listFiles();

		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				allFilenameList.add(fileList[i].getName());
			}
		}
	}

	public UserData GetUserData(int index) {
		return userDataList.get(index);
	}

	public int getPage() {
		return page;
	}

	public void setFilenameList() {
		filenameList.clear();

		int index = (page - 1) * 10;

		for (int i = 0; i < 10; i++) {
			if (index + i < allFilenameList.size()) {
				filenameList.add(allFilenameList.get(index + i));
			} else {
				break;
			}
		}
	}

	public Boolean setPage(int page) {
		if (page < 1) {
			return false;
		}

		this.page = page;
		return true;
	}
}
