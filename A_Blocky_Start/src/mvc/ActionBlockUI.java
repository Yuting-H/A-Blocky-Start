package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ActionBlockUI extends JPanel {

	private static final int subpanelWidth = 250;
	private static final int subpanelHeight = 50;
	
	PanelUI namePanel;
	PanelUI loopPanel;
	PanelUI jumpPanel;
	
	public ActionBlockUI(int lineNumber, ActionTypeEnum type, int endPoint, int startPoint, int jumpLine) {
		setVisible(true);
		setBackground(Color.CYAN);
		
		if (type == ActionTypeEnum.LOOP) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 3));
		} else if (type == ActionTypeEnum.GOTO) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 2));
		} else if (type != ActionTypeEnum.UNKNOWN) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 1));
		} else {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 0));
		}
		
		if (type != ActionTypeEnum.UNKNOWN) {
			namePanel = new PanelUI(true, new Dimension(subpanelWidth -30, subpanelHeight -30), new Point(0, 0), Color.RED);
			add(namePanel);
		}
		
		if (type == ActionTypeEnum.LOOP) {
			loopPanel = new PanelUI(true, new Dimension(subpanelWidth -30, subpanelHeight -30), new Point(0, subpanelHeight), Color.GREEN);
			add(loopPanel);
		}
		
		if ((type == ActionTypeEnum.GOTO) || (type == ActionTypeEnum.LOOP)) {
			jumpPanel = new PanelUI(true, new Dimension(subpanelWidth -30, subpanelHeight -30), new Point(0, subpanelHeight *2), Color.BLUE);
			add(jumpPanel);
		}
	}
	
	
	
}
