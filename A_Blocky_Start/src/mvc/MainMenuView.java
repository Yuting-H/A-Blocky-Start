package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Yuting<br>
 * 
 * This is the main menu of the game
 */
public class MainMenuView {
	
	//size of this view
	private Dimension viewSize = Main.getDimension();
	
	// location of the aside panel
	final Rectangle asidePanelBound = new Rectangle(600, 0, 200, 800);
	
	//location of the button container
	final Rectangle buttonContainerBound = new Rectangle(650, 200 , 100, 200);
	
	/** The size of Main menu buttons*/ 
	final Dimension ButtonSize = new Dimension(150, 40); 	
	
	/** panel for visual effect*/
	ContainerUI asidePanel 	= new ContainerUI(asidePanelBound, Color.white);
			
	
	/** Amount of vertical space between each button*/
	final int buttonSpacing = 5;
	
	//root panel
	private JPanel rootPanel;
	
	//game title
	private JLabel title = new JLabel(IconUI.gameTitleIcon);
	
			
	//Buttons declaration
	private ButtonUI continueButton 	= new ButtonUI(ButtonSize, "", IconUI.continueButtonIcon);
	private ButtonUI newGamButton 	= new ButtonUI(ButtonSize, "", IconUI.newGameButtonIcon);
	private ButtonUI tutorialButton  	= new ButtonUI(ButtonSize, "", IconUI.tutorialButtonIcon);
	private ButtonUI progressionButton = new ButtonUI(ButtonSize, "", IconUI.progressionButtonIcon);
	private ButtonUI highScoreButton = new ButtonUI(ButtonSize, "", IconUI.highscoreButtonIcon);
	private ButtonUI settingsButton	= new ButtonUI(ButtonSize, "", IconUI.settingsButtonIcon);
	private ButtonUI exitButton		= new ButtonUI(ButtonSize, "", IconUI.exitButtonIcon);
	
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
		
		title.setSize(viewSize);
		title.setLocation(-100, -200); 
		
		rootPanel.add(title);
		
		//populate buttons
		asidePanel.setLayout(new FlowLayout());
		asidePanel.setBorder(new EmptyBorder(new Insets(100, 10, 10, 10)));  //Space buttons from border
		asidePanel.add(continueButton);
		asidePanel.add(newGamButton);
		asidePanel.add(tutorialButton);
		asidePanel.add(progressionButton);
		asidePanel.add(highScoreButton);
		asidePanel.add(settingsButton);
		asidePanel.add(exitButton);
		
		rootPanel.add(asidePanel);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
		asidePanel.setVisible(visibility);
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
