package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class HighScoreView{

	//Sizes
	private Dimension viewSize = new Dimension(800, 600);
	private Dimension backButtonSize = new Dimension(30, 30); 
	private Dimension entriesContainerSize = new Dimension(600, 500);
	private Dimension entriesSize = new Dimension(600, 50);
	private Dimension entriesLabelSize = new Dimension(100, 20);
	
	//spacing between high score entries
	private int margin = 20; 
	
	//locations
	private Point backButtonLocation = new Point(10, 10);
	private Point entriesContainerLocation = new Point(100, 0);
	
	//panel containing all UI elements
	private JPanel rootPanel;
	
	//button
	private ButtonUI backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
	
	//container for entries
	private ContainerUI entriesContainer = new ContainerUI(entriesContainerLocation, entriesContainerSize, Color.LIGHT_GRAY);
	
	//entries panels
	private PanelUI entry1 = new PanelUI(entriesSize);
	private PanelUI entry2 = new PanelUI(entriesSize);
	private PanelUI entry3 = new PanelUI(entriesSize);
	private PanelUI entry4 = new PanelUI(entriesSize);
	private PanelUI entry5 = new PanelUI(entriesSize);
	
	//player names
	private LabelUI name1 = new LabelUI(entriesLabelSize, "John Doe");
	private LabelUI name2 = new LabelUI(entriesLabelSize, "A");
	private LabelUI name3 = new LabelUI(entriesLabelSize, "B");
	private LabelUI name4 = new LabelUI(entriesLabelSize, "C");
	private LabelUI name5 = new LabelUI(entriesLabelSize, "D");
	
	//player's scores
	private LabelUI score1 = new LabelUI(entriesLabelSize, "123");
	private LabelUI score2 = new LabelUI(entriesLabelSize, "23");
	private LabelUI score3 = new LabelUI(entriesLabelSize, "1");
	private LabelUI score4 = new LabelUI(entriesLabelSize, "1");
	private LabelUI score5 = new LabelUI(entriesLabelSize, "1");

	/**
	 * Constructor
	 */
	public HighScoreView() {
		
		rootPanel = new JPanel();
		
		initPanel();
	}
	
	/**
	 * initialze root panel
	 */
	private void initPanel() {
		
		//set up root panel
		rootPanel.setSize(viewSize);
		rootPanel.setLayout(null);
		rootPanel.setLayout(null);
		rootPanel.setVisible(false);
		
		//buttons
		rootPanel.add(backButton);
		
		//set up grid with 5 rows and 1 column
		GridLayout layout = new GridLayout(5, 1);
		layout.setVgap(20);
		
		//entries
		entriesContainer.setLayout(layout);
		
		//init entries
		entry1 = newEntryUI(name1, score1);
		entry2 = newEntryUI(name2, score2);
		entry3 = newEntryUI(name3, score3);
		entry4 = newEntryUI(name4, score4);
		entry5 = newEntryUI(name5, score5);
		
		//add entries to container
		entriesContainer.add(entry1);
		entriesContainer.add(entry2);
		entriesContainer.add(entry3);
		entriesContainer.add(entry4);
		entriesContainer.add(entry5);
		
		//add container to root
		rootPanel.add(entriesContainer);
		
	}
	
	/**
	 * Adds a highscore to 
	 * @param index 0 to 9, 0 being at the top
	 * @param name the player's name
	 * @param score the highscore entry
	 */
	public void addHighscore(int index, String name, int score) {
		
		
		
		//decide which entry to add to
		switch (index) {
		case 1:
			name1.setText(name);
			score1.setText("" + score);
			
			break;

		default:
			//throw error
			break;
		}
		
	}
	
	/**
	 * Creates a highscore entry 
	 * @param name the player's name
	 * @param score the player's score
	 * @return entry a Panel containing the player's name and score
	 */
	public PanelUI newEntryUI(JLabel name, JLabel score) {
		PanelUI entry = new PanelUI(entriesSize, Color.white);
		
		entry.setLayout(new BoxLayout(entry, BoxLayout.X_AXIS));
		entry.add(Box.createHorizontalStrut(20));
		entry.add(name);
		entry.add(Box.createGlue());
		entry.add(score);
		entry.add(Box.createHorizontalStrut(20));
		return entry;
	}
	
	/**
	 * shows or hide the view
	 * @param visibility the visibility to be set
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	/**
	 * inserts root panel to gameFrame
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}
	

	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

}
