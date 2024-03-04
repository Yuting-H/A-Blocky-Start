import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class Progression extends Panel implements OnEnter{
	
	
	Progression(Rectangle bound){
		
		super(bound);
		this.setBackground(Color.BLUE);	
	}
	
	
	public void OnEnter() {
		System.out.println("Entered Progression Screen");
	}

}
