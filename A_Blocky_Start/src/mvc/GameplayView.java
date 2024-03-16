package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * This view class displays the action chain and maze on screen.
 * @version March 11, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 * @author Yuting
 */
public class GameplayView {
	
	//sizes of UI elements
	private Dimension viewSize = new Dimension(800, 600);
	private Dimension actionchainContainerSize = new Dimension(200, 600);
	private Dimension actionchainBuffetContainerSize = new Dimension(600, 200);
	
	//location of UI elements
	private Point actionchainContainerLocation = new Point(0,0);
	private Point actionchainBuffetContainerLocation = new Point(200, 400);
	
	private JPanel rootPanel;
	
	private ContainerUI actionchainContainer = new ContainerUI(actionchainContainerLocation, actionchainContainerSize, Color.red);
	
	private ContainerUI actionchainBuffetContainer = new ContainerUI(actionchainBuffetContainerLocation, actionchainBuffetContainerSize, Color.cyan);
	
	/**
	 * 
	 */
	public GameplayView() {
		rootPanel = new JPanel();
		
		initPanel();
	}
	
	/**
	 * 
	 */
	private void initPanel() {
		
		//init root panel
		rootPanel.setSize(viewSize);
		rootPanel.setLayout(null);
		rootPanel.setVisible(false);
		
		
		rootPanel.add(actionchainContainer);
		rootPanel.add(actionchainBuffetContainer);
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
