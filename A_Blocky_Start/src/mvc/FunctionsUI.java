package mvc;
import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class FunctionsUI {

	
	/**
	 * This function makes a panel invisible and makes another one visible
	 * Used to switch the view from a panel to another
	 * @param from the panel to switch from
	 * @param to the panel to switch to
	 */
	public static void switchPanels(JPanel from, PanelUI to) {
		
		//checks if parameters are valid
		if (from == null || to == null) {
			throw new NullPointerException(" switchPanel() received null param");
		}else {
			
			//switches panel
			from.setVisible(false);
			to.setVisible(true);
			
			//Calls the new panels OnEnter function
			to.OnEnter();
		}
		
	}
	
	/**
	 * Checks if a login attempt is valid or not
	 * @param username
	 * @param password
	 */
	public static void checkValidLogin(String username, String password) {
		
		//TODO: finish this 
		
		if (username.isEmpty()) {
			
		}else {
			
			if (password.isEmpty()) {
				//student login
			}else if (false  /*password == teacherPassword*/) {
				//TODO: check teacher password
			}
			
			//switch to main menu after login is finished
			switchPanels(InitGame.login, InitGame.mainMenu);
			System.out.println("Logged in as: " + username);
			System.out.println("With password: " + password);
		}
		
	}
	
}
