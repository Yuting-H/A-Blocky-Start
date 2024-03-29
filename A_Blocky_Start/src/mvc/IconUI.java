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
	private static int samplingRate = 15;
	
	public static Color lightOrange = new Color(255, 220, 120, 255);
	public static Color mediumOrange = new Color(250, 150, 50, 255);
	public static Color darkOrange = new Color(200, 100, 50, 255);
	public static Color colorblindColor = new Color(150, 255, 150, 100);
	
	//game title
	public static ImageIcon gameTitleIcon = 
			new ImageIcon(
					//scale image to 600x100 with sampling rate 15
					new ImageIcon("img/GameTitle.png").getImage().getScaledInstance(600, 500, samplingRate)  
					);	//transforms image to ImageIcon
	
	// main menu background
	// TODO missing sprite
	public static ImageIcon mainMenuBackgroundIcon = 
			new ImageIcon(
					//scale image to 600x100 with sampling rate 15
					new ImageIcon("img/MenuBlank.png").getImage().getScaledInstance(600, 100, samplingRate)  
					);	//transforms image to ImageIcon
	
	//Button ImageIcons
	
	//
	public static ImageIcon continueButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuContinue.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon newGameButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuNewGame.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon tutorialButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuTutorial.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon progressionButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuProgression.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon highscoreButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuHighScores.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon settingsButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuSettings.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	//
	public static ImageIcon exitButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuExit.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	// TODO: missing sprite
	public static ImageIcon saveButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuSave.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	// TODO: missing sprite
	public static ImageIcon mainMenuButtonIcon = 
			new ImageIcon(
					//scale image with sampling rate 1
					new ImageIcon("img/MenuBlank.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	// 30 x 30
	public static ImageIcon backButtonIcon = new ImageIcon("img/IconBack.png");
	
	// 50 x 50
	public static ImageIcon pauseMenuButtonIcon = new ImageIcon("img/IconMenu.png");
	public static ImageIcon runChainButtonIcon = new ImageIcon("img/IconRun.png");
	public static ImageIcon pauseChainButtonIcon = new ImageIcon("img/IconPause.png");
	public static ImageIcon resetChainuttonIcon = new ImageIcon("img/IconReset.png");
	public static ImageIcon objectivesButtonIcon = new ImageIcon("img/IconObjectives.png");
	public static ImageIcon hintsButtonIcon = new ImageIcon("img/IconHints.png");
	public static ImageIcon debugChainButtonIcon = new ImageIcon("img/IconDebug.png");
	public static ImageIcon removeBlockButtonIcon = new ImageIcon("img/IconTrash.png");
	
	// 50 x 50
	public static ImageIcon startBlockIcon = new ImageIcon("img/ActionStart.png");
	public static ImageIcon endBlockIcon = new ImageIcon("img/ActionEnd.png");
	public static ImageIcon forwardBlockIcon = new ImageIcon("img/ActionForward.png");
	public static ImageIcon backBlockIcon = new ImageIcon("img/ActionBack.png");
	public static ImageIcon leftBlockIcon = new ImageIcon("img/ActionLeft.png");
	public static ImageIcon rightBlockIcon = new ImageIcon("img/ActionRight.png");
	public static ImageIcon gotoBlockIcon = new ImageIcon("img/ActionGoto.png");
	public static ImageIcon loopBlockIcon = new ImageIcon("img/ActionLoop.png");
	
	// 50 x 50
	public static ImageIcon mazeSpawnIcon = new ImageIcon("img/MazeSpawn.png");
	public static ImageIcon mazeExitIcon = new ImageIcon("img/MazeExit.png");
	public static ImageIcon mazePathIcon = new ImageIcon("img/MazePath.png");
	public static ImageIcon mazeBarrierIcon = new ImageIcon("img/MazeBarrier.png");
	public static ImageIcon mazePackageIcon = new ImageIcon("img/MazePackage.png");
	public static ImageIcon mazeBombIcon = new ImageIcon("img/MazeBomb.png");
	public static ImageIcon mazeRobotNorthIcon = new ImageIcon("img/MazeRobotNorth.png");
	public static ImageIcon mazeRobotEastIcon = new ImageIcon("img/MazeRobotEast.png");
	public static ImageIcon mazeRobotSouthIcon = new ImageIcon("img/MazeRobotSouth.png");
	public static ImageIcon mazeRobotWestIcon = new ImageIcon("img/MazeRobotWest.png");
	
	 // 100 x 130
	public static ImageIcon addForwardButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetForward.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addBackButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetBack.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addLeftButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetLeft.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addRightButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetRight.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addGotoButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetGoto.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	public static ImageIcon addLoopButtonIcon = new ImageIcon(
			// TODO re-scale image
			new ImageIcon("img/BuffetLoop.png").getImage().getScaledInstance(100, 130, samplingRate)
			);
	
}
