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
public class MainMenuView extends PanelUI implements Controller{
	

	
	/**
	 * Constructor for main menu
	 * @param bound the bound of the main menu
	 */
	MainMenuView(Dimension size) {
		
		//sets up panel 
		super(size);
		
		//init locations and sizes of the components
		
		// location of the aside panel
		final Rectangle asidePanelBound = new Rectangle(600, 0, 200, 800);
		final Rectangle buttonContainerBound = new Rectangle(650, 200 , 100, 200);
		
		/** The size of Main menu buttons*/ 
		final Dimension ButtonSize = new Dimension(100, 20); 	
		
		/** panel for visual effect*/
		ContainerUI asidePanel 	= new ContainerUI(asidePanelBound, Color.white);
		
		/** Contains all the buttons*/
		ContainerUI buttonContainer = new ContainerUI(buttonContainerBound, Color.magenta);
		
		/** Amount of vertical space between each button*/
		final int buttonSpacing = 5;
		
		//Buttons
		final ButtonUI continueButton 	= new ButtonUI(ButtonSize, "Continue");
		final ButtonUI newGamButton 		= new ButtonUI(ButtonSize, "New Game");
		final ButtonUI tutorialButton  	= new ButtonUI(ButtonSize, "Tutorial");
		final ButtonUI progressionButton 	= new ButtonUI(ButtonSize, "Progression");
		final ButtonUI settingsButton		= new ButtonUI(ButtonSize, "Settings");
		final ButtonUI exitButton			= new ButtonUI(ButtonSize, "exit");
		
		newGamButton.addActionListener(e -> FunctionsUI.switchPanels(InitGame.mainMenu, InitGame.progression));
		
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
		
		
		add(buttonContainer);
		//add(asidePanel);
		
	}
	
	/**
	 * 
	 */
	public void OnEnter() {
		System.out.println("Entered main menu");
	}

}
