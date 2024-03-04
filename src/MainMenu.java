import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Yuting
 * @
 * This is the main menu of the game
 */
public class MainMenu extends Panel implements OnEnter{
	
	//init locations and sizes of the components
	
	/** The panel to the right side of the main menu
	 * 	Contains new game button, tutorial buttons etc
	 */
	final Rectangle asidePanelBound 	= new Rectangle(600, 0, 200, 800);
	
	final Rectangle continueButtonBound = new Rectangle(50, 200, 100, 20);
	final Rectangle newGameButtonBound 	= new Rectangle(50, 230, 100, 20);
	final Rectangle tutorialButtonBound = new Rectangle(50, 260, 100, 20);
	final Rectangle settingsButtonBound = new Rectangle(50, 290, 100, 20);
	final Rectangle exitButtonBound 	= new Rectangle(50, 320, 100, 20);
	
	//init components
	Button continueButton 	= new Button("Continue", continueButtonBound);
	Button newGameButton 	= new Button("New Game", newGameButtonBound);
	Button tutorialButton	= new Button("Tutorial", tutorialButtonBound);
	Button settingsButton	= new Button("Settings", settingsButtonBound);
	Button exitButton		= new Button("Exit", exitButtonBound);
	Container asidePanel 	= new Container(asidePanelBound, Color.white);
	
	
	
	/**
	 * Constructor 
	 * @param rect
	 */
	MainMenu(Rectangle bound) {
		
		super(bound);

		newGameButton.addActionListener(e -> Functions.switchPanels(GameFrame.mainMenu, GameFrame.progression));
		

		asidePanel.add(continueButton);
		asidePanel.add(newGameButton);
		asidePanel.add(tutorialButton);
		asidePanel.add(settingsButton);
		asidePanel.add(exitButton);
		add(asidePanel);
		
	}
	
	/**
	 * 
	 */
	public void OnEnter() {
		System.out.println("Entered main menu");
	}

}
