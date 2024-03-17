package mvc;

import java.util.ArrayList;

public class StudentProgressionData {
	private ArrayList<ProgressionData> arrayList;

	StudentProgressionData() {
		UserData user = LoginScreen.getActiveUser();
		arrayList = UserData.getProgressionScreen();
	}

	public ArrayList<ProgressionData> exportProgressionData() {
		return arrayList;
	}
}
