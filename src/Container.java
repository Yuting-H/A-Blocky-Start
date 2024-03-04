import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.*;

/**
 * @author Yuting
 *
 */
public class Container extends JPanel{
	
	/**
	 * 
	 */
	Container() {
	}
	
	
	Container(Rectangle bound, Color color) {
		//setBackground(color);
		setVisible(true);
		setBounds(bound);
		setLayout(null);

	}
}
