package mvc;
import java.util.ArrayList;

public class TeacherProgressionData {
	private ArrayList<StudentProgressionData> arr;
	
	TeacherProgressionData()
	{
		
	}
	
	public ArrayList<StudentProgressionData> getProgressionData()
	{
		return arr;
	}
	
	public void setProgressionData(ArrayList<StudentProgressionData> a)
	{
		arr = a;
	}

}
