package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComponent;
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
	private Dimension backButtonSize = new Dimension(30, 30);
	
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
	
	//buffet items buttons
	private ButtonUI forwardButton = new ButtonUI(actionBuffetItemSize, "forward");
	private ButtonUI backwardButton = new ButtonUI(actionBuffetItemSize, "backward");
	private ButtonUI leftButton = new ButtonUI(actionBuffetItemSize, "left");
	private ButtonUI rightButton = new ButtonUI(actionBuffetItemSize, "right");
	
	private ArrayList<String> actionChainList = new ArrayList<String>();
	
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
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		actionBuffetContainer.setLayout(layout);
		actionBuffetContainer.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		
		//adding buttons to buffet
		actionBuffetContainer.add(forwardButton);
		actionBuffetContainer.add(backwardButton);
		actionBuffetContainer.add(leftButton);
		actionBuffetContainer.add(rightButton);
		
		//adding pause menu
		rootPanel.add(opaque);
		rootPanel.add(pauseMenu);
		
		hidePauseMenu();
		rootPanel.add(actionchainContainer);
		rootPanel.add(actionBuffetContainer);
		
		testAction();
		
	}
	
	/**
	 * testing method
	 */
	private void testAction() {
		
		newActionUI("something");
		newActionUI("something else");
		
		refreshActionChain();
	}
	
	/**
	 * Method stub for adding a action UI element 
	 */
	public void appendAction() {
		
	}
	
	public void removeAction(String string) {
		for (int i = 0; i < actionChainList.size(); i++) {
			
		}
	}
	
	/**
	 * Creates a new action UI element (created as a button)
	 */
	public ButtonUI newActionUI(String text) {
		
		//create a new Button representing an action
		ButtonUI action = new ButtonUI(actionSize, text);
	
		actionChainList.add(text);
		
		//Deletes itself when the action is clicked
		action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//removes this button 
				actionChainList.remove(text);
				
				refreshActionChain();			
			}
		});
		return action;
		
	}
	
	/**
	 * update the action chain UI according to action chain list
	 */
	public void refreshActionChain() {
		
		int size = actionChainList.size();
		
		//removes all UI from container
		actionchainContainer.removeAll();
		
		//update graphics
		actionchainContainer.repaint();
		
		actionchainContainer.setLayout(new FlowLayout());
		
		//adding back UI elements from list
		for (int i = 0; i < size; i++) {
			actionchainContainer.add(newActionUI(""));
			
		}
		
		actionchainContainer.repaint();

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
	
	
	
	public void forwardButtonAddActionListener(ActionListener actionListener) {
		forwardButton.addActionListener(actionListener);
	}
	
	public void backwardButtonAddActionListener(ActionListener actionListener) {
		backwardButton.addActionListener(actionListener);
	}
	
	public void leftButtonAddActionListener(ActionListener actionListener) {
		leftButton.addActionListener(actionListener);
	}
	
	public void rightButtonAddActionListener(ActionListener actionListener) {
		rightButton.addActionListener(actionListener);
	}

}
