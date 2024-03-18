package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class launches the game. 
 * @version 1.0
 * @since ???
 * @author Yuting
 */
public class Main {
	
	/** The JFrame the game runs in*/
	 public static JFrame gameFrame = new JFrame();
	 
	//TODO: Create other controllers 
	 public static ExampleMainMenuController exampleMainMenuController = new ExampleMainMenuController();
	 
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
		
		configureGameFrame();
		
		loginController.OnEnter(); //Load First screen
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
