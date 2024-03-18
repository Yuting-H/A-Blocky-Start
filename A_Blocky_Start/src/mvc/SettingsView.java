package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 */
public class SettingsView {
	
	private Dimension viewSize = new Dimension(800, 600);
	
	//define size of go-back button 
	private Dimension backButtonSize = new Dimension(30,30);
	
	//define location of back button
	private Point backButtonLocation = new Point(10,10);
	
	private JPanel rootPanel;
	
	private ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	/**
	 * 
	 */
	public SettingsView() {
		
		rootPanel = new JPanel();
		
		initPanel();
	}

	/**
	 * 
	 */
	private void initPanel() {
		
		//set up root panel
		rootPanel.setSize(viewSize);
		rootPanel.setLayout(null);
		rootPanel.setVisible(false);
		rootPanel.setBackground(Color.gray);
		
		rootPanel.add(backButton);
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
	
	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

}
