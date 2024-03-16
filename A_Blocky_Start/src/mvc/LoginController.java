package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginController Contains LoginModel and LoginView
 */
public class LoginController implements Controller {

	// the view
	private static LoginView view = new LoginView();

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
				
				Main.loginController.OnExit();	
				Main.mainMenuController.OnEnter();
			}
		});
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
