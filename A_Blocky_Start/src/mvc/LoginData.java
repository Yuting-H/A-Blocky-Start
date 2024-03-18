package mvc;

public class LoginData {
	private String username;
	private int password;
	
	LoginData(String u, int p)
	{
		username = u;
		password = p;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public int getPassword()
	{
		return password;
	}
	
	public void setUsername(String u)
	{
		username = u;
	}
	
	public void setPassword(int p)
	{
		password = p;
	}
	

}
