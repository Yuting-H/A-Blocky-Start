package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;


/**
 * @author Yuting
 * This is the login page
 */
public class LoginView {
	
	//declaring bounds for components for this panel
	Rectangle 	usernameLabelBound 		= 	new Rectangle(200, 100, 100, 20);
	Rectangle 	usernameTextFieldBound 	= 	new Rectangle(400, 100, 200, 20);
	Rectangle 	passwordLabelBound 		= 	new Rectangle(200, 200, 100, 20);
	Rectangle 	passwordTextFieldBound 	= 	new Rectangle(400, 200, 200, 20);
	Rectangle 	loginButtonBound 		= 	new Rectangle(350, 300, 100, 20);
	Point		loginButtonLocation 	= new Point(350, 300);
	Dimension 	loginButtonSize 		= new Dimension(100, 20);
	
	//declaring components for this panel
	LabelUI 		usernameFieldLabel 		=	new LabelUI("Username: ", usernameLabelBound);
	TextFieldUI 	usernameTextField 		= 	new TextFieldUI(usernameTextFieldBound);
	LabelUI			passwordFieldLabel		= 	new LabelUI("Password: ", passwordLabelBound);
	TextFieldUI 	passwordTextField		= 	new TextFieldUI(passwordTextFieldBound);
	ButtonUI		loginButton 			=  	new ButtonUI(loginButtonLocation, loginButtonSize, "Login");
	
	//base panel
	private static JPanel panel;
	
	/**
	 * 
	 */
	public LoginView() {
		
		panel = new JPanel();
		
		this.initPanel();
	}

	/**
	 * Initialize the login panel
	 */
	private void initPanel() {
		
		Dimension viewSize = new Dimension(800, 600);
		
		panel.setSize(viewSize);
		panel.setLayout(null);

		
		panel.setVisible(true);
		panel.setBackground(Color.gray);
		panel.add(usernameFieldLabel);
		panel.add(usernameTextField);
		panel.add(passwordFieldLabel);
		panel.add(passwordTextField);
		panel.add(loginButton);
		
	}
	
	public void insertPanel () {
		Main.gameFrame.add(panel);
	}
	
	public void setVisible(boolean visibility) {
		panel.setVisible(visibility);
	}

	/**
	 * Runs when a button switchs the view to this frame
	 */
	public void OnEnter() {
		System.out.println("Entered login screen");
	}


	/**
	 * 
	 */
	public void OnExit() {
	}
}
