import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.*;

/**
 * @author Yuting
 *
 */
public class ContainerUI extends JPanel{
	

	/**
	 * 
	 * @param bound
	 * @param color
	 */
	ContainerUI(Rectangle bound, Color color) {
		setBackground(color);
		setVisible(true);
		setBounds(bound);
		setLayout(null);

	}
}
