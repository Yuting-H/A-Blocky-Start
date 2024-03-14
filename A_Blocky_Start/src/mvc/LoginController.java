package mvc;

/**
 * LoginController
 * Contains LoginModel and LoginView
 */
public class LoginController implements Controller{
	
	//the view
	private static LoginView view = new LoginView();
	
	/**
	 * Insert the view into the game frame
	 */
	public void insertPanel() {
		view.insertPanel();
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
