package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.*;

/**
 * @author Yuting<br>
 * 
 * This is the main menu of the game
 */
public class MainMenuView {
	
	//size of this view
	private Dimension viewSize = new Dimension(800, 600);
	
	//root panel
	private JPanel panel;
	
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
			
	//Buttons declaration
	final ButtonUI continueButton 	= new ButtonUI(ButtonSize, "Continue");
	final ButtonUI newGamButton 	= new ButtonUI(ButtonSize, "New Game");
	final ButtonUI tutorialButton  	= new ButtonUI(ButtonSize, "Tutorial");
	final ButtonUI progressionButton = new ButtonUI(ButtonSize, "Progression");
	final ButtonUI settingsButton	= new ButtonUI(ButtonSize, "Settings");
	final ButtonUI exitButton		= new ButtonUI(ButtonSize, "exit");
	
	/**
	 * Constructor for main menu
	 */
	public MainMenuView() {
		
		//init root panel
		panel = new JPanel();
		
		//create UI components
		this.initPanel();

		Main.gameFrame.add(panel);
	}
	
	/**
	 * create UI components
	 */
	public void initPanel() {
		
		//deleted: switch panel button action, add this back in in in the controller
		
		//set up root panel
		panel.setSize(viewSize);
		panel.setLayout(null);		
		panel.setVisible(false);
		panel.setBackground(Color.gray);
		
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
		buttonContainer.add(settingsButton);
		buttonContainer.add(Box.createVerticalStrut(buttonSpacing));
		buttonContainer.add(exitButton);
		
		
		panel.add(buttonContainer);
		panel.add(asidePanel);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		panel.setVisible(visibility);
	}
	
	/**
	 * inserts root panel to 
	 */
	public void insertPanel() {
		
	}
	
	/**
	 * 
	 */
	public void OnEnter() {
		System.out.println("Entered main menu");
	}

	/**
	 * 
	 */

	public void OnExit() {
	}

}
