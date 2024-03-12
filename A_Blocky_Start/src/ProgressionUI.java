import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Yuting
 * This class display the progression
 */
public class ProgressionUI extends PanelUI implements OnEnter{
	
	//define size of go-back button 
	Dimension backButtonSize = new Dimension(30,30);
	
	//TODO: define size of each progression box
	Dimension boxSize = new Dimension();
	
	//define location of back button
	Point backButtonLocation = new Point(10,10);
	
	ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	/**
	 * constructor for displaying=
	 */
	ProgressionUI(Rectangle bound){
	
		
		super(bound);
		this.setBackground(Color.BLUE);	
		
		add(backButton);
		
	}
	
	/**
	 * This method adds a progression record to the screen
	 */
	public void appendProgression() {
		
	}
	
	
	public void OnEnter() {
		System.out.println("Entered Progression Screen");
	}

}
