import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.*;

/**
 * @author Yuting
 * This class creates a new JPanel with some default params initialized
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
