package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class MainMenuController implements Controller{
	
	//Main menu view
	private static MainMenuView view = new MainMenuView();
	
	/**
	 * Main menu controller constuctor
	 * Called in Main
	 */
	public MainMenuController() {
		view.insertPanelToFrame();
		
		populateActionListener();
	}
	
	/**
	 * Adds functionality to UI elements
	 */
	private void populateActionListener() {
		
		//continue button
		view.continueButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//for debug purpose, continue button leads to gameplay view
				Main.mainMenuController.OnExit();
				Main.gameplayController.OnEnter();
				
				
				//TODO: implement this
			}
		});
		
		//new game button
		view.newGameButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add action
			}
		});
		
		//tutorial button
		view.tutorialButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.mainMenuController.OnExit();
				Main.tutorialController.onEnter();
			}
		});
		
		//progression button
		view.progressionButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Main.mainMenuController.OnExit();
				System.out.println(Main.loginController.getMode());
				if (Main.loginController.getMode() == UserTypeEnum.TEACHER) {
					Main.teacherProgressionController.OnEnter();
				}else {
					Main.studentProgressionController.OnEnterSpecial(Main.mainMenuController);
				}
				
				
				
			}
		});
		
		//high score button
		view.highscoreButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.mainMenuController.OnExit();
				Main.highScoreController.OnEnter();
			}
		});
		
		//setting button
		view.settingsButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.mainMenuController.OnExit();
				Main.settingsController.OnEnter();
			}
		});
		
		//exit application when exit button is clicked
		view.exitButtonAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * Is called when entering main menu
	 */
	@Override
	public void OnEnter() {
		
		//shows the view
		view.setVisibility(true);
	}

	/**
	 * Is called when exiting 
	 */
	@Override
	public void OnExit() {
		
		//hides the view
		view.setVisibility(false);
	}
	
}
