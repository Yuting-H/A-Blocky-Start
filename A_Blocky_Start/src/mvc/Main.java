package mvc;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class launches the game. 
 * @version 1.0
 * @since ???
 * @author Yuting
 */
public class Main {
	
	public static PanelUI colorblindPanel = new PanelUI(new Point(0,0), new Dimension(800, 600), IconUI.colorblindColor);
	
	/** The JFrame the game runs in*/
	 public static JFrame gameFrame = new JFrame();
	 
	 public static SettingsController settingsController = new SettingsController();	 
	 
	 public static ExampleMainMenuController exampleMainMenuController = new ExampleMainMenuController();
	 
	 public static LoginController loginController = new LoginController();
	 
	 public static MainMenuController mainMenuController = new MainMenuController();
	 
	 public static TutorialController tutorialController = new TutorialController();
	 
	 public static StudentProgressionController studentProgressionController = new StudentProgressionController();
	 
	 public static GameplayController gameplayController = new GameplayController();
	 
	 public static HighScoreController highScoreController = new HighScoreController();
	 
	 public static ErrorLogController errorLogController = new ErrorLogController();
	 
	 public static TeacherProgressionController teacherProgressionController = new TeacherProgressionController();

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		
		configureGameFrame();  //sets up the game's JFrame

		//TODO debug userdata load
		

		//UserData userData = UserData.importData(UserData.filenamePrefix + "aliceliddell" + UserData.filenameSuffix);

		//Load initial screen, which should be the login screen
		//you can change to other views for debug purposes
		//System.out.println(userData.toString());
	

		//studentProgressionController.setUserData(userData);

		loginController.OnEnter();

		
		setColorblindVisibility(settingsController.isColourblindMode());
		
		

	}
	
	public static void setColorblindVisibility(boolean isColourblindMode) {
		
		if (isColourblindMode) {
			gameFrame.remove(gameFrame.getComponentAt(0, 0));
			
			gameFrame.add(colorblindPanel);
			
			gameFrame.setComponentZOrder(colorblindPanel, 0);
			
			gameFrame.repaint();
			
			gameFrame.revalidate();
		}


	}
	
	
	/**
	 * Customize global gameFrame
	 */
	public static void configureGameFrame() {
		
		//sets up the game frame
		gameFrame.setLayout(null);
		gameFrame.setVisible(true);  
		gameFrame.setResizable(false);
		gameFrame.setSize(settingsController.getDimension());
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Get the size of the screen
	 */
	public static Dimension getDimension() {
		return settingsController.getDimension();
		
	}
	
}
