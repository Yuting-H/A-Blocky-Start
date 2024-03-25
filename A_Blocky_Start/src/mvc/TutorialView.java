package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 */
public class TutorialView {
	
	private Dimension viewSize = Main.getDimension();
	
	/** Contains all the tutorial prompts*/
	private Dimension tutorialContainerSize = new Dimension(800, 500);
	
	private Dimension backButtonSize = new Dimension(30, 30);
	
	
	private Point containerLocation = new Point(0,50);
	
	private Point backButtonLocation = new Point(10, 10);
	
	
	private JPanel contentContainer = new ContainerUI(containerLocation, tutorialContainerSize, Color.white);
	private ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconUI.backButtonIcon);
	
	private JPanel rootPanel;
	
	/**
	 * 
	 */
	public TutorialView() {
		
		rootPanel = new JPanel();
		
		initPanel();
	}
	
	/**
	 * init UI elements
	 */
	private void initPanel() {
		
		//init rootPanel
		rootPanel.setSize(viewSize);
		rootPanel.setLayout(null);
		rootPanel.setVisible(false);  //hide unwanted occurance
		rootPanel.setBackground(Color.gray);
		
		
		rootPanel.add(backButton);
		rootPanel.add(contentContainer); 
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
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}
	
}
