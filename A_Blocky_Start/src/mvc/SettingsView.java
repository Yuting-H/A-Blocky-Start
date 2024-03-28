package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * @author Yuting
 * @author Simon
 */
public class SettingsView {
	
	private Dimension viewSize = new Dimension(800, 600);
	
	//define sizes
	private Dimension backButtonSize = new Dimension(30,30);
	private Dimension labelSize = new Dimension(120,20);
	private Dimension comboBoxSize = new Dimension(130,30);
	
	//define locations
	private Point backButtonLocation = new Point(10,10);
	private Point colourBlindComboBoxLocation = new Point(450, 100);
	private Point colourBlindLabelLocation = new Point(300,100);
	private Point resolutionComboBoxLocation = new Point(450,200);
	private Point resolutionLabelLocation = new Point(300,200);
	private Point volumeLevelSliderLocation = new Point(450,300);
	private Point volumeLevelLabelLocation = new Point(300,300);
	
	private JPanel rootPanel;
	
	private ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconUI.backButtonIcon);
	
	private JLabel colourBlindLabel = new LabelUI(colourBlindLabelLocation, labelSize, "Colourblind mode:");
	
	private JLabel resolutionLabel = new LabelUI(resolutionLabelLocation, labelSize, "Resolution:");
	
	private JLabel volumeLevelLabel = new LabelUI(volumeLevelLabelLocation, labelSize, "Volume Level:");
	
	//colourblind selection 
	private String[] colourblindComboboxOptions = {"Off", "On"};
	private JComboBox<String> colourBlindComboBox = new JComboBox<String>(colourblindComboboxOptions);
	
	//resolution selection
	private String[] resolutionComboboxOptions = {"800 x 600"};
	private JComboBox<String> resolutionComboBox = new JComboBox<String>(resolutionComboboxOptions);
	
	private JSlider volumeLevelSlider = new JSlider(0, 100, 0);
	
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
		rootPanel.setBackground(Color.lightGray);
		
		//add colourblind mode selection combobox
		colourBlindComboBox.setVisible(true);
		colourBlindComboBox.setSize(comboBoxSize);
		colourBlindComboBox.setLocation(colourBlindComboBoxLocation);
		rootPanel.add(colourBlindComboBox);
		
		//add resolution selection combobox
		resolutionComboBox.setVisible(true);
		resolutionComboBox.setSize(comboBoxSize);
		resolutionComboBox.setLocation(resolutionComboBoxLocation);
		rootPanel.add(resolutionComboBox);
		
		volumeLevelSlider.setVisible(true);
		volumeLevelSlider.setSize(comboBoxSize);
		volumeLevelSlider.setLocation(volumeLevelSliderLocation);
		volumeLevelSlider.setPaintTicks(true);
		volumeLevelSlider.setMinorTickSpacing(25);
		volumeLevelSlider.setMajorTickSpacing(50);
		volumeLevelSlider.setMinorTickSpacing(75);
		rootPanel.add(volumeLevelSlider);
		
		
		//colourblind combobox label
		rootPanel.add(colourBlindLabel);
		
		//resolution combobox label
		rootPanel.add(resolutionLabel);
		
		rootPanel.add(volumeLevelLabel);
		
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
	 * @return the selected option in colourblind combobox
	 */
	public String getColourBlindSetting() {
		return (String) colourBlindComboBox.getSelectedItem();
	}
	
	/**
	 * 
	 * @return the selected option in color blind combobox
	 */
	public String getResolutionSetting() {
		return (String) resolutionComboBox.getSelectedItem();
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
