import java.awt.Rectangle;

import javax.swing.JTextField;

/**
 * @author Yuting
 *
 */
public class TextField extends JTextField{
	
	TextField(Rectangle bound){
		setVisible(true);
		setBounds(bound);
		setOpaque(isOpaque());
	}
	
}
