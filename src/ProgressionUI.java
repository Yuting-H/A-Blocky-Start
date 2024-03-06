import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class ProgressionUI extends PanelUI implements OnEnter{
	
	
	ProgressionUI(Rectangle bound){
		
		super(bound);
		this.setBackground(Color.BLUE);	
	}
	
	
	public void OnEnter() {
		System.out.println("Entered Progression Screen");
	}

}
