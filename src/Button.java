import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;


/**
 * @author Yuting
 * This is a JButton
 * When clicked, switches the view from one panel to another
 */
public class Button extends JButton{
	
	/**
	 * This creates a new (custom) button with a default background
	 * @param text the text inside the button
	 * @param bound the size and location of the button
	 */
	Button(String text, Rectangle bound) {
		
		setVisible(true);			//make button visible
		setBounds(bound);			//set size and location
		setIcon(Icons.buttonIcon);	//set image
		setText(text);				//set text
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
		//remove default background
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	/**
	 * This creates a new (custom) button
	 * @param text
	 * @param icon
	 * @param bound
	 */
	Button(String text, Icon icon, Rectangle bound) {
		
		setVisible(true);			//make button visible
		setBounds(bound);			//set size
		setIcon(icon);	//set image
		setText(text);				//set text
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
		//remove default background
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	
	
	
}
