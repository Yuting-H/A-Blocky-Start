package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * 
 */
public class TutorialView {
	
	private Dimension viewSize = new Dimension(800, 600);
	
	/** C*/
	private Dimension tutorialContainerSize = new Dimension(800, 200);
	
	
	private Point containerLocation = new Point(0,100);
	
	
	private JPanel contentContainer = new ContainerUI(containerLocation, tutorialContainerSize, Color.white);
	
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
		rootPanel.setVisible(false);
		rootPanel.setBackground(Color.darkGray);
		
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
	
}
