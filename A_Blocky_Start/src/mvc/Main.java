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
	 
	 public static TeacherProgressionController teacherProgressionController = new TeacherProgressionController();

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		configureGameFrame();  //sets up the game's JFrame

		UserData userData = UserData.importData("aliceliddell");
		
		//Load initial screen, which should be the login screen
		//you can change to other views for debug purposes
		//System.out.println(userData.toString());
	

		studentProgressionController.setUserData(userData);
		gameplayController.OnEnter();


		
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
