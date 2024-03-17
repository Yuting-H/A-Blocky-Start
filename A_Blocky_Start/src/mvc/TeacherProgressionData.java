package mvc;
import java.util.ArrayList;

public class TeacherProgressionData {
	private ArrayList<StudentProgressionData> arrayList;
	
	TeacherProgressionData()
	{
		
	}
	
	public ArrayList<StudentProgressionData> getProgressionData()
	{
		return arrayList;
	}
	
	public void setProgressionData(ArrayList<StudentProgressionData> arrayList)
	{
		this.arrayList = arrayList;
	}

}
