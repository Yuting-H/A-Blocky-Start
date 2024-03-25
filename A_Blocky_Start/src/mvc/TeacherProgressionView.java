package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */
public class TeacherProgressionView {

	private Dimension viewSize = Main.getDimension();
	private Dimension backButtonSize = new Dimension(30, 30);
	private Dimension containerSize = new Dimension(785, 490);
	private Dimension entryContainerSize = new Dimension(500, 100);
	private Dimension labelSize = new Dimension(100, 20);
	private Dimension selectorSize = new Dimension(50, 20);

	// define locations
	private Point backButtonLocation = new Point(10, 10);
	private Point containerLocation = new Point(0, 50); // contains all student's progression
	private Point selectorLocation = new Point(700, 20); // page selector

	// define UI
	private JPanel rootPanel;
	private ButtonUI backButton;
	private ContainerUI container;
	private JScrollPane scrollPane;

	private SpinnerNumberModel model;
	private JSpinner pageSelector;

	private ArrayList<PanelUI> entries = new ArrayList<PanelUI>();

	/**
	 * 
	 */
	public TeacherProgressionView() {

		rootPanel = new JPanel();

		initPanel();
	}

	/**
	 * 
	 */
	private void initPanel() {
		// sets up root panel
		rootPanel.setSize(viewSize);
		rootPanel.setBackground(Color.red);
		rootPanel.setLayout(null);

		// added go back button to progression
		backButton = new ButtonUI(backButtonLocation, backButtonSize, "", IconUI.backButtonIcon);

		model = new SpinnerNumberModel(1, 0, 10, 1);
		pageSelector = new JSpinner(model);
		pageSelector.setLocation(selectorLocation);
		pageSelector.setSize(selectorSize);
		pageSelector.setVisible(false); // hides unwanted appearance

		rootPanel.add(backButton);
		rootPanel.add(pageSelector);
	}

	public void setEntry(int index, int stageID, boolean completed, int shortestSteps, int highScore, int timeSpent,
			int attempts) {
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
	}

	public void backButtonAddActionListener(ActionListener actionListener) {
		backButton.addActionListener(actionListener);
	}

	public void selectorAddActionListener(ChangeListener changeListener) {
		pageSelector.addChangeListener(changeListener);
	}
}
