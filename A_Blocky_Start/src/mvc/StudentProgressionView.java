package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Yuting
 * This class display the progression
 */
public class StudentProgressionView{
	
	//size of root panel
	private Dimension viewSize = new Dimension(800, 600);
	
	//define size of go-back button 
	private Dimension backButtonSize = new Dimension(30,30);
	
	//define size of each progression box
	private Dimension containerSize = new Dimension(780, 490);
	
	//define location of back button
	private Point backButtonLocation = new Point(10,10);
	
	//define the location of each progression box
	private Point containerLocation = new Point(0, 50);
	
	private JPanel rootPanel;
	
	ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	ContainerUI container = new ContainerUI(containerLocation, containerSize, Color.white);
	
	/**
	 * constructor for displaying
	 */
	public StudentProgressionView(){
		
		rootPanel = new JPanel();
		
		initPanel();
	}
	
	/**
	 * 
	 */
	private void initPanel() {
		
		//set up progression panel
		rootPanel.setSize(viewSize);
		rootPanel.setBackground(Color.BLUE);
		rootPanel.setLayout(null);
		
		//added go back button to prrogression
		backButton.setSize(backButtonSize);
		backButton.setLocation(backButtonLocation);
		rootPanel.add(backButton);
		
		//set up scrollable container
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			
		//Utility: test scroll funciton
		container.add(Box.createVerticalStrut(1000));
		
		//init scroll bar
		JScrollPane scrollPane = new JScrollPane(container);
		
		//change scroll bar settings
		scrollPane.setSize(containerSize);
		scrollPane.setLocation(containerLocation);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		
		//adding scrollable container to progression panel
		rootPanel.add(scrollPane);
		
	}
	
	/**
	 * This method adds a progression record to the screen
	 */
	public void appendProgression() {
		//TODO: implement
	}
	
	/**
	 * 
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

}
