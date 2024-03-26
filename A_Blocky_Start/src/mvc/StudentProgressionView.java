package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 * This class display the progression of a player
 * @author Yuting <br>
 * 
 */
public class StudentProgressionView{
	
	//Define sizes
	private Dimension viewSize = Main.getDimension();
	private Dimension backButtonSize = new Dimension(30,30);
	private Dimension containerSize = new Dimension(785, 490);
	private Dimension entryContainerSize = new Dimension(500, 100);
	private Dimension labelSize = new Dimension(100, 20);
	
	//define locations
	private Point backButtonLocation = new Point(10,10);
	private Point containerLocation = new Point(0, 50);  //contains all student's progression
	
	//define UI
	private JPanel rootPanel;
	private ButtonUI backButton;
	private PanelUI container;
	private JScrollPane scrollPane;
	
	//
	private ArrayList<PanelUI> entries = new ArrayList<PanelUI>();
	
	/**
	 * constructor for displaying
	 */
	public StudentProgressionView(){
		
		rootPanel = new JPanel();
		
		initPanel();
	}
	
	/**
	 * 
	 */
	private void initPanel() {
		
		//set up progression panel
		rootPanel.setSize(viewSize);
		rootPanel.setBackground(Color.BLUE);
		rootPanel.setLayout(null);
		
		//added go back button to progression
		backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconUI.backButtonIcon);
		rootPanel.add(backButton);
		
		//set up container 
		container = new PanelUI(containerLocation, containerSize, Color.white);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));  //set layout
		container.setBorder(new EmptyBorder(new Insets(10, 50, 0, 50)));  //inset space
		
		//adds 10 progression to container
		for (int i = 0; i < 9; i++) {
			
			PanelUI curr = newEntry();  //create empty container
			
			entries.add(curr);  //add empty container to list
			container.add(entries.get(i));  //add the containers from list to screen
			container.add(Box.createVerticalStrut(20));  //spacing between each progression
			
		}

		//botton margin
		container.add(Box.createVerticalStrut(100));
		
		//init scroll bar, container is converted
		scrollPane = new JScrollPane(container);
		
		//change scroll bar settings
		scrollPane.setSize(containerSize);
		scrollPane.setLocation(containerLocation);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(false);
		
		//adding scrollable container to progression panel
		rootPanel.add(scrollPane);
		
		setVisibility(false);  //stops unwanted panel apperence
	}
	
	/**
	 * 
	 * @param index the index of the progression
	 * TODO: this function needs to display progression data
	 */
	public void setEntry(int index, int stageID, boolean completed, int shortestSteps, int highScore, int timeSpent, int attempts) {
		
		PanelUI entry = entries.get(index);
		
		entry.setLayout(new FlowLayout());
		
		LabelUI stageIDUI = new LabelUI(labelSize, "" + stageID);
		LabelUI completedUI = new LabelUI(labelSize, "Completed: " + completed);
		LabelUI shortestStepsUI = new LabelUI(labelSize, "" + shortestSteps);
		LabelUI highestScoreUI = new LabelUI(labelSize, "" + highScore);
		LabelUI timeSpentUI = new LabelUI(labelSize, "" + timeSpent);
		LabelUI attemptsUI = new LabelUI(labelSize, "" + attempts);
		ButtonUI playButton = new ButtonUI(labelSize, "Play");
		
		entry.add(stageIDUI);
		entry.add(completedUI);
		entry.add(shortestStepsUI);
		entry.add(highestScoreUI);
		entry.add(timeSpentUI);
		entry.add(attemptsUI);
		entry.add(playButton);
	}
	
	/**
	 * This method adds a empty progression record container to the screen
	 */
	public PanelUI newEntry() {
		
		//create a new PanelUI
		PanelUI entry = new PanelUI(entryContainerSize);
		
		return entry;
	}
	
	/**
	 * Adds root panel to game frame
	 */
	public void insertPanelToFrame() {
		Main.gameFrame.add(rootPanel);
	}
	
	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
		backButton.setVisible(visibility);
		scrollPane.setVisible(visibility);
	}
	
	/**
	 * 
	 * @param actionListener
	 */
	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

}
