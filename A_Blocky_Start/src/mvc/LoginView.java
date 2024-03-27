package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.EventListener;

import javax.swing.JPanel;

/**
 * @author Yuting
 * This is the login page
 */
public class LoginView {
	
	//declaring bounds for components for this panel
	private Dimension viewSize = Main.getDimension();
	
	//root panel
	private static JPanel rootpanel;
	
	//declaring location of UI elements 
	private Point usernameLabelLocation		= new Point(200, 100);
	private Point usernameTextFieldLocation	= new Point(400, 100);
	private Point passwordLabelLocation 	= new Point(200, 200);
	private Point passwordTextFieldLocation = new Point(400, 200);
	private Point loginButtonLocation 		= new Point(450, 300);
	private Point registerButtonLocation	= new Point(250, 300);
	private Point reminderLabelLocation		= new Point(400, 80);
	
	//declaring size of UI elements
	private Dimension labelSize 		= new Dimension(100,20);
	private Dimension textFieldSize		= new Dimension(200,20);
	private Dimension loginButtonSize	= new Dimension(100, 20);
	private Dimension longLabelSize  	= new Dimension(200, 20);
	
	//declaring UI elements for this panel
	LabelUI 		usernameFieldLabel 	= new LabelUI(usernameLabelLocation, labelSize, "Username:");
	TextFieldUI 	usernameTextField 	= new TextFieldUI(usernameTextFieldLocation, textFieldSize);
	LabelUI			passwordFieldLabel	= new LabelUI(passwordLabelLocation, labelSize, "Password:");
	TextFieldUI 	passwordTextField	= new TextFieldUI(passwordTextFieldLocation, textFieldSize);
	ButtonUI		loginButton 		= new ButtonUI(loginButtonLocation, loginButtonSize, "Login");
	ButtonUI 		registerButton 		= new ButtonUI(registerButtonLocation, loginButtonSize, "Register");
	LabelUI			reminderLabel 		= new LabelUI(reminderLabelLocation, longLabelSize, "Username cannot be empty");
	
	/**
	 * Creates the view instance
	 */
	public LoginView() {
		
		//creates JPanel and set as root
		rootpanel = new JPanel();
		
		//creates UI components
		this.initPanel();
	}

	/**
	 * Initialize the login panel
	 */
	private void initPanel() {
		
		//set up root panel
		rootpanel.setSize(viewSize);
		rootpanel.setLayout(null);		
		rootpanel.setVisible(false);
		rootpanel.setBackground(Color.gray);
		
		//adding UI elements
		rootpanel.add(usernameFieldLabel);
		rootpanel.add(usernameTextField);
		rootpanel.add(passwordFieldLabel);
		rootpanel.add(passwordTextField);
		rootpanel.add(reminderLabel);
		rootpanel.add(registerButton);
		rootpanel.add(loginButton);
		
	}
	
	/**
	 * @return the string in the username field
	 */
	public String getUsername() {
		return usernameTextField.getText();
	}
	
	/**
	 * 
	 * @return the string in the password field
	 */
	public String getPassword() {
		return passwordTextField.getText();
	}
	/**
	 * Add action to login button
	 * @param actionListener
	 */
	public void loginButtonAddAction(ActionListener actionListener) {
		loginButton.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	public void registerButtonAddAction(ActionListener actionListener) {
		registerButton.addActionListener(actionListener);
	}
	
	/**
	 * Inserts the JPanel to the game frame
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootpanel);
	}
	
	/**
	 * Sets the visibility of the panel
	 * @param visibility
	 */
	public void setVisible(boolean visibility) {
		rootpanel.setVisible(visibility);
	}



}
