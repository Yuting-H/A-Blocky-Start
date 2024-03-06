import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;


/**
 * @author Yuting
 * This is the login page
 */
public class LoginUI extends PanelUI implements OnEnter{
	
	//declaring bounds for components for this panel
	Rectangle 	usernameLabelBound 		= 	new Rectangle(200, 100, 100, 20);
	Rectangle 	usernameTextFieldBound 	= 	new Rectangle(400, 100, 200, 20);
	Rectangle 	passwordLabelBound 		= 	new Rectangle(200, 200, 100, 20);
	Rectangle 	passwordTextFieldBound 	= 	new Rectangle(400, 200, 200, 20);
	Rectangle 	loginButtonBound 		= 	new Rectangle(350, 300, 100, 20);
	Point		loginButtonLocation = new Point(350, 300);
	Dimension 	loginButtonSize = new Dimension(100, 20);
	
	//declaring components for this panel
	LabelUI 		usernameFieldLabel 		=	new LabelUI("Username: ", usernameLabelBound);
	TextFieldUI 	usernameTextField 		= 	new TextFieldUI(usernameTextFieldBound);
	LabelUI		passwordFieldLabel		= 	new LabelUI("Password: ", passwordLabelBound);
	TextFieldUI 	passwordTextField		= 	new TextFieldUI(passwordTextFieldBound);
	ButtonUI		loginButton 			=  	new ButtonUI(loginButtonLocation, loginButtonSize, "Login");
	
	
	/**
	 * 
	 * @param bound
	 */
	LoginUI(Rectangle bound){
		
		super(bound);
		
		loginButton.addActionListener(e -> 
			FunctionsUI.checkValidLogin(usernameTextField.getText(), passwordTextField.getText()));
		
		//adding component 
		add(usernameFieldLabel);
		add(usernameTextField);
		add(passwordFieldLabel);
		add(passwordTextField);
		add(loginButton);
		
	}


	/**
	 * Runs when a button switchs the view to this frame
	 */
	@Override
	public void OnEnter() {
		System.out.println("Entered login screen");
	}
}
