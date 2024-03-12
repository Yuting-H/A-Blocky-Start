package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Yuting
 * This class display the progression
 */
public class ProgressionUI extends PanelUI implements OnEnter{
	
	//define size of go-back button 
	Dimension backButtonSize = new Dimension(30,30);
	
	//define size of each progression box
	Dimension containerSize = new Dimension(700, 500);
	
	//define location of back button
	Point backButtonLocation = new Point(10,10);
	
	//define the location of each progression box
	Point containerLocation = new Point(50, 50);
	
	ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	ContainerUI container = new ContainerUI(containerLocation, containerSize, Color.black);
	
	/**
	 * constructor for displaying=
	 */
	ProgressionUI(Rectangle bound){
	
		
		super(bound);
		this.setBackground(Color.BLUE);	
		add(backButton);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(Box.createVerticalStrut(5000));
		
		JScrollPane scrollPane = new JScrollPane(container);
		
		scrollPane.setSize(containerSize);
		scrollPane.setLocation(containerLocation);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		add(scrollPane);
		
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
