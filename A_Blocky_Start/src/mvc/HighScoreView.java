package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	private ArrayList<PanelUI> entries = new ArrayList<PanelUI>();
	
	private ArrayList<LabelUI> nameEntries = new ArrayList<LabelUI>();
	
	private ArrayList<LabelUI> highScoreEntries = new ArrayList<LabelUI>();
	
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
		
		//adds 5 highscore entries
		for (int i = 0; i < 5; i++) {
			
			//create name and score label
			LabelUI currName = new LabelUI(entriesLabelSize, "DEFAULT_NAME");
			LabelUI currScore = new LabelUI(entriesLabelSize, "0");
			
			//create entry
			PanelUI curr  = newEntryUI(currName, currScore);
			
			//add entry, name and score label to list
			entries.add(curr);
			nameEntries.add(currName);
			highScoreEntries.add(currScore);
			
			entriesContainer.add(entries.get(i));
			
		}
		
		//add entries to container
		
		//add container to root
		rootPanel.add(entriesContainer);
		
	}
	
	/**
	 * Adds a highscore to 
	 * @param index 1 to 5, 0 being at the top
	 * @param name the player's name
	 * @param score the highscore entry
	 */
	public void addHighscore(int index, String name, int score) {
		
		
		
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
