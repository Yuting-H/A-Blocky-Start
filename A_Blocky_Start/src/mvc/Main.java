package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class Main {
	
	/** The JFrame the game runs in*/
	 public static JFrame gameFrame = new JFrame();
	 
	 //creates controllers
	 public static ExampleMainMenuController exampleMainMenuController = new ExampleMainMenuController();
	 //TODO: create other controllers 
	 public static LoginController loginController = new LoginController();
	 
	 public static MainMenuController mainMenuController = new MainMenuController();
	 
	 public static TutorialController tutorialController = new TutorialController();
	 
	 public static StudentProgressionController studentProgressionController = new StudentProgressionController();
	 
	 public static GameplayController gameplayController = new GameplayController();
	 
	 public static SettingsController settingsController = new SettingsController();
	 
	 public static HighScoreController highScoreController = new HighScoreController();
	 
	 public static ErrorLogController errorLogController = new ErrorLogController();

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		configureGameFrame();  //sets up the game's JFrame
		
		//Load initial screen, which should be the login screen
		//you can change to other views for debug purposes
		settingsController.OnEnter(); 
		
		
	}
	
	
	/**
	 * Customize global gameFrame
	 */
	public static void configureGameFrame() {
		
		//sets up the game frame
		gameFrame.setLayout(null);
		gameFrame.setVisible(true);  
		gameFrame.setResizable(false);
		gameFrame.setSize(800, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
