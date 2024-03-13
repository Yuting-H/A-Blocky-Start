package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Yuting
 * This class display the progression
 */
public class StudentProgressionView extends PanelUI implements Controller{
	
	//define size of go-back button 
	Dimension backButtonSize = new Dimension(30,30);
	
	//define size of each progression box
	Dimension containerSize = new Dimension(700, 500);
	
	//define location of back button
	Point backButtonLocation = new Point(10,10);
	
	//define the location of each progression box
	Point containerLocation = new Point(50, 50);
	
	ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	ContainerUI container = new ContainerUI(containerLocation, containerSize, Color.white);
	
	/**
	 * constructor for displaying=
	 */
	StudentProgressionView(Dimension size){
	
		//set up progression panel
		super(size);
		this.setBackground(Color.BLUE);
		
		//added go back button to prrogression
		add(backButton);
		
		//set up scrollable container
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			
		//Utility: test scroll funciton
		container.add(Box.createVerticalStrut(5000));
		
		//init scroll bar
		JScrollPane scrollPane = new JScrollPane(container);
		
		//change scroll bar settings
		scrollPane.setSize(containerSize);
		scrollPane.setLocation(containerLocation);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		
		//adding scrollable container to progression panel
		add(scrollPane);
		
	}
	
	/**
	 * This method adds a progression record to the screen
	 */
	public void appendProgression() {
		//TODO: implement
	}
	
	
	public void OnEnter() {
		System.out.println("Entered Progression Screen");
	}

	/**
	 * 
	 */
	@Override
	public void OnExit() {
	}

}
