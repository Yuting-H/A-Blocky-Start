package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class GameplayViewDemo {

	private PanelUI rootPanel;
	private PanelUI actionChainPanel;
	private PanelUI actionBuffetPanel;
	private PanelUI mazePanel;
	private PanelUI iconPanel;
	private PanelUI pauseMenuSidePanel;
	private PanelUI pauseMenuDarkPanel;
	
	/**
	 * Construct a gameplay view.
	 */
	public GameplayViewDemo() {
		// Initialize containers
		rootPanel = new PanelUI(null, false, new Dimension(800, 600), new Point(0, 0), new Color(255, 255, 255, 255));
		actionChainPanel = new PanelUI(null, false, new Dimension(300, 600), new Point(0, 0), new Color(255, 0, 0, 255));
		actionBuffetPanel = new PanelUI(null, false, new Dimension(500, 150), new Point(300, 450), new Color(200, 50, 0, 255));
		mazePanel = new PanelUI(null, false, new Dimension(450, 450), new Point(300, 0), new Color(150, 100, 0, 255));
		iconPanel = new PanelUI(null, false, new Dimension(50, 450), new Point(750, 0), new Color(100, 150, 0, 255));
		pauseMenuSidePanel = new PanelUI(null, false, new Dimension(300, 600), new Point(0, 0), new Color(0, 0, 255, 255));
		pauseMenuDarkPanel = new PanelUI(null, false, new Dimension(500, 600), new Point(300, 0), new Color(0, 0, 0, 150));
		
		// Panels that get added earlier are on top of later panels
		rootPanel.add(pauseMenuSidePanel);
		rootPanel.add(pauseMenuDarkPanel);
		rootPanel.add(actionChainPanel);
		rootPanel.add(actionBuffetPanel);
		rootPanel.add(mazePanel);
		rootPanel.add(iconPanel);
	}
	
	public void insertPanelToFrame() {
		GameplayControllerDemo.testFrame.add(rootPanel);
	}
	
	public void setVisibility(boolean visibility) {
		pauseMenuSidePanel.setVisible(!visibility);
		pauseMenuDarkPanel.setVisible(!visibility);
		actionChainPanel.setVisible(visibility);
		actionBuffetPanel.setVisible(visibility);
		mazePanel.setVisible(visibility);
		iconPanel.setVisible(visibility);
		rootPanel.setVisible(visibility);
	}
	
	public void setPauseMenuVisibility(boolean visibility) {
		actionChainPanel.setVisible(!visibility);
		pauseMenuSidePanel.setVisible(visibility);
		pauseMenuDarkPanel.setVisible(visibility);
	}

}
