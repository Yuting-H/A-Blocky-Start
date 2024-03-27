package mvc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameplayControllerDemo implements Controller {

	public static JFrame testFrame = new JFrame(); // TODO remove this
	public static GameplayViewDemo view = new GameplayViewDemo();
	public static UserData user = UserData.importData("brucelee"); // TODO remove this
	public static ProgressionData progress = user.getProgressionAtIndex(4); // TODO use a setter
	public static ActionChainData chain = progress.getActionChain();
	
	/**
	 * TODO: Test Main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(new Dimension(0, 0));
		testFrame.setResizable(false);
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
		rebuildActionChainUI();
	}
	
	/**
	 * Help to insert action listeners to UI elements.
	 */
	private void populateActionListener() {
		
		// Pause menu buttons
		
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
		
		// Icon buttons
		
		view.pauseMenuButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setPauseMenuVisibility(true);
				System.out.println("iconPauseMenuButton"); // TODO
			}
		});
		
		view.runChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setRunPauseChainButton(false);
				System.out.println("iconRunChainButton"); // TODO
			}
		});
		
		view.pauseChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setRunPauseChainButton(true);
				System.out.println("iconPauseChainButton"); // TODO
			}
		});
		
		view.resetChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconResetChainButton"); // TODO
			}
		});
		
		view.objectivesButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconObjectivesButton"); // TODO
			}
		});
		
		view.hintsButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("iconHintsButton"); // TODO
			}
		});
		
		view.debugChainButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.refrestActionChainUI(); // TODO delete this line
				System.out.println(chain.exportData()); // TODO delete this line
				System.out.println("iconTypeChainButton"); // TODO
			}
		});
		
		// Action buffet buttons
		
		view.addForwardButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.FORWARD;
				ArrayList<Integer> args = new ArrayList<Integer>();
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addForwardButton"); // TODO
			}
		});
		
		view.addBackButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.BACK;
				ArrayList<Integer> args = new ArrayList<Integer>();
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addBackButton"); // TODO
			}
		});
		
		view.addLeftButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.LEFT;
				ArrayList<Integer> args = new ArrayList<Integer>();
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addLeftButton"); // TODO
			}
		});
		
		view.addRightButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.RIGHT;
				ArrayList<Integer> args = new ArrayList<Integer>();
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addRightButton"); // TODO
			}
		});
		
		view.addGotoButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.GOTO;
				ArrayList<Integer> args = new ArrayList<Integer>();
				args.add(1); // jump line
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addGotoButton"); // TODO
			}
		});
		
		view.addLoopButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionTypeEnum type = ActionTypeEnum.LOOP;
				ArrayList<Integer> args = new ArrayList<Integer>();
				args.add(0); // end point
				args.add(0); // start point
				args.add(1); // jump line
				chain.addBeforeEnd(new ActionBlockData(type, args));
				
				rebuildActionChainUI();
				System.out.println("addLoopButton"); // TODO
			}
		});
	}
	
	public void rebuildActionChainUI() {
		view.clearActionChainUI();
		
		for (int i = 0; i <= chain.getIndexEnd(); i++) {
			ActionBlockData block = chain.getActionBlock(i);
			ActionBlockUI blockUI = new ActionBlockUI(i, block.getType(), block.getEndPoint(), block.getStartPoint(), block.getJumpLine());
			
			blockUI.lineNumberField(new LineNumberListener(blockUI, i));
			blockUI.endPointField(new EndPointListener(blockUI, block));
			blockUI.startPointField(new StartPointListener(blockUI, block));
			blockUI.jumpLineField(new JumpLineListener(blockUI, block));
			
			view.appendActionBlockUI(i, blockUI);
		}
		
		view.refrestActionChainUI();
	}
	
	/**
	 * Set progression data for this stage.
	 * @param progressionData progression data for this stage
	 */
	public void setProgressionData(ProgressionData progressionData) {
		progress = progressionData;
	}

	@Override
	public void OnEnter() {
		view.setVisibility(true);
		view.setPauseMenuVisibility(false);
		testFrame.setSize(new Dimension(815, 640));
	}


	@Override
	public void OnExit() {
		view.setVisibility(false);
		view.setPauseMenuVisibility(false);
		testFrame.setSize(new Dimension(800, 600));
	}
	
	
	
	
	// Custom ChangeListeners
	
	private class LineNumberListener implements ChangeListener {

		private ActionBlockUI blockUI;
		private int blockIndex;
		
		public LineNumberListener(ActionBlockUI blockUI, int blockIndex) {
			this.blockUI = blockUI;
			this.blockIndex = blockIndex;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int valueOld = blockIndex;
			int valueNew = blockUI.getLineNumberField();
			
			System.out.println("LineNumberListener");
			boolean success = chain.swap(valueOld, valueNew);
			if (!success) {
				blockUI.setLineNumberField(valueOld);
				System.out.println("Error");
				return;
			}
			rebuildActionChainUI();
		}
		
	}
	
	private class EndPointListener implements ChangeListener {

		private ActionBlockUI blockUI;
		private ActionBlockData block;
		
		public EndPointListener(ActionBlockUI blockUI, ActionBlockData block) {
			this.blockUI = blockUI;
			this.block = block;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int valueOld = block.getEndPoint();
			int valueNew = blockUI.getEndPointField();
			
			System.out.println("EndPointListener");
			boolean success = block.setEndPoint(valueNew);
			if (!success) {
				blockUI.setEndPointField(valueOld);
				System.out.println("Error");
				return;
			}
			
			blockUI.setCounterText(block.getCounter());
		}
		
	}
	
	private class StartPointListener implements ChangeListener {

		private ActionBlockUI blockUI;
		private ActionBlockData block;
		
		public StartPointListener(ActionBlockUI blockUI, ActionBlockData block) {
			this.blockUI = blockUI;
			this.block = block;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int valueOld = block.getStartPoint();
			int valueNew = blockUI.getStartPointField();
			
			System.out.println("StartPointListener");
			boolean success = block.setStartPoint(valueNew);
			if (!success) {
				blockUI.setStartPointField(valueOld);
				System.out.println("Error");
				return;
			}

			blockUI.setCounterText(block.getCounter());
		}
		
	}
	
	private class JumpLineListener implements ChangeListener {

		private ActionBlockUI blockUI;
		private ActionBlockData block;
		
		public JumpLineListener(ActionBlockUI blockUI, ActionBlockData block) {
			this.blockUI = blockUI;
			this.block = block;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int valueOld = block.getJumpLine();
			int valueNew = blockUI.getJumpLineField();
			
			System.out.println("JumpLineListener");
			boolean success = block.setJumpLine(valueNew);
			if (!success) {
				blockUI.setJumpLineField(valueOld);
				System.out.println("Error1");
				return;
			}
			
			success = (valueNew >= chain.getIndexStart() && valueNew <= chain.getIndexEnd());
			if (!success) {
				block.setJumpLine(valueOld);
				blockUI.setJumpLineField(valueOld);
				System.out.println("Error2");
				return;
			}
		}
		
	}

}
