package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Yuting<br>
 * 
 * This is the main menu of the game
 */
public class MainMenuView {
	
	//size of this view
	private Dimension viewSize = new Dimension(800, 600);
	
	// location of the aside panel
	final Rectangle asidePanelBound = new Rectangle(600, 0, 200, 800);
	
	//location of the button container
	final Rectangle buttonContainerBound = new Rectangle(650, 200 , 100, 200);
	
	/** The size of Main menu buttons*/ 
	final Dimension ButtonSize = new Dimension(100, 20); 	
	
	/** panel for visual effect*/
	ContainerUI asidePanel 	= new ContainerUI(asidePanelBound, Color.white);
			
	/** Contains all the buttons*/
	ContainerUI buttonContainer = new ContainerUI(buttonContainerBound, Color.magenta);
	
	/** Amount of vertical space between each button*/
	final int buttonSpacing = 5;
	
	//root panel
	private JPanel rootPanel;
			
	//Buttons declaration
	private ButtonUI continueButton 	= new ButtonUI(ButtonSize, "Continue", IconsUI.buttonIcon);
	private ButtonUI newGamButton 	= new ButtonUI(ButtonSize, "New Game", IconsUI.buttonIcon);
	private ButtonUI tutorialButton  	= new ButtonUI(ButtonSize, "Tutorial", IconsUI.buttonIcon);
	private ButtonUI progressionButton = new ButtonUI(ButtonSize, "Progression", IconsUI.buttonIcon);
	private ButtonUI highScoreButton = new ButtonUI(ButtonSize, "High Score", IconsUI.buttonIcon);
	private ButtonUI settingsButton	= new ButtonUI(ButtonSize, "Settings", IconsUI.buttonIcon);
	private ButtonUI exitButton		= new ButtonUI(ButtonSize, "exit", IconsUI.buttonIcon);
	
	/**
	 * Constructor for main menu
	 */
	public MainMenuView() {
		
		//init root panel
		rootPanel = new JPanel();
		
		//create UI components
		this.initPanel();
	}
	
	/**
	 * create UI components
	 */
	private void initPanel() {
		
		//deleted: switch panel button action, add this back in in in the controller
		
		//set up root panel
		rootPanel.setSize(viewSize);
		rootPanel.setLayout(null);	
		rootPanel.setVisible(false);
		rootPanel.setBackground(Color.gray);
		
		//populate button container
		buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
		buttonContainer.add(continueButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(newGamButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(tutorialButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(progressionButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(highScoreButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(settingsButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(exitButton);
			
		rootPanel.add(buttonContainer);
		rootPanel.add(asidePanel);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
		buttonContainer.setVisible(visibility);
	}
	
	public void continueButtonAddActionListener(ActionListener actionListener) {
		continueButton.addActionListener(actionListener);
	}
	
	public void newGameButtonAddActionListener(ActionListener actionListener) {
		newGamButton.addActionListener(actionListener);
	}
	
	public void tutorialButtonAddActionListener(ActionListener actionListener) {
		tutorialButton.addActionListener(actionListener);
	}
	
	public void progressionButtonAddActionListener(ActionListener actionListener) {
		progressionButton.addActionListener(actionListener);
	}
	
	public void highscoreButtonAddActionListener(ActionListener actionListener) {
		highScoreButton.addActionListener(actionListener);
	}
	
	public void settingsButtonAddActionListener(ActionListener actionListener) {
		settingsButton.addActionListener(actionListener);
	}
	
	public void exitButtonAddActionListener(ActionListener actionListener) {
		exitButton.addActionListener(actionListener);
	}
	
	/**
	 * Insert the root panel to gameFrame
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}

}
