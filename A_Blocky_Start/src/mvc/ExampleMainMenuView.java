package mvc;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * This is the Example View class
 */
public class ExampleMainMenuView {
	
	//create instance of JPanle, this will be the base of the view
	private JPanel panel;
	
	/**
	 * Constructor 
	 */
	public ExampleMainMenuView() {
		
		//creates a new JPnale as base
		panel = new JPanel();
		
		//adds aesthetic to base
		this.initPanel();
	}
	
	/**
	 * Add buttons, set size etc to JPanle
	 * Not a constructor
	 */
	private void initPanel() {
		
		panel.setVisible(true);
		panel.setBackground(Color.magenta);
		panel.setSize(800,600);
		
	}
	
	/**
	 * This method inserts the panel into the gameFrame
	 * This should only be called once
	 */
	public void insertPanel() {
		Main.gameFrame.add(panel);
	}
	
	/**
	 * This method sets the visibilty of the view
	 * @param visibility
	 */
	public void setVisible(boolean visibility) {
		panel.setVisible(visibility);
	}
	

}
