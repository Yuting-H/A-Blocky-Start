import java.awt.Rectangle;

import javax.swing.JTextField;

/**
 * @author Yuting
 *
 */
public class TextFieldUI extends JTextField{
	
	/**
	 * 
	 * @param bound
	 */
	TextFieldUI(Rectangle bound){
		setVisible(true);
		setBounds(bound);
		setOpaque(isOpaque());
	}
	
}
