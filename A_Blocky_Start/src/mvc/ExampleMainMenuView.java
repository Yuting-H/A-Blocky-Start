package mvc;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the Example View class
 * @deprecated
 */
public class ExampleMainMenuView implements View {
	
	// create instance of JPanle, this will be the base of the view
	private JPanel rootPanel;
	
	/**
	 * Constructor.
	 */
	public ExampleMainMenuView() {
		initPanel();
		setVisibility(false);
	}
	
	@Override
	public void initPanel() {
		
		rootPanel = new JPanel();
		rootPanel.setVisible(true);
		rootPanel.setBackground(Color.magenta);
		rootPanel.setSize(800,600);
		
	}
	
	@Override
	public void refreshPanel() {
		rootPanel.repaint();
		rootPanel.revalidate();
	}
	
	@Override
	public void insertPanelToFrame(JFrame frame) {
		frame.add(rootPanel);
	}
	
	@Override
	public void setVisibility(boolean visibility) {
		rootPanel.setVisible(visibility);
	}
	
	// Action Listeners

}
