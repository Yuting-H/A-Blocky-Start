package mvc;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * @author Yuting
 * This is the game frame, everything is suppose to be here
 * This class extends JFrame, there should be only one class that does this
 */
public class InitGame extends JFrame{
	
	//declares width and height of the frame
	final static Rectangle gameRect = new Rectangle(0, 0, 800, 600);
	
	//declares all the panels that can appear such as the main menu, login screen etc
	public static MainMenuView mainMenu 			= new MainMenuView(gameRect);
	public static StudentProgressionView progression 	= new StudentProgressionView(gameRect);
	public static LoginView login 				= new LoginView(gameRect);
	
	/**
	 * Creates the frame
	 * This is called only once by Main
	 */
	InitGame() {
		
		//sets up the game frame
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(gameRect);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 	//This makes the JFram appears centered on screen
		
		
		// uncomment these if you want to test them
		// adds panels
		// this.add(login);
		// this.add(mainMenu);
		// this.add(progression);

		
	}

}
