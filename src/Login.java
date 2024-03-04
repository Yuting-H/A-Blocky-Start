import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;


/**
 * @author Yuting
 * This is the login page
 */
public class Login extends Panel implements OnEnter{
	
	//declaring bounds for components for this panel
	Rectangle 	usernameLabelBound 		= 	new Rectangle(200, 100, 100, 20);
	Rectangle 	usernameTextFieldBound 	= 	new Rectangle(400, 100, 200, 20);
	Rectangle 	passwordLabelBound 		= 	new Rectangle(200, 200, 100, 20);
	Rectangle 	passwordTextFieldBound 	= 	new Rectangle(400, 200, 200, 20);
	Rectangle 	loginButtonBound 		= 	new Rectangle(350, 300, 100, 20);
	
	//declaring components for this panel
	Label 		usernameFieldLabel 		=	new Label("Username: ", usernameLabelBound);
	TextField 	usernameTextField 		= 	new TextField(usernameTextFieldBound);
	Label		passwordFieldLabel		= 	new Label("Password: ", passwordLabelBound);
	TextField 	passwordTextField		= 	new TextField(passwordTextFieldBound);
	Button		loginButton 			=  	new Button("Login", loginButtonBound);
	
	
	/**
	 * 
	 * @param bound
	 */
	Login(Rectangle bound){
		
		super(bound);
		
		loginButton.addActionListener(e -> 
			Functions.checkValidLogin(usernameTextField.getText(), passwordTextField.getText()));
		
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
