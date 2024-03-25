package mvc;

import javax.swing.ImageIcon;

/**
 * This builder class stores an instance of all image icons.<br>
 * This uses the Lazy Loading Pattern.<br> 
 * @version 1.0
 * @since March 10, 2024
 * @author Yuting Hou
 * @author Chun Ho Chan (Edward)
 */
public class IconUI {
	/**
	 * The elliptical border surrounding screen-selection buttons
	 */
	public static ImageIcon buttonIcon = new ImageIcon("img/button.png");
	/**
	 * The back button
	 */
	public static ImageIcon backButtonIcon = new ImageIcon("img/BackButton.png");
}
