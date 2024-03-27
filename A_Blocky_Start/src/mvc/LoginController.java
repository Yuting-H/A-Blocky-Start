package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * LoginController controls LoginData and LoginView
 * @version 0.2
 * @author Yuting Hou
 * @author Eunhak Kim
 */
public class LoginController implements Controller {

	// the view
	private static LoginView view = new LoginView();
	// the model
	private static LoginData data = new LoginData();
	
	static final String TEACHERPassword = "GradeOurPorject100%";
	static final String DEVELOPERPassword = "TooManyMergeConflicts!";
	/**
	 * Construtor
	 */
	public LoginController() {
		view.insertPanelToFrame();

		populateActionListener();
	}

	/**
	 * Add action listener to UI elements
	 */
	private void populateActionListener() {
		
		//add action listener to the login button
		view.loginButtonAddAction(new ActionListener() {

			@Override
			//switch from login view to main menu view 
			public void actionPerformed(ActionEvent e) {
				
				//check if username is acceptable
				if (!(data.setUsernameInput(view.getUsername()))) {
					System.out.println("Enter username");
				}
				//check if password is acceptable
				if (!(data.setPasswordInput(view.getPassword()))) {
					System.out.println("Enter password");
				}
				else {
					//register if new user, then logs in with the provided username and password
					data.setUsernameInput(view.getUsername());
					data.setPasswordInput(view.getPassword());
					if (data.registerActiveUser()) {
						System.out.println("New user registered");
					}
					
					if (!data.loginActiveUser()) {
						System.out.println("Login failed");
					}
					
					Main.loginController.OnExit();	
					Main.mainMenuController.OnEnter();
					//print login info
					System.out.println("Logged in with Username: " + view.getUsername() + ", Password: " + view.getPassword());
					
				}
			}
		});
	}
	
	/**
	 * Access the game mode
	 * @return the mode of the game
	 */
	public UserTypeEnum getMode() {
		return data.getMode();
	}

	/**
	 * Show the screen
	 */
	public void OnEnter() {
		view.setVisible(true);
	}

	/**
	 * Close the screen
	 */
	public void OnExit() {
		view.setVisible(false);
	}

}
