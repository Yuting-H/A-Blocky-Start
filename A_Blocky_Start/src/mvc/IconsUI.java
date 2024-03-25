package mvc;
import javax.swing.ImageIcon;


/**
 * @author Yuting
 * This class contains all the image used in the game
 */
public class IconsUI {
	
	//determines the quality of resampling images
	private static int samplingRate = 15;
	
	//game title
	public static ImageIcon gameTitleIcon = 
			new ImageIcon(
					//scale image to 600x100 with sampling rate 15
					new ImageIcon("img/Title.png").getImage().getScaledInstance(600, 100, samplingRate)  
					);	//transformas image to ImageIcon
	
	//Button ImageIcons
	
	//
	public static ImageIcon continueButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/continue.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon newGameButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/newgame.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon tutorialButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/tutorial.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon progressionButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/progression.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon highscoreButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/highscore.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	//
	public static ImageIcon settingsButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/settings.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	//
	public static ImageIcon exitButtonIcon = 
			new ImageIcon(
					//scale iamge with sampling rate 1
					new ImageIcon("img/exit.png").getImage().getScaledInstance(150, 40, samplingRate)
					);
	
	
	//TODO: add art for back button
	public static ImageIcon backButtonIcon = new ImageIcon("img/BackButton.png");
	
	
	
}
