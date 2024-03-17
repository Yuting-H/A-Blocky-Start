package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
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
	 * @deprecated
	 */
	ContainerUI(Rectangle bound, Color color) {
		setBackground(color);
		setVisible(true);
		setBounds(bound);
		setLayout(null);

	}
	
	/**
	 * 
	 * @param location
	 * @param size
	 * @param color 
	 */
	ContainerUI(Point location, Dimension size, Color color) {
		setBackground(color);
		setVisible(true);
		setLocation(location);
		setSize(size);
		setLayout(null);
		
	}
}
