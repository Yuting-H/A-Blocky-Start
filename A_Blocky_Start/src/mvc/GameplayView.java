package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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
	private Dimension actionBuffetContainerSize = new Dimension(600, 200);
	private Dimension pauseMenuSize = new Dimension(200, 600);
	private Dimension opaqueSize = new Dimension(600, 600);
	private Dimension actionSize = new Dimension(150, 40);
	private Dimension actionBuffetItemSize = new Dimension(100, 100);
	
	//location of UI elements
	private Point actionchainContainerLocation = new Point(0,0);
	private Point actionBuffetContainerLocation = new Point(200, 400);
	private Point pauseMenuLocation = new Point(0,0);
	private Point OpaqueLocation = new Point(200, 0);
	
	private JPanel rootPanel;
	
	private ContainerUI actionchainContainer = new ContainerUI(actionchainContainerLocation, actionchainContainerSize, Color.red);
	
	private ContainerUI actionBuffetContainer = new ContainerUI(actionBuffetContainerLocation, actionBuffetContainerSize, Color.cyan);
	
	private ContainerUI pauseMenu = new ContainerUI(pauseMenuLocation, pauseMenuSize, Color.GREEN);
	
	private ContainerUI opaque = new ContainerUI(OpaqueLocation, opaqueSize, new Color(100,100,100, 200));
	
	private ArrayList<ButtonUI> actionChainList = new ArrayList<ButtonUI>();
	
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
		
		//actionChainContainer
		actionchainContainer.setLayout(new FlowLayout());
		actionchainContainer.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		
		//actionBuffetContainer
		actionBuffetContainer.setLayout(new FlowLayout());
		
		rootPanel.add(opaque);
		rootPanel.add(pauseMenu);
		
		hidePauseMenu();
		rootPanel.add(actionchainContainer);
		rootPanel.add(actionBuffetContainer);
		
		testAction();
		
	}
	
	/**
	 * 
	 */
	private void testAction() {
		
		//if you see grey box something gone wrong
		actionchainContainer.add(new PanelUI(actionSize));
		actionchainContainer.add(Box.createVerticalStrut(10));
		
	
		
		actionChainList.add(new ButtonUI(actionSize, "1"));
		actionChainList.add(new ButtonUI(actionSize, "2"));
		actionChainList.add(new ButtonUI(actionSize, "3"));
		actionChainList.add(new ButtonUI(actionSize, "4"));
		refreshActionChain();
	}
	
	/**
	 * 
	 */
	public void refreshActionChain() {
		
		actionchainContainer.removeAll();
		for (int i = 0; i < actionChainList.size(); i++) {
			actionchainContainer.add(actionChainList.get(i));
		}
	}
	
	/**
	 * 
	 */
	public void addAction() {
		
	}
	
	
	/**
	 * displays the pause menu
	 */
	public void showPauseMenu() {
		pauseMenu.setVisible(true);
		opaque.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void hidePauseMenu() {
		pauseMenu.setVisible(false);
		opaque.setVisible(false);
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
