package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class SettingsView {
	
	private Dimension viewSize = new Dimension(800, 600);
	
	//define sizes
	private Dimension backButtonSize = new Dimension(30,30);
	private Dimension labelSize = new Dimension(100,20);
	private Dimension comboBoxSize = new Dimension(50, 30);
	
	//define locations
	private Point backButtonLocation = new Point(10,10);
	private Point colorBlindComboBoxLocation = new Point(450, 100);
	private Point colorBlindLabelLocation = new Point(300,100);
	
	private JPanel rootPanel;
	
	private ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconUI.backButtonIcon);
	
	private JLabel colorBlindLabel = new LabelUI(colorBlindLabelLocation, labelSize, "Colorblind mode:");
	
	//colorblind selection 
	private String[] comboboxOptions = {"On", "Off"};
	private JComboBox<String> colorBlindComboBox = new JComboBox<String>(comboboxOptions);
	
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
		
		//add colourblind mode selection combobox
		colorBlindComboBox.setVisible(true);
		colorBlindComboBox.setSize(comboBoxSize);
		colorBlindComboBox.setLocation(colorBlindComboBoxLocation);
		rootPanel.add(colorBlindComboBox);
		
		//colorblind combobox label
		rootPanel.add(colorBlindLabel);
		
		//back button
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
	 * @return the selected option in color blind combobox
	 */
	public String getColorBlindSetting() {
		return (String) colorBlindComboBox.getSelectedItem();
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
