package mvc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GameplayControllerDemo implements Controller {

	public static JFrame testFrame = new JFrame(); // TODO
	public static GameplayViewDemo view = new GameplayViewDemo();
	
	
	/**
	 * TODO: Test Main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(new Dimension(850, 650));
		testFrame.setResizable(true);
		testFrame.setLayout(null);
		testFrame.setVisible(true);
		
		
		GameplayControllerDemo controller = new GameplayControllerDemo();
		
		controller.OnEnter();
	}
	
	/**
	 * Constructor.
	 */
	public GameplayControllerDemo() {
		view.insertPanelToFrame(GameplayControllerDemo.testFrame);
		populateActionListener();
	}
	
	/**
	 * Help to insert action listeners to UI elements.
	 */
	private void populateActionListener() {
		view.iconPauseMenuButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setPauseMenuVisibility(true);
				System.out.println("iconPauseMenuButton"); // TODO
			}
		});
		
		view.iconRunChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setRunPauseChainButton(false);
				System.out.println("iconRunChainButton"); // TODO
			}
		});
		
		view.iconPauseChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setRunPauseChainButton(true);
				System.out.println("iconPauseChainButton"); // TODO
			}
		});
		
		view.iconResetChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconResetChainButton"); // TODO
			}
		});
		
		view.iconObjectivesButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconObjectivesButton"); // TODO
			}
		});
		
		view.iconHintsButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconHintsButton"); // TODO
			}
		});
		
		view.iconTypeChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconTypeChainButton"); // TODO
			}
		});
		
		view.backButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setPauseMenuVisibility(false);
				System.out.println("backButton"); // TODO
			}
		});
		
		view.saveButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("saveButton"); // TODO
			}
		});
		
		view.tutorialButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("tutorialButton"); // TODO
			}
		});
		
		view.settingsButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("settingsButton"); // TODO
			}
		});
		
		view.mainMenuButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("mainMenuButton"); // TODO
			}
		});
	}


	@Override
	public void OnEnter() {
		view.setVisibility(true);
		view.setPauseMenuVisibility(false);
	}


	@Override
	public void OnExit() {
		view.setVisibility(false);
		view.setPauseMenuVisibility(false);
	}

}
