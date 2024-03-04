import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author Yuting
 *
 */
public class Label extends JLabel{

	/**
	 * 
	 * @param text
	 * @param bound
	 */
	Label(String text, Rectangle bound) {
		
		setVisible(true);			//make Label visible
		setBounds(bound);			//set size and location
		setText(text);				//set text
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		
	}
	
	/**
	 * 
	 * @param text
	 * @param icon
	 * @param bound
	 */
	Label(String text, Icon icon, Rectangle bound){
		
		setVisible(true);			//make Label visible
		setBounds(bound);			//set size and location
		setText(text);				//set text
		setIcon(icon); 				//set (optional) Icon
		
		//aligns text
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
	}
}
