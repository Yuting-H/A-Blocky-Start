package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollPaneUI extends JScrollPane {

	/**
	 * Creates an empty JScrollPane.<br>
	 * Used by GameplayView.<br>
	 * @param basePanel The JPanel that contains this JScrollPane
	 * @param direction 0 = horizontal scroll bar, 1 = vertical scroll bar, 2 = both
	 */
	public ScrollPaneUI(JPanel basePanel, int direction) {
		if (direction == 0) {
			setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
			setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
		} else if (direction == 1) {
			setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
			setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		} else {
			setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
			setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		}
		setWheelScrollingEnabled(true);
		setVisible(true);
		setSize(basePanel.getSize());
		setLocation(new Point(0, 0));
		setBackground(basePanel.getBackground());
	}
	
}
