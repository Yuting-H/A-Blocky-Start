package mvc;
import javax.swing.ImageIcon;


/**
 * @author Yuting
 * This class contains all the image used in the game
 */
public class IconUI {
	
	//determines the quality of re-sampling images
	private static int samplingRate = 15;
	
	//game title
	public static ImageIcon gameTitleIcon = 
			new ImageIcon(
					//scale image to 600x100 with sampling rate 15
					new ImageIcon("img/Title.png").getImage().getScaledInstance(600, 100, samplingRate)  
					);	//transforms image to ImageIcon
	
	// main menu background
	// TODO missing sprite
	public static ImageIcon mainMenuBackgroundIcon = 
			new ImageIcon(
					//scale image to 600x100 with sampling rate 15
					new ImageIcon("img/Title.png").getImage().getScaledInstance(600, 100, samplingRate)  
					);	//transforms image to ImageIcon
	
	//Button ImageIcons
	
	//
	public static ImageIcon continueButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/continue.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon newGameButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/newgame.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon tutorialButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/tutorial.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon progressionButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/progression.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon highscoreButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/highscore.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon settingsButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/settings.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	//
	public static ImageIcon exitButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/exit.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	// TODO: missing sprite
	public static ImageIcon saveButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/exit.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	// TODO: missing sprite
	public static ImageIcon mainMenuButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/exit.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	
	//TODO: add art for back button
	public static ImageIcon backButtonIcon = new ImageIcon("img/BackButton.png"); // 30 x 30
	
	// TODO add color
	public static ImageIcon pauseMenuButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
	
	// TODO missing sprite
	public static ImageIcon runChainButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
		
	// TODO missing sprite
	public static ImageIcon pauseChainButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
	
	// TODO missing sprite
	public static ImageIcon resetChainuttonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
		
	// TODO missing sprite
	public static ImageIcon objectivesButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
	
	// TODO missing sprite
	public static ImageIcon hintsButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
	
	// TODO missing sprite
	public static ImageIcon debugChainButtonIcon = new ImageIcon("img/PauseMenuButton.png"); // 50 x 50
	
	// TODO missing sprite
	public static ImageIcon addForwardButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
	// TODO missing sprite
	public static ImageIcon addBackButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
	// TODO missing sprite
	public static ImageIcon addLeftButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
	// TODO missing sprite
	public static ImageIcon addRightButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
	// TODO missing sprite
	public static ImageIcon addGotoButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
	// TODO missing sprite
	public static ImageIcon addLoopButtonIcon = new ImageIcon("img/AddTestButton.png"); // 100 x 130
	
}
