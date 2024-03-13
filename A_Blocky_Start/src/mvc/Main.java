package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Yuting
 *
 */
public class Main {
	
	//creates global JFrame
	 public static JFrame gameFrame = new JFrame();
	 
	 //creates controllers
	 public static ExampleMainMenuController exampleMainMenuController = new ExampleMainMenuController();
	 //TODO: create controllers 

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		configureGameFrame(); 
		exampleMainMenuController.OnEnter(); //Load First screen
		
	}
	
	/**
	 * Customize global gameFrame
	 */
	public static void configureGameFrame() {
		
		//sets up the game frame
		gameFrame.setLayout(null);
		gameFrame.setVisible(true);  
		gameFrame.setResizable(false);
		gameFrame.setSize(800, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//insert all screens to gameFrame
		ExampleMainMenuController.insertPanel();
		//TODO: implement all controller.insertPanel
		
	}
	
}
