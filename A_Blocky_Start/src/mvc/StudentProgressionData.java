package mvc;

import java.util.ArrayList;

public class StudentProgressionData {
	private ArrayList<ProgressionData> allProgressionList;
	private int page;

	StudentProgressionData() {
		page = 0;
		allProgressionList = new ArrayList<ProgressionData>();
	}

	public ProgressionData getProgression(int index) {
		return allProgressionList.get(index + (page - 1) * 10);
	}

	public void setProgresssion(UserData userData) {
		allProgressionList = userData.getProgressionList();
	}

	public int getPage() {
		return page;
	}

	public Boolean setPage(int page) {
		if (page < 1) {
			return false;
		}

		this.page = page;
		return true;
	}
}
