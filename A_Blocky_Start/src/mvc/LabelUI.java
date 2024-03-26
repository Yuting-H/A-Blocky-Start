package mvc;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author Yuting
 *
 */
public class LabelUI extends JLabel{
	
	/**
	 * Creates a JLabel whose location is managed by layoutmanager
	 * @param size the size of the label
	 * @param text the text inside the label
	 */
	public LabelUI(Dimension size, String text) {
		setVisible(true);
		setSize(size);
		setText(text);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/**
	 * Creates a JLabel
	 * @param location
	 * @param size
	 * @param text
	 */
	public LabelUI(Point location, Dimension size, String text) {
		
		setVisible(true);
		setLocation(location);
		setSize(size);
		setText(text);
		
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.CENTER);
	}
	
	public LabelUI(Point location, Dimension size, Icon icon) {
		
		setVisible(true);
		setLocation(location);
		setSize(size);
		setIcon(icon);
		
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.CENTER);
	}

	/**
	 * @deprecated
	 * @param text
	 * @param bound
	 */
	LabelUI(String text, Rectangle bound) {
		
		setVisible(true);			//make Label visible
		setBounds(bound);			//set size and location
		setText(text);				//set text
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
	}
	

}
