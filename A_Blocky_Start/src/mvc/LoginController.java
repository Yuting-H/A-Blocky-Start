package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.xml.crypto.Data;

/**
 * LoginController Contains LoginModel and LoginView
 * @version 0.2
 * @author Yuting
 * @author Eunhak
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
				
				//check if username is empty

				data.setUsernameInput(view.getUsername());
				data.setPasswordInput(view.getPassword());
				
				if (view.getUsername().isEmpty() ) {

					//TODO: notify user their username is empty,  
					
				}else {
					
					data.setUsernameInput(view.getUsername());
					data.setPasswordInput(view.getPassword());
					
					//if password == teacher password then enable teacher mode
					if (view.getPassword().compareTo(TEACHERPassword) == 0) {
						
						System.out.println("Logged in as teacher");
						
					}
					//if password matches developer password enable developer mode
					else if (view.getPassword().compareTo(DEVELOPERPassword) == 0) {
						
						System.out.println("Logged in as developer");
						
					}
					//load user data
					
						data.setUsernameInput(view.getUsername());
						data.setPasswordInput(view.getPassword());
						data.registerActiveUser();
						data.loginActiveUser();
					
					Main.loginController.OnExit();	
					Main.mainMenuController.OnEnter();
					//print login info
					System.out.println("Logged in with Username: " + view.getUsername() + ", Password: " + view.getPassword());
					
				}
			}
		});
	}
	
	/**
	 * 
	 * @return the mode of the game
	 */
	public UserTypeEnum getMode() {
		return data.getMode();
	}

	/**
	 * 
	 */
	public void OnEnter() {
		view.setVisible(true);
	}

	/**
	 * 
	 */
	public void OnExit() {
		view.setVisible(false);
	}

}
