import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;


/**
 * @author Yuting
 * This is a JButton
 * When clicked, switches the view from one panel to another
 */
public class ButtonUI extends JButton{
	
	
	ButtonUI(Dimension size, String text) {
		
		setVisible(true);			//make button visible
		setSize(size);
		setIcon(IconsUI.buttonIcon);	//set image
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
	 * This creates a new button with a default background
	 * @param text the text inside the button
	 * @param bound the size and location of the button
	 */
	ButtonUI(Point location, Dimension size, String text) {
		
		setVisible(true);			//make button visible
		setLocation(location);			//set size and location
		setSize(size);
		setIcon(IconsUI.buttonIcon);	//set image
		setText(text);				//set text
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
		//remove default background
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	ButtonUI(Point location, Dimension size, String text, Icon icon) {
		
		setVisible(true);			//make button visible
		setLocation(location);			//set size and location
		setSize(size);
		setIcon(IconsUI.buttonIcon);	//set image
		setText(text);				//set text
		setIcon(icon);
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
		//remove default background
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	/**
	 * This creates a new custom button
	 * @param text
	 * @param icon
	 * @param bound
	 * @deprecated
	 */
	ButtonUI(String text, Icon icon, Rectangle bound) {
		
		setVisible(true);			//make button visible
		setBounds(bound);			//set size
		setIcon(icon);				//set image
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
