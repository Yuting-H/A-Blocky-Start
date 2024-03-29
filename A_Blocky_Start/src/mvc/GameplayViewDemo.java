package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GameplayViewDemo implements View {
	
	// Action block UI
	private ArrayList<ActionBlockUI> actionBlockUIList;

	// Gameplay screen panels
	private PanelUI rootPanel;
	private ScrollPaneUI actionChainArea;
	private ScrollPaneUI actionBuffetArea;
	private PanelUI mazeArea;
	private PanelUI iconArea;
	private LayeredPaneUI actionChainContent;
	private PanelUI actionBuffetContent;
	
	// Pause menu panels
	private PanelUI pauseMenuSideArea;
	private ButtonUI pauseMenuDarkArea; // it is used as a panel to disable all buttons layered below it
	
	// Gameplay screen buttons
	private ButtonUI pauseMenuButton;
	private ButtonUI runChainButton;
	private ButtonUI pauseChainButton;
	private ButtonUI resetChainButton;
	private ButtonUI objectivesButton;
	private ButtonUI hintsButton;
	private ButtonUI debugChainButton;
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
	 * Constructor.
	 */
	public GameplayViewDemo() {
		initPanel();
		setRunPauseButtonVisibility(true);
	}
	
	@Override
	public void initPanel() {
		
		// Initialize list of action block UI
		actionBlockUIList = new ArrayList<ActionBlockUI>();
		
		// Initialize action buffet buttons
		addForwardButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addForwardButtonIcon);
		addBackButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addBackButtonIcon);
		addLeftButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addLeftButtonIcon);
		addRightButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addRightButtonIcon);
		addGotoButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addGotoButtonIcon);
		addLoopButton = new ButtonUI(true, IconUI.ACTION_BUTTON_SIZE, null, IconUI.addLoopButtonIcon);
		
		// Initialize icon panel buttons
		pauseMenuButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 0), IconUI.pauseMenuButtonIcon);
		runChainButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 50), IconUI.runChainButtonIcon);
		pauseChainButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 50), IconUI.pauseChainButtonIcon);
		resetChainButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 100), IconUI.resetChainuttonIcon);
		objectivesButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 150), IconUI.objectivesButtonIcon);
		hintsButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 200), IconUI.hintsButtonIcon);
		debugChainButton = new ButtonUI(true, IconUI.ICON_BUTTON_SIZE, new Point(0, 250), IconUI.debugChainButtonIcon);
		
		// Initialize panels
		actionChainContent = new LayeredPaneUI(true, new Dimension(300, 10000), null, Color.GREEN);
		actionChainContent.setLayout(new BoxLayout(actionChainContent, BoxLayout.Y_AXIS));
		
		actionBuffetContent = new PanelUI(true, new Dimension(10000, 150), null, Color.GREEN);
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
		iconArea.add(pauseMenuButton);
		iconArea.add(runChainButton);
		iconArea.add(pauseChainButton);
		iconArea.add(resetChainButton);
		iconArea.add(objectivesButton);
		iconArea.add(hintsButton);
		iconArea.add(debugChainButton);
		pauseMenuSideArea = new PanelUI(false, new Dimension(300, 600), new Point(0, 0), Color.BLUE);
		pauseMenuDarkArea = new ButtonUI(false, IconUI.FRAME_SIZE, new Point(0, 0));
		
		// Panels that get added earlier are on top of later panels
		rootPanel.add(pauseMenuSideArea);
		rootPanel.add(pauseMenuDarkArea);
		rootPanel.add(actionChainArea);
		rootPanel.add(actionBuffetArea);
		rootPanel.add(mazeArea);
		rootPanel.add(iconArea);
		
		// Initialize pause menu buttons
		backButton = new ButtonUI(true, IconUI.BACK_BUTTON_SIZE, new Point(10, 10), IconUI.backButtonIcon);
		saveButton = new ButtonUI(true, IconUI.TEXT_BUTTON_SIZE, new Point(75, 100), IconUI.saveButtonIcon);
		tutorialButton = new ButtonUI(true, IconUI.TEXT_BUTTON_SIZE, new Point(75, 150), IconUI.tutorialButtonIcon);
		settingsButton = new ButtonUI(true, IconUI.TEXT_BUTTON_SIZE, new Point(75, 200), IconUI.settingsButtonIcon);
		mainMenuButton = new ButtonUI(true, IconUI.TEXT_BUTTON_SIZE, new Point(75, 250), IconUI.mainMenuButtonIcon);
		
		pauseMenuSideArea.add(backButton);
		pauseMenuSideArea.add(saveButton);
		pauseMenuSideArea.add(tutorialButton);
		pauseMenuSideArea.add(settingsButton);
		pauseMenuSideArea.add(mainMenuButton);
	}
	
	@Override
	public void refreshPanel() {
		rootPanel.repaint();
		rootPanel.revalidate();
	}
	
	@Override
	public void insertPanelToFrame(JFrame frame) {
		frame.add(rootPanel);
	}
	
	@Override
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	public void setPauseMenuVisibility(boolean visibility) {
		actionChainArea.setVisible(!visibility);
		pauseMenuSideArea.setVisible(visibility);
		pauseMenuDarkArea.setVisible(visibility);
	}
	
	public void setActionBlockUIStatus(int indexPrevious, int indexCurrent, int indexNext) {
		actionBlockUIList.get(indexPrevious).setStatus(0);
		actionBlockUIList.get(indexNext).setStatus(2);
		actionBlockUIList.get(indexCurrent).setStatus(1);
	}
	
	public void setActionBlockUICounter(int index, int counter) {
		actionBlockUIList.get(index).setCounterText(counter);
	}
	
	public void refreshActionChainUI() {
		actionChainArea.repaint();
		actionChainArea.revalidate();
	}
	
	public void clearActionChainUI() {
		actionBlockUIList.clear();
		actionChainContent.removeAll();
	}
	
	public void appendActionBlockUI(int lineNumber, ActionBlockUI blockUI) {
		actionBlockUIList.add(lineNumber, blockUI);
		actionChainContent.add(blockUI, -1);
	}
	
	/**
	 * Choose whether to show the Run Chain or Pause Chain button.
	 * @param showRun 1 = set as Run, 0 = set as Pause
	 */
	public void setRunPauseButtonVisibility(boolean showRun) {
		runChainButton.setEnabled(showRun);
		runChainButton.setVisible(showRun);
		pauseChainButton.setEnabled(!showRun);
		pauseChainButton.setVisible(!showRun);
	}
	
	// Action Listeners - Icon Buttons
	
	public void pauseMenuButton(ActionListener actionListener) {
		pauseMenuButton.addActionListener(actionListener);;
	}
	
	public void runChainButton(ActionListener actionListener) {
		runChainButton.addActionListener(actionListener);
	}
	
	public void pauseChainButton(ActionListener actionListener) {
		pauseChainButton.addActionListener(actionListener);
	}
	
	public void resetChainButton(ActionListener actionListener) {
		resetChainButton.addActionListener(actionListener);
	}
	
	public void objectivesButton(ActionListener actionListener) {
		objectivesButton.addActionListener(actionListener);
	}
	
	public void hintsButton(ActionListener actionListener) {
		hintsButton.addActionListener(actionListener);
	}
	
	public void debugChainButton(ActionListener actionListener) {
		debugChainButton.addActionListener(actionListener);
	}
	
	// Action Listeners - Action Buffet
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
	
	// Action Listeners - Pause Menu
	
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
