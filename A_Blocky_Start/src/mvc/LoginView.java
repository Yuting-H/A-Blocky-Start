package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * @author Yuting
 * This is the login page
 */
public class LoginView {
	
	//declaring bounds for components for this panel
	Dimension 	viewSize = new Dimension(800, 600);
	
	//declaring location of UI elements 
	private Point usernameLabelLocation		= new Point(200, 100);
	private Point usernameTextFieldLocation	= new Point(400, 100);
	private Point passwordLabelLocation 	= new Point(200, 200);
	private Point passwordTextFieldLocation = new Point(400, 200);
	private Point loginButtonLocation 		= new Point(350, 300);
	
	//declaring size of UI elements
	private Dimension labelSize 		= new Dimension(100,20);
	private Dimension textFieldSize		= new Dimension(200,20);
	private Dimension loginButtonSize	= new Dimension(100, 20);
	
	//declaring UI elements for this panel
	LabelUI 		usernameFieldLabel 	= new LabelUI(usernameLabelLocation, labelSize, "Username:");
	TextFieldUI 	usernameTextField 	= new TextFieldUI(usernameTextFieldLocation, textFieldSize);
	LabelUI			passwordFieldLabel	= new LabelUI(passwordLabelLocation, labelSize, "Password:");
	TextFieldUI 	passwordTextField	= new TextFieldUI(passwordTextFieldLocation, textFieldSize);
	ButtonUI		loginButton 		= new ButtonUI(loginButtonLocation, loginButtonSize, "Login");
	
	//base panel
	private static JPanel panel;
	
	/**
	 * Creates 
	 */
	public LoginView() {
		
		panel = new JPanel();
		
		this.initPanel();
	}

	/**
	 * Initialize the login panel
	 */
	private void initPanel() {
		
		//set up base panel
		panel.setSize(viewSize);
		panel.setLayout(null);		
		panel.setVisible(true);
		panel.setBackground(Color.gray);
		
		//adding UI elements
		panel.add(usernameFieldLabel);
		panel.add(usernameTextField);
		panel.add(passwordFieldLabel);
		panel.add(passwordTextField);
		panel.add(loginButton);
		
	}
	
	/**
	 * Inserts the JPanel to the game frame
	 */
	public void insertPanel () {
		Main.gameFrame.add(panel);
	}
	
	/**
	 * Sets the visibility of the panel
	 * @param visibility
	 */
	public void setVisible(boolean visibility) {
		panel.setVisible(visibility);
	}

	/**
	 * When the view entered
	 */
	public void OnEnter() {
		System.out.println("Entered login screen");
	}


	/**
	 * When the view exits
	 */
	public void OnExit() {
	}
}
