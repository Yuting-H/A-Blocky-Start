package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class PanelUI extends JPanel{
	
	/**
	 * @deprecated
	 * @param bound
	 */
	PanelUI(Rectangle bound) {
		
		setLayout(null);
		setBounds(bound);
		setVisible(true);
		setBackground(Color.gray);
		
	}
	
	/**
	 * Constructor for panel whose location is managed by Layoutmanager
	 */
	 PanelUI(Dimension size) {
		 
			setLayout(null);
			setSize(size);
			setPreferredSize(size);
			setVisible(true);
			setBackground(Color.gray);

	}
	 
	 /**
	  *  Constructor for panel whose location is managed by Layoutmanager
	  * @param size
	  * @param color
	  */
	 PanelUI(Dimension size, Color color) {
		 
			setLayout(null);
			setSize(size);
			setPreferredSize(size);
			setVisible(true);
			setBackground(color);
			

	}


}
