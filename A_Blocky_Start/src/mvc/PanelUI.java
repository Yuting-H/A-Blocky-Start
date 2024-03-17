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
	
	PanelUI(Rectangle bound) {
		
		setLayout(null);
		setBounds(bound);
		setVisible(true);
		setBackground(Color.gray);
		
	}
	
	/**
	 * 
	 */
	 PanelUI(Dimension size) {
		 
			setLayout(null);
			setSize(size);
			setVisible(true);
			setBackground(Color.gray);
	}

	/**
	 * This function should be left empty
	 * Java will have runtime error if this is deleted
	 */
	public void OnEnter() {
	}

	


}
