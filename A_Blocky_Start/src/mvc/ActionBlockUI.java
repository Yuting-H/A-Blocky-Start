package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;

public class ActionBlockUI extends JPanel {

	private static final int subpanelWidth = 300;
	private static final int subpanelHeight = 50;
	private static final Dimension numberFieldSize = new Dimension(50, 30);
	
	SpinnerUI lineNumberField;
	SpinnerUI endPointField;
	SpinnerUI startPointField;
	SpinnerUI jumpLineField;
	LabelUI actionIcon;
	LabelUI actionText;
	LabelUI jumpText;
	LabelUI immediatelyText;
	LabelUI afterwardsText;
	LabelUI minusText;
	LabelUI counterText;
	
	public ActionBlockUI(int lineNumber, ActionTypeEnum type, int endPoint, int startPoint, int jumpLine) {
		lineNumberField = new SpinnerUI(numberFieldSize, null, lineNumber, -1, 999, -1);
		endPointField = new SpinnerUI(numberFieldSize, null, endPoint, -999, 999, -1);
		startPointField = new SpinnerUI(numberFieldSize, null, startPoint, -999, 999, -1);
		jumpLineField = new SpinnerUI(numberFieldSize, null, jumpLine, -1, 999, -1);
		actionIcon = new LabelUI(new Dimension(50, 50), null, IconUI.pauseMenuButtonIcon);
		actionText = new LabelUI(new Dimension(100, 50), null, type.toString());
		jumpText = new LabelUI(new Dimension(100, 50), null, "jump to line =");
		immediatelyText = new LabelUI(new Dimension(100, 50), null, "immediately");
		afterwardsText = new LabelUI(new Dimension(100, 50), null, "afterwards");
		minusText = new LabelUI(new Dimension(50, 50), null, "minus");
		counterText = new LabelUI(new Dimension(150, 50), null, "");
		
		setVisible(true);
		setLayout(null);
		
		if (type == ActionTypeEnum.LOOP) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 3));
		} else if (type == ActionTypeEnum.GOTO) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 2));
		} else if (type != ActionTypeEnum.UNKNOWN) {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 1));
		} else {
			setSize(new Dimension(subpanelWidth, subpanelHeight * 1)); // stage ID bar
		}
		
		if (type != ActionTypeEnum.UNKNOWN) {
			lineNumberField.setLocation(new Point(10, 10));
			add(lineNumberField);
			actionIcon.setLocation(new Point(60, 0));
			add(actionIcon);
			actionText.setLocation(new Point(110, 0));
			add(actionText);
		}
		
		if (type == ActionTypeEnum.LOOP) {
			endPointField.setLocation(new Point(10, 60));
			add(endPointField);
			startPointField.setLocation(new Point(110, 60));
			add(startPointField);
			jumpText.setLocation(new Point(10, 100));
			add(jumpText);
			jumpLineField.setLocation(new Point(110, 110));
			add(jumpLineField);
			afterwardsText.setLocation(new Point(165, 100));
			add(afterwardsText);
			minusText.setLocation(new Point(65, 50));
			add(minusText);
			counterText.setLocation(new Point(165, 50));
			add(counterText);
			setCounterText(endPoint - startPoint);
		}
		
		if (type == ActionTypeEnum.GOTO) {
			jumpText.setLocation(new Point(10, 50));
			add(jumpText);
			jumpLineField.setLocation(new Point(110, 60));
			add(jumpLineField);
			immediatelyText.setLocation(new Point(165, 50));
			add(immediatelyText);
		}
		
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		
		if (type != ActionTypeEnum.UNKNOWN) {
			setStatus(0);
		} else {
			setStatus(-1);
		}
	}
	
	public int getLineNumberField() {
		return (int) lineNumberField.getValue();
	}
	
	public int getEndPointField() {
		return (int) endPointField.getValue();
	}
	
	public int getStartPointField() {
		return (int) startPointField.getValue();
	}
	
	public int getJumpLineField() {
		return (int) jumpLineField.getValue();
	}
	
	public void setLineNumberField(int value) {
		lineNumberField.setValue(value);
		repaint();
		revalidate();
	}
	
	public void setEndPointField(int value) {
		endPointField.setValue(value);
		repaint();
		revalidate();
	}
	
	public void setStartPointField(int value) {
		startPointField.setValue(value);
		repaint();
		revalidate();
	}
	
	public void setJumpLineField(int value) {
		jumpLineField.setValue(value);
		repaint();
		revalidate();
	}
	
	public void setCounterText(int value) {
		counterText.setText("= (" + value + ") times");
		repaint();
		revalidate();
	}
	
	/**
	 * Mutate the status of the action block.
	 * @param status 0 if inactive, 1 if current, 2 if next.
	 */
	public void setStatus(int status) {
		if (status == 2) {
			setBackground(Color.ORANGE);
		} else if (status == 1) {
			setBackground(Color.GREEN);
		} else if (status == 0) {
			setBackground(Color.LIGHT_GRAY);
		} else {
			setBackground(Color.DARK_GRAY);
		}
		
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		repaint();
		revalidate();
	}
	
	// Change listeners
	public void lineNumberField(ChangeListener changeListener) {
		lineNumberField.addChangeListener(changeListener);
	}
	
	public void endPointField(ChangeListener changeListener) {
		endPointField.addChangeListener(changeListener);
	}
	
	public void startPointField(ChangeListener changeListener) {
		startPointField.addChangeListener(changeListener);
	}
	
	public void jumpLineField(ChangeListener changeListener) {
		jumpLineField.addChangeListener(changeListener);
	}
	
}
