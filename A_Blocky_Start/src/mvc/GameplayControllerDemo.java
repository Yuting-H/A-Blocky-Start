package mvc;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameplayControllerDemo implements Controller {

	public static JFrame testFrame = new JFrame(); // TODO
	public static GameplayViewDemo view = new GameplayViewDemo();
	
	
	/**
	 * TODO: Test Main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		
		testFrame.setLayout(null);
		testFrame.setVisible(true);  
		testFrame.setResizable(false);
		testFrame.setSize(new Dimension(800, 600));
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameplayControllerDemo controller = new GameplayControllerDemo();
		
		controller.OnEnter();
	}
	
	/**
	 * Constructor.
	 */
	public GameplayControllerDemo() {
		view.insertPanelToFrame();
		populateActionListener();
	}
	
	/**
	 * Help to insert action listeners to UI elements.
	 */
	private void populateActionListener() {
		// TODO
	}


	@Override
	public void OnEnter() {
		view.setVisibility(true);
		view.setPauseMenuVisibility(true);
	}


	@Override
	public void OnExit() {
		view.setVisibility(false);
		view.setPauseMenuVisibility(false);
	}

}
