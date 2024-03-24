package mvc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * This view class displays the action chain and maze on screen.
 * @version March 11, 2024
 * @since March 11, 2024
 * @author Chun Ho Chan (Edward)
 * @author Yuting
 * 
 * KNOWN BUG: removing action block X removes the first occurance of an action block Y if
 * X has the same text as Y
 */
public class GameplayView {
	
	//sizes of UI elements
	//Containers
	private Dimension viewSize 					= new Dimension(800, 600);
	private Dimension actionchainContainerSize 	= new Dimension(200, 600);
	private Dimension actionBuffetContainerSize = new Dimension(600, 200);
	private Dimension mazeSize 					= new Dimension(600, 400);
	
	//pause menu
	private Dimension pauseMenuSize				= new Dimension(200, 600);
	private Dimension opaqueSize 				= new Dimension(600, 600);
	private Dimension pauseButtonSize 			= new Dimension(30, 30);  //button that shows pause menu
	private Dimension pauseMenuButtonSize 		= new Dimension(150, 40);  //buttons inside the pause menu
	
	//action chain
	private Dimension actionSize				= new Dimension(150, 40);
	private Dimension actionBuffetItemSize 		= new Dimension(100, 100);
	
	//location of UI elements
	private Point actionchainContainerLocation 	= new Point(0,0);
	private Point actionBuffetContainerLocation = new Point(200, 400);
	private Point mazeLocation 					= new Point(200, 0);
	private Point pauseMenuLocation				= new Point(0,0);
	private Point OpaqueLocation 				= new Point(200, 0);
	private Point pauseButtonLocation 			= new Point(750, 10);
	
	//root panel
	private JPanel rootPanel;
	
	private ContainerUI actionchainContainer = new ContainerUI(actionchainContainerLocation, actionchainContainerSize, Color.red);
	
	private ContainerUI actionBuffetContainer = new ContainerUI(actionBuffetContainerLocation, actionBuffetContainerSize, Color.cyan);
	
	private ContainerUI maze = new ContainerUI(mazeLocation, mazeSize, Color.lightGray);
	
	private ContainerUI pauseMenu = new ContainerUI(pauseMenuLocation, pauseMenuSize, Color.GREEN);
	
	private ContainerUI opaque = new ContainerUI(OpaqueLocation, opaqueSize, new Color(100,100,100, 200));
	
	
	//pause button
	private ButtonUI pauseButton = new ButtonUI(pauseButtonLocation, pauseButtonSize, "", IconsUI.buttonIcon);
	
	//pauseMenu buttons
	private ButtonUI resumeButton = new ButtonUI(pauseMenuButtonSize, "Resume");
	private ButtonUI saveButton = new ButtonUI(pauseMenuButtonSize, "Save");
	private ButtonUI exitButton = new ButtonUI(pauseMenuButtonSize, "Exit");
	
	//buffet items buttons
	private ButtonUI forwardButton = new ButtonUI(actionBuffetItemSize, "forward");
	private ButtonUI backwardButton = new ButtonUI(actionBuffetItemSize, "backward");
	private ButtonUI leftButton = new ButtonUI(actionBuffetItemSize, "left");
	private ButtonUI rightButton = new ButtonUI(actionBuffetItemSize, "right");

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
		
		//pauseButton
		rootPanel.add(pauseButton);
		
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
		pauseMenu.setBorder(new EmptyBorder(new Insets(100, 10, 10, 10))); //top, left, bottom, right
		pauseMenu.setLayout(new FlowLayout());
		pauseMenu.add(resumeButton);
		pauseMenu.add(saveButton);
		pauseMenu.add(exitButton);
		rootPanel.add(opaque);
		rootPanel.add(pauseMenu);
		
		
		hidePauseMenu();
		rootPanel.add(actionchainContainer);
		rootPanel.add(actionBuffetContainer);
		
		//adding maze
		rootPanel.add(maze);
		
	}
	
	/**
	 * Adds an action block UI element to the action chain
	 * @param text
	 */
	public void addAction(String text) {
		actionchainContainer.add(newActionUI(text));
		
		actionchainContainer.repaint();
		actionchainContainer.revalidate();

	}
	
	/**
	 * Creates a new action UI element (created as a button)
	 * add its associated string to list
	 */
	public ButtonUI newActionUI(String text) {
		
		//create a new Button representing an action
		ButtonUI action = new ButtonUI(actionSize, text);
		
		action.setName(text);
		
		//Deletes itself when the action is clicked
		action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//removes 
				actionchainContainer.remove(action);
				actionchainContainer.repaint();
				actionchainContainer.revalidate();		
			}
		});
		
		return action;
		
	}
	
	/**
	 * update the action chain UI according to action chain list
	 */
	public void refreshActionChain() {
		

		
		actionchainContainer.repaint();
		actionchainContainer.revalidate();

	}
	
	
	/**
	 * displays the pause menu
	 */
	public void showPauseMenu() {
		pauseMenu.setVisible(true);
		opaque.setVisible(true);
		actionchainContainer.setVisible(false);
	}
	
	/**
	 * 
	 */
	public void hidePauseMenu() {
		pauseMenu.setVisible(false);
		opaque.setVisible(false);
		actionchainContainer.setVisible(true);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	/**
	 * Inserts root panel to game frame
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void resumeButtonAddActionListener(ActionListener actionListener) {
		resumeButton.addActionListener(actionListener);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void saveButtonAddActionListener(ActionListener actionListener) {
		saveButton.addActionListener(actionListener);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void exitButtonAddActionListener(ActionListener actionListener) {
		exitButton.addActionListener(actionListener);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void pauseButtonAddActionListener(ActionListener actionListener) {
		pauseButton.addActionListener(actionListener);
	}
	
	/**
	 * Adds functionality to forward button
	 * @param actionListener
	 */
	public void forwardButtonAddActionListener(ActionListener actionListener) {
		forwardButton.addActionListener(actionListener);
	}
	
	/**
	 * Adds functionality to backward button
	 * @param actionListener
	 */
	public void backwardButtonAddActionListener(ActionListener actionListener) {
		backwardButton.addActionListener(actionListener);
	}
	
	/**
	 * Adds functionality to left button
	 * @param actionListener
	 */
	public void leftButtonAddActionListener(ActionListener actionListener) {
		leftButton.addActionListener(actionListener);
	}
	
	/**
	 * Adds functionality to right button
	 * @param actionListener
	 */
	public void rightButtonAddActionListener(ActionListener actionListener) {
		rightButton.addActionListener(actionListener);
	}

}
