package mvc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

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
	private Dimension viewSize = new Dimension(800, 600);
	private Dimension backButtonSize = new Dimension(30,30);
	private Dimension containerSize = new Dimension(785, 490);
	private Dimension entryContainerSize = new Dimension(500, 200);
	
	//define locations
	private Point backButtonLocation = new Point(10,10);
	private Point containerLocation = new Point(0, 50);  //contains Pro
	
	//define UI
	private JPanel rootPanel;
	private ButtonUI backButton;
	private ContainerUI container;
	private JScrollPane scrollPane;
	
	private PanelUI entry1 = new PanelUI(entryContainerSize, Color.magenta);
	
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
		
		//added go back button to prrogression
		backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconsUI.backButtonIcon);
		rootPanel.add(backButton);
		
		entry1.setPreferredSize(new Dimension(600, 50));
		
		//set up container 
		container = new ContainerUI(containerLocation, containerSize, Color.white);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBorder(new EmptyBorder(new Insets(50, 20, 0, 20)));
		container.add(entry1);
		container.add(Box.createVerticalStrut(1000));
		
		
		
		
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
	 * This method adds a progression record to the screen
	 */
	public void appendProgression() {
		//TODO: implement
	}
	
	/**
	 * 
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
