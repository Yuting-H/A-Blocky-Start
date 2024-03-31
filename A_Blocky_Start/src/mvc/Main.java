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
	
	/**
	 * The JFrame that the game runs in.
	 */
	public static JFrame gameFrame = new JFrame();
	
	/**
	 * Colourblind overlay JPanel.
	 */
	private static PanelUI colourblindPanel = new PanelUI(new Point(0,0), new Dimension(800, 600), IconUI.colorblindColor);
	
	// Controllers
	public static SettingsController settingsController = new SettingsController();
	public static LoginController loginController = new LoginController();
	public static MainMenuController mainMenuController = new MainMenuController();
	public static TutorialController tutorialController = new TutorialController();
	public static StudentProgressionController studentProgressionController = new StudentProgressionController();
	public static TeacherProgressionController teacherProgressionController = new TeacherProgressionController();
	public static GameplayController gameplayController = new GameplayController();
	public static HighScoreController highScoreController = new HighScoreController();
	public static ErrorLogController errorLogController = new ErrorLogController();
	
	
	
	/**
	 * Main method, launch the game from here.
	 * @param args Arguments, should be empty
	 */
	public static void main(String[] args) {

		// Sets up the game's JFrame
		configureGameFrame();
		
		// Load initial screen, which is the login screen
		loginController.OnEnter();
	}
	
	/**
	 * Set up the game frame.
	 */
	public static void configureGameFrame() {
		// set up the game frame
		gameFrame.setVisible(true);
		gameFrame.setLayout(null);
		gameFrame.setResizable(false);
		gameFrame.setSize(getGameFrameDimension());
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.repaint();
		gameFrame.revalidate();
		
		// set up colourblind overlay
		gameFrame.add(colourblindPanel);
		gameFrame.setComponentZOrder(colourblindPanel, 0);
		setColorblindVisibility(settingsController.isColourblindMode());
		gameFrame.repaint();
		gameFrame.revalidate();
	}
	
	/**
	 * Get the size of the game frame.
	 */
	public static Dimension getGameFrameDimension() {
		return settingsController.getDimension();
	}
	
	/**
	 * Show/ Hide colourblind overlay.
	 * @param isColourblindMode True if enable, false otherwise.
	 */
	public static void setColorblindVisibility(boolean isColourblindMode) {
		colourblindPanel.setVisible(isColourblindMode);
	}
	
}
