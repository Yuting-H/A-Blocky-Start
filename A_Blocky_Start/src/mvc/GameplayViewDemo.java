package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GameplayViewDemo {
	
	// Size of various buttons
	private static final Dimension TEXT_BUTTON_SIZE = new Dimension(150, 40);
	private static final Dimension ACTION_BUTTON_SIZE = new Dimension(100, 130);
	private static final Dimension ICON_BUTTON_SIZE = new Dimension(50, 50);
	private static final Dimension BACK_BUTTON_SIZE = new Dimension(30, 30);
	private static final Dimension FRAME_SIZE = new Dimension(800, 600); // TODO

	// Gameplay screen panels
	private PanelUI rootPanel;
	private ScrollPaneUI actionChainArea;
	private ScrollPaneUI actionBuffetArea;
	private PanelUI mazeArea;
	private PanelUI iconArea;
	private PanelUI actionChainContent;
	private PanelUI actionBuffetContent;
	
	// Pause menu panels
	private PanelUI pauseMenuSideArea;
	private ButtonUI pauseMenuDarkArea; // it is used as a panel to disable all buttons layered below it
	
	// Gameplay screen buttons
	private ButtonUI iconPauseMenuButton;
	private ButtonUI iconRunChainButton;
	private ButtonUI iconPauseChainButton;
	private ButtonUI iconResetChainButton;
	private ButtonUI iconObjectivesButton;
	private ButtonUI iconHintsButton;
	private ButtonUI iconTypeChainButton;
	private ButtonUI addForwardButton;
	private ButtonUI addBackButton;
	private ButtonUI addLeftButton;
	private ButtonUI addRightButton;
	private ButtonUI addGotoButton;
	private ButtonUI addLoopButton;
	
	// Pause menu buttons
	private ButtonUI backButton;
	private ButtonUI saveButton;
	private ButtonUI tutorialButton;
	private ButtonUI settingsButton;
	private ButtonUI mainMenuButton;
	
	/**
	 * Construct a gameplay view.
	 */
	public GameplayViewDemo() {
		initPanel();
		setRunPauseChainButton(true);
	}
	
	/**
	 * Help to initialize the root panel and all sub-panels.
	 */
	private void initPanel() {
		
		// Initialize action buffet buttons
		addForwardButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addForwardButtonIcon);
		addBackButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addBackButtonIcon);
		addLeftButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addLeftButtonIcon);
		addRightButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addRightButtonIcon);
		addGotoButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addGotoButtonIcon);
		addLoopButton = new ButtonUI(true, ACTION_BUTTON_SIZE, null, IconUI.addLoopButtonIcon);
		
		// Initialize icon panel buttons
		iconPauseMenuButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 0), IconUI.pauseMenuButtonIcon);
		iconRunChainButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 50), IconUI.runChainButtonIcon);
		iconPauseChainButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 50), IconUI.pauseChainButtonIcon);
		iconResetChainButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 100), IconUI.resetChainuttonIcon);
		iconObjectivesButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 150), IconUI.objectivesButtonIcon);
		iconHintsButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 200), IconUI.hintsButtonIcon);
		iconTypeChainButton = new ButtonUI(true, ICON_BUTTON_SIZE, new Point(0, 250), IconUI.typeChainButtonIcon);
		
		// Initialize panels
		actionChainContent = new PanelUI(true, new Dimension(300, 2000), null, Color.GREEN);
		actionChainContent.setLayout(new BoxLayout(actionChainContent, BoxLayout.Y_AXIS));
		actionChainContent.add(new ActionBlockUI(1, ActionTypeEnum.LOOP, 3, 2, 1));
		
		actionBuffetContent = new PanelUI(true, new Dimension(2000, 150), null, Color.GREEN);
		actionBuffetContent.setLayout(new BoxLayout(actionBuffetContent, BoxLayout.X_AXIS));
		actionBuffetContent.add(addForwardButton);
		actionBuffetContent.add(addBackButton);
		actionBuffetContent.add(addLeftButton);
		actionBuffetContent.add(addRightButton);
		actionBuffetContent.add(addGotoButton);
		actionBuffetContent.add(addLoopButton);
		
		rootPanel = new PanelUI(false, new Dimension(800, 600), new Point(0, 0), Color.WHITE);
		actionChainArea = new ScrollPaneUI(actionChainContent, 1, true, new Dimension(300, 600), new Point(0, 0));
		actionBuffetArea = new ScrollPaneUI(actionBuffetContent, 0, true, new Dimension(500, 150), new Point(300, 450));
		mazeArea = new PanelUI(true, new Dimension(450, 450), new Point(300, 0), Color.YELLOW);
		iconArea = new PanelUI(true, new Dimension(100, 450), new Point(750, 0), Color.GREEN);
		iconArea.add(iconPauseMenuButton);
		iconArea.add(iconRunChainButton);
		iconArea.add(iconPauseChainButton);
		iconArea.add(iconResetChainButton);
		iconArea.add(iconObjectivesButton);
		iconArea.add(iconHintsButton);
		iconArea.add(iconTypeChainButton);
		pauseMenuSideArea = new PanelUI(false, new Dimension(300, 600), new Point(0, 0), Color.BLUE);
		pauseMenuDarkArea = new ButtonUI(false, FRAME_SIZE, new Point(0, 0));
		
		// Panels that get added earlier are on top of later panels
		rootPanel.add(pauseMenuSideArea);
		rootPanel.add(pauseMenuDarkArea);
		rootPanel.add(actionChainArea);
		rootPanel.add(actionBuffetArea);
		rootPanel.add(mazeArea);
		rootPanel.add(iconArea);
		
		// Initialize pause menu buttons
		backButton = new ButtonUI(true, BACK_BUTTON_SIZE, new Point(10, 10), IconUI.backButtonIcon);
		saveButton = new ButtonUI(true, TEXT_BUTTON_SIZE, new Point(75, 100), IconUI.saveButtonIcon);
		tutorialButton = new ButtonUI(true, TEXT_BUTTON_SIZE, new Point(75, 150), IconUI.tutorialButtonIcon);
		settingsButton = new ButtonUI(true, TEXT_BUTTON_SIZE, new Point(75, 200), IconUI.settingsButtonIcon);
		mainMenuButton = new ButtonUI(true, TEXT_BUTTON_SIZE, new Point(75, 250), IconUI.mainMenuButtonIcon);
		
		pauseMenuSideArea.add(backButton);
		pauseMenuSideArea.add(saveButton);
		pauseMenuSideArea.add(tutorialButton);
		pauseMenuSideArea.add(settingsButton);
		pauseMenuSideArea.add(mainMenuButton);
	}
	
	public void insertPanelToFrame(JFrame frame) {
		frame.add(rootPanel);
	}
	
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	public void setPauseMenuVisibility(boolean visibility) {
		actionChainArea.setVisible(!visibility);
		pauseMenuSideArea.setVisible(visibility);
		pauseMenuDarkArea.setVisible(visibility);
	}
	
	/**
	 * Choose whether to show the Run Chain or Pause Chain button.
	 * @param showRun 1 = set as Run, 0 = set as Pause
	 */
	public void setRunPauseChainButton(boolean showRun) {
		iconRunChainButton.setEnabled(showRun);
		iconRunChainButton.setVisible(showRun);
		iconPauseChainButton.setEnabled(!showRun);
		iconPauseChainButton.setVisible(!showRun);
	}
	
	// Icon buttons
	public void iconPauseMenuButton(ActionListener actionListener) {
		iconPauseMenuButton.addActionListener(actionListener);;
	}
	
	public void iconRunChainButton(ActionListener actionListener) {
		iconRunChainButton.addActionListener(actionListener);
	}
	
	public void iconPauseChainButton(ActionListener actionListener) {
		iconPauseChainButton.addActionListener(actionListener);
	}
	
	public void iconResetChainButton(ActionListener actionListener) {
		iconResetChainButton.addActionListener(actionListener);
	}
	
	public void iconObjectivesButton(ActionListener actionListener) {
		iconObjectivesButton.addActionListener(actionListener);
	}
	
	public void iconHintsButton(ActionListener actionListener) {
		iconHintsButton.addActionListener(actionListener);
	}
	
	public void iconTypeChainButton(ActionListener actionListener) {
		iconTypeChainButton.addActionListener(actionListener);
	}
	
	// Action buffet buttons
	public void addForwardButton(ActionListener actionListener) {
		addForwardButton.addActionListener(actionListener);
	}
	
	public void addBackButton(ActionListener actionListener) {
		addBackButton.addActionListener(actionListener);
	}
	
	public void addLeftButton(ActionListener actionListener) {
		addLeftButton.addActionListener(actionListener);
	}
	
	public void addRightButton(ActionListener actionListener) {
		addRightButton.addActionListener(actionListener);
	}
	
	public void addGotoButton(ActionListener actionListener) {
		addGotoButton.addActionListener(actionListener);
	}
	
	public void addLoopButton(ActionListener actionListener) {
		addLoopButton.addActionListener(actionListener);
	}
	
	// Pause menu buttons
	public void backButton(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}
	
	public void saveButton(ActionListener actionListener) {
		saveButton.addActionListener(actionListener);
	}
	
	public void tutorialButton(ActionListener actionListener) {
		tutorialButton.addActionListener(actionListener);
	}
	
	public void settingsButton(ActionListener actionListener) {
		settingsButton.addActionListener(actionListener);
	}
	
	public void mainMenuButton(ActionListener actionListener) {
		mainMenuButton.addActionListener(actionListener);
	}

}
