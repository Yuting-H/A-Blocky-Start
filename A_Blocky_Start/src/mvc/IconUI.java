package mvc;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;


/**
 * @author Yuting
 * This class contains all the image used in the game
 */
public class IconUI {
	
	// Size of various UI elements
	public static final Dimension FRAME_SIZE = new Dimension(800, 600); // TODO delete this later
	public static final Dimension TEXT_BUTTON_SIZE = new Dimension(150, 40);
	public static final Dimension ICON_BUTTON_SIZE = new Dimension(50, 50);
	public static final Dimension BACK_BUTTON_SIZE = new Dimension(30, 30);
	public static final Dimension ACTION_BUTTON_SIZE = new Dimension(100, 130);
	
	// TODO re-scale images of incorrect sizes
	private static int samplingRate = 1;
	
	public static Color lightOrange = new Color(255, 220, 120, 255);
	public static Color mediumOrange = new Color(250, 150, 50, 255);
	public static Color darkOrange = new Color(200, 100, 50, 255);
	public static Color colorblindColor = new Color(150, 255, 150, 100);
	
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
	
	// 30 x 30
	public static ImageIcon backButtonIcon = new ImageIcon("img/BackButton.png");
	
	// 50 x 50
	public static ImageIcon pauseMenuButtonIcon = new ImageIcon("img/PauseMenuButton.png");
	public static ImageIcon runChainButtonIcon = new ImageIcon("img/RunActionChainButton.png");
	public static ImageIcon pauseChainButtonIcon = new ImageIcon("img/PauseActionChainButton.png");
	public static ImageIcon resetChainuttonIcon = new ImageIcon("img/ResetActionChainButton.png");
	public static ImageIcon objectivesButtonIcon = new ImageIcon("img/ObjectivesButton.png");
	public static ImageIcon hintsButtonIcon = new ImageIcon("img/HintsButton.png");
	public static ImageIcon debugChainButtonIcon = new ImageIcon("img/DebugButton.png");
	public static ImageIcon removeBlockButtonIcon = new ImageIcon("img/TrashButton.png");
	
	// 50 x 50
	public static ImageIcon startBlockIcon = new ImageIcon("img/StartBlock.png");
	public static ImageIcon endBlockIcon = new ImageIcon("img/EndBlock.png");
	public static ImageIcon forwardBlockIcon = new ImageIcon("img/ForwardBlock.png");
	public static ImageIcon backBlockIcon = new ImageIcon("img/BackBlock.png");
	public static ImageIcon leftBlockIcon = new ImageIcon("img/LeftBlock.png");
	public static ImageIcon rightBlockIcon = new ImageIcon("img/RightBlock.png");
	public static ImageIcon gotoBlockIcon = new ImageIcon("img/GotoBlock.png");
	public static ImageIcon loopBlockIcon = new ImageIcon("img/LoopBlock.png");
	
	 // 100 x 130
	public static ImageIcon addForwardButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddForwardBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addBackButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddBackBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addLeftButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddLeftBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addRightButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddRightBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addGotoButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddGotoBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addLoopButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/AddLoopBlockButton.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	
}
