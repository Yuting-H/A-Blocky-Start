package mvc;

/**
 * 
 */
public class LoginController implements Controller{
	
	//the view
	private static LoginView view = new LoginView();
	
	/**
	 * 
	 */
	public static void insertPanel() {
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
