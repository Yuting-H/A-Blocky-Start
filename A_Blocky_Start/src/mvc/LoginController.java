package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginController Contains LoginModel and LoginView
 */
public class LoginController implements Controller {

	// the view
	private static LoginView view = new LoginView();
	
	private static LoginData data = new LoginData();

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
				if (view.getUsername().isEmpty() || view.getUsername().isEmpty()) {
					//notify user
				}else {
					
					//if password == teacher password then enable teacher mode
					
				}
				
				//put lines below in the above else bracked
				Main.loginController.OnExit();	
				Main.mainMenuController.OnEnter();
				//print login info
				System.out.println("Logged in with Username: " + view.getUsername() + ", Password: " + view.getPassword());
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
